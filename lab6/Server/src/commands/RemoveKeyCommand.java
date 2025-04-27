package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class RemoveKeyCommand implements Command, Serializable {
    private static final long serialVersionUID = 8L;
    private Routestorage routestorage;
    private Server server;
    private CommandData commandData;
    private int key;
    public RemoveKeyCommand(Server server, Routestorage routestorage, CommandData commandData) {
        this.routestorage = routestorage;
        this.server = server;
        this.commandData = commandData;
    }
    @Override
    public void execute() {
        key = commandData.getKey();
        routestorage.removeobject(key);
        commandData.setKey(0);
    }
    @Override
    public String toString() {
        return "remove_key";
    }
}
