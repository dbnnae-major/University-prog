package collectionCommands;

import classes.Routestorage;
import database.DataBaseManager;
import database.User;
import elements.Route;
import server.Server;

import java.io.Serializable;

/**
 * Класс для передачи между командами флагов, переменных, которые нужны для правильной работы.
 */
public class CommandData implements Serializable {
    private static final long serialVersionUID = 5824144243465154839L;
    private Route route = null;
    private int key = 0;

    public Routestorage getRoutestorage() {
        return routestorage;
    }

    public void setRoutestorage(Routestorage routestorage) {
        this.routestorage = routestorage;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public DataBaseManager getDataBaseManager() {
        return dataBaseManager;
    }

    public void setDataBaseManager(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    private Routestorage routestorage;
    private Server server;
    private DataBaseManager dataBaseManager;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;
    private Float distance = 0F;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name = "";

    public void setObject(Object object) {
        switch (object.getClass().toString()) {
            case "class elements.Route" -> route = (Route) object;
            case "class java.lang.Integer" -> key = (int) object;
            case "class java.lang.Float" -> distance = (Float) object;
            case "class java.lang.String" -> name = (String) object;
            case "class database.User" -> user = (User) object;
        }
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}