package collectionCommands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilterStartsWithNameCommand implements Command, Serializable {
    private static final long serialVersionUID = 14L;
    private Routestorage routestorage;
    private Server server;
    private String name;


    @Override
    public void execute(CommandData commandData) {
        routestorage = commandData.getRoutestorage();
        server = commandData.getServer();

        name = commandData.getName();
        commandData.setName("");
        StringBuilder sb = new StringBuilder();
        Boolean flag = false;
        LinkedHashMap<Integer, Route> map = routestorage.getCollection();
        for (Map.Entry<Integer, Route> entry : map.entrySet()) {
            if(entry.getValue().getName().startsWith(name)) {
                sb.append("Ключ: ").append(entry.getKey()).append("\nЗначение: ").append(entry.getValue()).append("\n");
                flag = true;
            }
        }
        if (flag) server.sendMessageToClient("\uD83D\uDFE2 filter_starts_with_name: \n" + sb.toString());
        else server.sendMessageToClient("\uD83D\uDFE2 filter_starts_with_name: Нашлось 0 таких элементов.");
    }

    @Override
    public String toString() {
        return "filter_starts_with_name";
    }
}