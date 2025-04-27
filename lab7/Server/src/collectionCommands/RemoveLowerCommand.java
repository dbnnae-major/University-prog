package collectionCommands;

import classes.Routestorage;
import database.DataBaseManager;
import database.User;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class RemoveLowerCommand implements Command, Serializable {
    private static final long serialVersionUID = 9L;
    private Routestorage routestorage;
    private Server server;
    private Route route;
    private DataBaseManager dataBaseManager;
    public RemoveLowerCommand(Route route) {
        this.route = route;
    }
    @Override
    public void execute(CommandData commandData) {

        routestorage = commandData.getRoutestorage();
        server = commandData.getServer();
        dataBaseManager = commandData.getDataBaseManager();

        User user = commandData.getUser();
        routestorage.remove_lower(route, user, dataBaseManager);
        server.sendMessageToClient("\uD83D\uDFE2 Remove_lower: Все возможные объекты удалены.");
    }
    @Override
    public String toString() {
        return "remove_lower";
    }
}
