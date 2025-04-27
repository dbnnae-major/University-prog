package collectionCommands;

import classes.Routestorage;
import database.DataBaseManager;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class ShowCommand implements Command, Serializable {
    private Routestorage routestorage;
    private DataBaseManager dataBaseManager;
    private static final long serialVersionUID = 4L;
    private Server server;

    @Override
    public void execute(CommandData commandData) {
        server = commandData.getServer();
        routestorage = commandData.getRoutestorage();
        dataBaseManager = commandData.getDataBaseManager();

        LinkedHashMap<Integer, Route> collection = dataBaseManager.loadCollectionFromDataBase();
        routestorage.setCollection(collection);

        if (routestorage.getCollection().isEmpty())
            server.sendMessageToClient("Коллекция пуста.");
        else {
            routestorage.sort();
            server.sendMessageToClient(routestorage.toString());
        }
    }

    @Override
    public String toString() {
        return "show";
    }
}
