package collectionCommands;

import classes.Routestorage;
import database.DataBaseManager;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class InsertCommand implements Command, Serializable {
    private static final long serialVersionUID = 6L;
    private Routestorage routestorage;
    private Server server;
    private Route route;
    private DataBaseManager dataBaseManager;
    public InsertCommand(Route route) {
        this.route = route;
    }
    @Override
    public void execute(CommandData commandData) {
        routestorage = commandData.getRoutestorage();
        server = commandData.getServer();
        dataBaseManager = commandData.getDataBaseManager();

        if (routestorage.getCollection().containsKey(route.getId())) {server.sendMessageToClient("\uD83D\uDFE2 Insert: Такой объект уже существует.");}
        else {
            routestorage.addobject(route);
            dataBaseManager.addRouteToDataBase(route);
            server.sendMessageToClient("\uD83D\uDFE2 Insert: Объект создан.");
        }
    }
    @Override
    public String toString() {
        return "insert";
    }
}

