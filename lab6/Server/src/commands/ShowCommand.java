package commands;

import classes.Routestorage;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class ShowCommand implements Command, Serializable {
    private Routestorage routestorage;
    private static final long serialVersionUID = 4L;
    private Server server;
    public ShowCommand(Server server, Routestorage routestorage) {
        this.routestorage = routestorage;
        this.server = server;
    }
    @Override
    public void execute() {
        if (routestorage.getCollection().isEmpty()) server.sendMessageToClient("\uD83D\uDFE2 show: " + "Коллекция пуста.");
        else{
            routestorage.sort();
            server.sendMessageToClient("\uD83D\uDFE2 show: \n" + routestorage.toString());
        }
    }
    @Override
    public String toString() {
        return "show";
    }
}
