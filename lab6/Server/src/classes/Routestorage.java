package classes;

import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;
import server.Server;

import java.util.*;
import java.util.stream.Collectors;
/**
 * Класс ответственный за коллекцию.
 */
public class Routestorage {
    Scanner scanner = new Scanner(System.in);
    private Date date;
    private Server server;
    private LinkedHashMap<Integer, Route> map;

    public Routestorage(Server server) {
        map = new LinkedHashMap<Integer, Route>();
        this.date = new Date();
        this.server = server;
    }


    public void setCollection(LinkedHashMap map){
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
    public void clear() {
        map.clear();
    }
    /**
     * Удаляет все элементы из коллекции которые больше чем введенный.
     */
    public void remove_greater(Route route) {
        Set<Integer> keysToRemove = new HashSet<>();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if (route.compareTo(entry.getValue()) < 0) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (Integer key : keysToRemove) {
            map.remove(key);
        }
    }
    /**
     * Удаляет все элементы из коллекции которые меньше чем введенный.
     */
    public void remove_lower(Route route) {
        Set<Integer> keysToRemove = new HashSet<>();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if (route.compareTo(entry.getValue()) > 0) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (Integer key : keysToRemove) {
            map.remove(key);
        }
    }
    /**
     * Удаляет все элементы из коллекции ключ которых меньше чем введенный.
     */
    public void remove_lower_key(int id) {
        Set<Integer> keysToRemove = new HashSet<>();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if (entry.getKey() < id) {
                keysToRemove.add(entry.getKey());
            }
        }
        for (Integer key : keysToRemove) {
            map.remove(key);
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
