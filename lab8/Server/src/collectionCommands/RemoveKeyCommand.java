package collectionCommands;

import classes.Routestorage;
import database.DataBaseManager;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class RemoveKeyCommand implements Command, Serializable {
    private static final long serialVersionUID = 8L;
    private Routestorage routestorage;
    private Server server;
    private int key;
    private DataBaseManager dataBaseManager;

    public RemoveKeyCommand (int key) {
        this.key = key;
    }
    @Override
    public void execute(CommandData commandData) {
        routestorage = commandData.getRoutestorage();
        server = commandData.getServer();
        dataBaseManager = commandData.getDataBaseManager();

        if (routestorage.getCollection().containsKey(key) && ((Route) routestorage.getCollection().get(key)).getOwner().equals(commandData.getUser().getUsername())) {
            routestorage.removeobject(key);
            dataBaseManager.deleteRoutesByKeyFromDataBase(key, commandData.getUser());
            server.sendMessageToClient("Объект удален.");
        } else if (!routestorage.getCollection().containsKey(key)){
            server.sendMessageToClient("Данного объекта не существует.");
        }
        else {
            server.sendMessageToClient("Вы не являетесь владельцем этого объекта.");
        }
    }
    @Override
    public String toString() {
        return "remove_key";
    }
}
