package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class InsertCommand implements Command, Serializable {
    private static final long serialVersionUID = 6L;
    private Routestorage routestorage;
    private Server server;
    private Route route;
    private CommandData commandData;
    public InsertCommand(Server server, Routestorage routestorage, CommandData commandData) {
        this.routestorage = routestorage;
        this.server = server;
        this.commandData = commandData;
    }
    @Override
    public void execute() {
        route = commandData.getRoute();
        commandData.setRoute(null);
        routestorage.addobject(route);
        server.sendMessageToClient("\uD83D\uDFE2 Insert: Объект создан.");
    }
    @Override
    public String toString() {
        return "insert";
    }
}
