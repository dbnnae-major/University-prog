package classes;

import database.DataBaseManager;
import database.User;
import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс ответственный за коллекцию.
 */
public class Routestorage implements Serializable {

    private static final long serialVersionUID = 4123123L;
    private transient Scanner scanner = new Scanner(System.in);
    private transient Date date;
    private transient Server server;
    private LinkedHashMap<Integer, Route> map;

    public Routestorage(Server server) {
        map = new LinkedHashMap<Integer, Route>();
        this.date = new Date();
        this.server = server;
    }


    public void setCollection(LinkedHashMap map) {
        this.map = map;
    }

    public int getLength() {
        return map.size();
    }

    public Date getDate() {
        return date;
    }

    /**
     * Удаляет элемент из коллекции.
     */
    public void removeobject(int key) {
        if (map.containsKey(key)) {
            server.sendMessageToClient("Remove_key: Объект удален.");
            map.remove(key);
        } else server.sendMessageToClient("Remove_key: ОШИБКА: Данного ключа не найдено!");
    }

    /**
     * Полностью отчищает коллекцию.
     */
    public void clear(User user) {
        Set<Integer> keysToRemove = new HashSet<>();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if (entry.getValue().getOwner().equals(user.getUsername())) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (Integer key : keysToRemove) {
            map.remove(key);
        }
    }

    /**
     * Удаляет все элементы из коллекции которые больше чем введенный.
     */
    public void remove_greater(Route route, User user, DataBaseManager dataBaseManager) {
        Set<Integer> keysToRemove = new HashSet<>();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if (route.compareTo(entry.getValue()) < 0 && entry.getValue().getOwner().equals(user.getUsername())) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (Integer key : keysToRemove) {
            map.remove(key);
            dataBaseManager.deleteRoutesByKeyFromDataBase(key, user);
        }
    }

    /**
     * Удаляет все элементы из коллекции которые меньше чем введенный.
     */
    public void remove_lower(Route route, User user, DataBaseManager dataBaseManager) {
        Set<Integer> keysToRemove = new HashSet<>();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if (route.compareTo(entry.getValue()) > 0 && entry.getValue().getOwner().equals(user.getUsername())) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (Integer key : keysToRemove) {
            map.remove(key);
            dataBaseManager.deleteRoutesByKeyFromDataBase(key, user);
        }
    }

    /**
     * Удаляет все элементы из коллекции ключ которых меньше чем введенный.
     */
    public void remove_lower_key(int id, User user, DataBaseManager dataBaseManager) {
        Set<Integer> keysToRemove = new HashSet<>();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if (entry.getKey() < id && entry.getValue().getOwner().equals(user.getUsername())) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (Integer key : keysToRemove) {
            map.remove(key);
            dataBaseManager.deleteRoutesByKeyFromDataBase(key, user);
        }
    }

    /**
     * Меняет элемент с заданным ключом на введенный.
     */
    public void updateobject(Route route) {
        map.put(route.getId(), route);
        server.sendMessageToClient("Объект Обновлен.");
    }

    /**
     * Добавляет элемент в коллекцию.
     */
    public void addobject(Route route) {
        map.put(route.getId(), route);
    }

    public String getContainType() {
        return Route.class.getSimpleName();
    }

    public String getType() {
        return "LinkedHashMap";
    }

    public LinkedHashMap getCollection() {
        return map;
    }

    public void sort() {
        LinkedHashMap<Integer, Route> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        map = sortedMap;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Коллекция Routestorage хранит в себе: " + "\n");
        map.forEach((key, value) -> {
            sb.append("Ключ: ").append(key).append("\nЗначение: ").append(value).append("\n");
        });
        return sb.toString();
    }
}
