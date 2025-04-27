package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountGreaterThanDistanceCommand implements Command, Serializable {
    private static final long serialVersionUID = 12L;
    private Routestorage routestorage;
    private Server server;
    private CommandData commandData;
    private Float distance;

    public CountGreaterThanDistanceCommand(Server server, Routestorage routestorage, CommandData commandData) {
        this.routestorage = routestorage;
        this.server = server;
        this.commandData = commandData;
    }

    @Override
    public void execute() {
        distance = commandData.getDistance();
        commandData.setDistance(0F);
        int sum = 0;
        LinkedHashMap<Integer, Route> map = routestorage.getCollection();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if(Float.compare(entry.getValue().getDistance(), distance) > 0) sum += 1;
        }
        server.sendMessageToClient("\uD83D\uDFE2 count_greater_than_distance: Нашлось " + sum + " таких элементов.");
    }

    @Override
    public String toString() {
        return "count_greater_than_distance";
    }
}
