package collectionCommands;

import classes.Routestorage;
import database.DataBaseManager;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class ClearCommand implements Command, Serializable {
    private Routestorage routestorage;
    private static final long serialVersionUID = 2L;
    private Server server;
    private DataBaseManager dataBaseManager;
    @Override
    public void execute(CommandData commandData) {
        routestorage = commandData.getRoutestorage();
        server = commandData.getServer();
        dataBaseManager = commandData.getDataBaseManager();


        if (routestorage.getCollection().isEmpty()) {server.sendMessageToClient("\uD83D\uDFE2 Clear: Коллекция пуста.");}
        else {
            routestorage.clear(commandData.getUser());
            dataBaseManager.deleteAllRoutesFromDataBase(commandData.getUser());
            server.sendMessageToClient("\uD83D\uDFE2 Clear: Ваша Коллекция отчищена.");
        }
    }
    @Override
    public String toString() {
        return "clear";
    }
}
