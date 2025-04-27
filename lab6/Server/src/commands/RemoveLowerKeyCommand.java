package commands;

import classes.Routestorage;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class RemoveLowerKeyCommand implements Command, Serializable {
    private static final long serialVersionUID = 11L;
    private Routestorage routestorage;
    private Server server;
    private CommandData commandData;
    private int key;

    public RemoveLowerKeyCommand(Server server, Routestorage routestorage, CommandData commandData) {
        this.routestorage = routestorage;
        this.server = server;
        this.commandData = commandData;
    }

    @Override
    public void execute() {
        key = commandData.getKey();
        commandData.setKey(0);
        routestorage.remove_lower_key(key);
        server.sendMessageToClient("\uD83D\uDFE2 Remove_lower_key: Все возможные объекты удалены.");
    }

    @Override
    public String toString() {
        return "remove_lower_key";
    }
}
