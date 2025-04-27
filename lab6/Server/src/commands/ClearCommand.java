package commands;

import classes.Routestorage;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class ClearCommand implements Command, Serializable {
    private Routestorage routestorage;
    private static final long serialVersionUID = 2L;
    private Server server;
    public ClearCommand(Server server, Routestorage routestorage) {
        this.routestorage = routestorage;
        this.server = server;
    }
    @Override
    public void execute() {
        routestorage.clear();
        server.sendMessageToClient("\uD83D\uDFE2 Clear: Коллекция отчищена.");
    }
    @Override
    public String toString() {
        return "clear";
    }
}
