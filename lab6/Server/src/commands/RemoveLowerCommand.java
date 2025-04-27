package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class RemoveLowerCommand implements Command, Serializable {
    private static final long serialVersionUID = 9L;
    private Routestorage routestorage;
    private Server server;
    private Route route;
    private CommandData commandData;
    public RemoveLowerCommand(Server server, Routestorage routestorage, CommandData commandData) {
        this.routestorage = routestorage;
        this.server = server;
        this.commandData = commandData;
    }
    @Override
    public void execute() {
        route = commandData.getRoute();
        commandData.setRoute(null);
        routestorage.remove_lower(route);
        server.sendMessageToClient("\uD83D\uDFE2 Remove_lower: Все возможные объекты удалены.");
    }
    @Override
    public String toString() {
        return "remove_lower";
    }
}
