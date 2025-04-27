package collectionCommands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterByDistanceCommand implements Command, Serializable {
    private static final long serialVersionUID = 13L;
    private Routestorage routestorage;
    private Server server;
    private Float distance;

    public FilterByDistanceCommand(Float distance){
        this.distance = distance;
    }


    @Override
    public void execute(CommandData commandData) {
        routestorage = commandData.getRoutestorage();
        server = commandData.getServer();

        StringBuilder sb = new StringBuilder();
        Boolean flag = false;
        LinkedHashMap<Integer, Route> map = routestorage.getCollection();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if(Float.compare(entry.getValue().getDistance(), distance) == 0) {
                sb.append("Ключ: ").append(entry.getKey()).append("\nЗначение: ").append(entry.getValue()).append("\n");
                flag = true;
            }
        }
        if (flag) server.sendMessageToClient(sb.toString());
        else server.sendMessageToClient("Нашлось 0 таких элементов.");
    }

    @Override
    public String toString() {
        return "filter_by_distance";
    }
}