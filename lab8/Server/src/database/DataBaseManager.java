package database;

import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;
import exceptions.InvalidDBOutputException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataBaseManager {
    private String DataBaseUsername;
    private String DataBasePassword;
    private final String URL = "jdbc:postgresql://localhost:9999/studs";
    //    private final String URL = "jdbc:postgresql://pg:5432/studs";
    private Connection connection;
    private Scanner credentials;
    private Boolean signUpFlag = false;
    private Boolean loginFlag = false;
    private final Lock lock = new ReentrantLock();

    public Boolean getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(Boolean loginFlag) {
        this.loginFlag = loginFlag;
    }

    public Boolean getSignUpFlag() {
        return signUpFlag;
    }

    public void setSignUpFlag(Boolean signUpFlag) {
        this.signUpFlag = signUpFlag;
    }

    public void connect() {
        try {
            credentials = new Scanner(new FileReader("src/credentials.txt"));
        } catch (FileNotFoundException e) {
            System.err.println("Не найден credentials.txt с данными для входа в базу данных.");
            System.exit(-1);
        }

        try {
            DataBaseUsername = credentials.nextLine().trim();
            DataBasePassword = credentials.nextLine().trim();

        } catch (NoSuchElementException e) {
            System.err.println("Не найдены данные для входа в файле credentials.txt.");
            System.exit(-1);
        }

        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(URL, DataBaseUsername, DataBasePassword);
            System.out.println("Подключение к базе данных установленно.");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Не удалось установить соединение с базой данных.");
            System.exit(-1);
        }
    }

    public void signUpUser(User user) throws SQLException {
        if (userExistCheck(user)) signUpFlag = false;
        else {
            PreparedStatement addStatement = connection.prepareStatement(Const.ADD_USER_REQUEST);
            addStatement.setString(1, user.getUsername());
            addStatement.setString(2, DataHasher.encryptStringMD2(user.getPassword()));
            addStatement.executeUpdate();
            addStatement.close();
            signUpFlag = true;
        }
    }

    public Boolean userExistCheck(User user) throws SQLException {
        PreparedStatement findStatement = connection.prepareStatement(Const.FIND_USERNAME_REQUEST);
        findStatement.setString(1, user.getUsername());
        ResultSet result = findStatement.executeQuery();
        result.next();
        int count = result.getInt(1);
        findStatement.close();
        if (count == 1) return true;
        return false;
    }

    public void loginUser(User user) throws SQLException {
        if (!userExistCheck(user)) loginFlag = false;
        else {
            PreparedStatement findStatement = connection.prepareStatement(Const.SELECT_USERNAME_PASSWORD_FROM_USERS_REQUEST);
            findStatement.setString(1, user.getUsername());
            ResultSet result = findStatement.executeQuery();
            result.next();
            String username = result.getString(Const.USER_USERNAME);
            String password = result.getString(Const.USER_PASSWORD);

            if (user.getUsername().equals(username) & DataHasher.encryptStringMD2(user.getPassword()).equals(password)) {
                loginFlag = true;
            }
        }
    }

    public LinkedHashMap<Integer, Route> loadCollectionFromDataBase() {
        LinkedHashMap<Integer, Route> collection = new LinkedHashMap<Integer, Route>();
        try {
            PreparedStatement joinStatement = connection.prepareStatement(Const.SELECT_ALL_FROM_ROUTES_REQUEST);
            ResultSet result = joinStatement.executeQuery();

            while (result.next()) {
                try {
                    Route route = extractRouteFromResult(result);
                    collection.put(route.getId(), route);
                } catch (InvalidDBOutputException e) {
                    System.out.println("Неверный объект");
                    continue;
                }
            }

            joinStatement.close();
            System.out.println("Коллекция успешно загружена из базы данных. Количество элементов: " + collection.size());
        } catch (SQLException e) {
            System.out.println("Произошла ошибка при загрузке коллекции из базы данных. Завершение работы.");
            e.printStackTrace();
            System.exit(-1);
        }
        return collection;
    }

    private Route extractRouteFromResult(ResultSet result) throws SQLException, InvalidDBOutputException {
        String owner = result.getString(Const.ROUTES_OWNER);
        int key = result.getInt(Const.ROUTES_ID);
        String name1 = result.getString(Const.ROUTES_NAME);
        double x1 = result.getDouble(Const.ROUTES_COORDINATES_X);
        double y1 = result.getDouble(Const.ROUTES_COORDINATES_Y);
        float y2 = result.getFloat(Const.ROUTES_LOCATION1_Y);
        int x2 = result.getInt(Const.ROUTES_LOCATION1_X);
        String name2 = result.getString(Const.ROUTES_LOCATION1_NAME);
        int x3 = result.getInt(Const.ROUTES_LOCATION2_X);
        double y3 = result.getDouble(Const.ROUTES_LOCATION2_Y);
        double z3 = result.getDouble(Const.ROUTES_LOCATION2_Z);
        String name3 = result.getString(Const.ROUTES_LOCATION2_NAME);
        float distance = result.getFloat(Const.ROUTES_DISTANCE);
        Date creationDate = result.getDate(Const.ROUTES_DATE);
        if (x1 > 550 || name2.isEmpty() || name3.isEmpty() || name3.length() > 488 || distance < 1 || name1.isEmpty())
            throw new InvalidDBOutputException();

        Coordinates coordinates = new Coordinates(x1, y1);
        Location1 location1 = new Location1(x2, y2, name2);
        Location2 location2 = new Location2(x3, y3, z3, name3);

        return new Route(key, name1, creationDate, coordinates, location1, location2, distance, owner);
    }

    public void addRouteToDataBase(Route route) {
        lock.lock();
        if (route.getId() == 0) {
            try {
                PreparedStatement addStatement = connection.prepareStatement(Const.ADD_ROUTES_REQUEST);
                addStatement.setString(1, route.getOwner());
//            addStatement.setInt(2, route.getId());
                addStatement.setString(2, route.getName());
                addStatement.setDouble(3, route.getCoordinates().getX());
                addStatement.setDouble(4, route.getCoordinates().getY());
//            java.sql.Date sqlDate = new java.sql.Date(route.getCreationDate().getTime());
                addStatement.setDate(5, new java.sql.Date(route.getCreationDate().getTime()));
                addStatement.setInt(6, route.getFrom().getX());
                addStatement.setFloat(7, route.getFrom().getY());
                addStatement.setString(8, route.getFrom().getName());
                addStatement.setInt(9, route.getTo().getX());
                addStatement.setDouble(10, route.getTo().getY());
                addStatement.setDouble(11, route.getTo().getZ());
                addStatement.setString(12, route.getTo().getName());
                addStatement.setFloat(13, route.getDistance());
                addStatement.executeUpdate();
                addStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                rollback();
            } finally {
                lock.unlock();
            }
        } else {
            try {
                PreparedStatement addStatement = connection.prepareStatement(Const.ADD_ROUTES_REQUEST);
                addStatement.setString(1, route.getOwner());
                addStatement.setInt(2, route.getId());
                addStatement.setString(3, route.getName());
                addStatement.setDouble(4, route.getCoordinates().getX());
                addStatement.setDouble(5, route.getCoordinates().getY());
//            java.sql.Date sqlDate = new java.sql.Date(route.getCreationDate().getTime());
                addStatement.setDate(6, new java.sql.Date(route.getCreationDate().getTime()));
                addStatement.setInt(7, route.getFrom().getX());
                addStatement.setFloat(8, route.getFrom().getY());
                addStatement.setString(9, route.getFrom().getName());
                addStatement.setInt(10, route.getTo().getX());
                addStatement.setDouble(11, route.getTo().getY());
                addStatement.setDouble(12, route.getTo().getZ());
                addStatement.setString(13, route.getTo().getName());
                addStatement.setFloat(14, route.getDistance());
                addStatement.executeUpdate();
                addStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                rollback();
            } finally {
                lock.unlock();
            }
        }
    }

    public void updateRouteToDataBase(Route route) {
        lock.lock();
        try {
            PreparedStatement addStatement = connection.prepareStatement(Const.UPDATE_ROUTES_REQUEST);
            addStatement.setString(1, route.getName());
            addStatement.setDouble(2, route.getCoordinates().getX());
            addStatement.setDouble(3, route.getCoordinates().getY());
            addStatement.setDate(4, new java.sql.Date(route.getCreationDate().getTime()));
            addStatement.setInt(5, route.getFrom().getX());
            addStatement.setFloat(6, route.getFrom().getY());
            addStatement.setString(7, route.getFrom().getName());
            addStatement.setInt(8, route.getTo().getX());
            addStatement.setDouble(9, route.getTo().getY());
            addStatement.setDouble(10, route.getTo().getZ());
            addStatement.setString(11, route.getTo().getName());
            addStatement.setFloat(12, route.getDistance());
            addStatement.setInt(13, route.getId());
            addStatement.executeUpdate();
            addStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        } finally {
            lock.unlock();
        }
    }

    public Boolean isOwner(Route route) throws SQLException {
        PreparedStatement findStatement = connection.prepareStatement(Const.SELECT_ROUTES_OWNER_REQUEST);
        findStatement.setInt(1, route.getId());
        ResultSet result = findStatement.executeQuery();
        result.next();
        String owner = result.getString(Const.ROUTES_OWNER);
        findStatement.close();
        if (owner.equals(route.getOwner())) return true;
        return false;
    }

    public void deleteAllRoutesFromDataBase(User user) {
        lock.lock();
        try {
            PreparedStatement addStatement = connection.prepareStatement(Const.DELETE_ALL_ROUTES_REQUEST);
            addStatement.setString(1, user.getUsername());
            addStatement.executeUpdate();
            addStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        } finally {
            lock.unlock();
        }
    }

    public void deleteRoutesByKeyFromDataBase(int key, User user) {
        lock.lock();
        try {
            PreparedStatement addStatement = connection.prepareStatement(Const.DELETE_ROUTES_BY_KEY_REQUEST);
            addStatement.setInt(1, key);
            addStatement.setString(2, user.getUsername());
            addStatement.executeUpdate();
            addStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        } finally {
            lock.unlock();
        }
    }

    public void rollback() {
        try {
            connection.rollback();
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Не удалось откатить изменения.");
        }
    }
}
