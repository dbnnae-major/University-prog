package collectionCommands;

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
    private Float distance;
    public CountGreaterThanDistanceCommand(Float distance){
        this.distance = distance;
    }

    @Override
    public void execute(CommandData commandData) {
        routestorage = commandData.getRoutestorage();
        server = commandData.getServer();

        int sum = 0;
        LinkedHashMap<Integer, Route> map = routestorage.getCollection();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if(Float.compare(entry.getValue().getDistance(), distance) > 0) sum += 1;
        }
        server.sendMessageToClient("Нашлось " + sum + " таких элементов.");
    }

    @Override
    public String toString() {
        return "count_greater_than_distance";
    }
}
