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


    @Override
    public void execute(CommandData commandData) {
        routestorage = commandData.getRoutestorage();
        server = commandData.getServer();

        distance = commandData.getDistance();
        commandData.setDistance(0F);
        StringBuilder sb = new StringBuilder();
        Boolean flag = false;
        LinkedHashMap<Integer, Route> map = routestorage.getCollection();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if(Float.compare(entry.getValue().getDistance(), distance) == 0) {
                sb.append("Ключ: ").append(entry.getKey()).append("\nЗначение: ").append(entry.getValue()).append("\n");
                flag = true;
            }
        }
        if (flag) server.sendMessageToClient("\uD83D\uDFE2 filter_by_distance: \n" + sb.toString());
        else server.sendMessageToClient("\uD83D\uDFE2 filter_by_distance: Нашлось 0 таких элементов.");
    }

    @Override
    public String toString() {
        return "filter_by_distance";
    }
}