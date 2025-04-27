package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class UpdateIdCommand implements Command, Serializable {
    private static final long serialVersionUID = 7L;
    private Routestorage routestorage;
    private Server server;
    private CommandData commandData;
    private Route route;
    public UpdateIdCommand(Server server, Routestorage routestorage, CommandData commandData) {
        this.routestorage = routestorage;
        this.server = server;
        this.commandData = commandData;
    }
    @Override
    public void execute() {
        route = commandData.getRoute();
        commandData.setRoute(null);
        if (routestorage.getCollection().containsKey(route.getId())) {
            routestorage.updateobject(route);
        }
        else {
            server.sendMessageToClient("\uD83D\uDFE2 Update_id: Элемента с заданным id не существует.");
        }
    }
    @Override
    public String toString() {
        return "update_id";
    }
}
