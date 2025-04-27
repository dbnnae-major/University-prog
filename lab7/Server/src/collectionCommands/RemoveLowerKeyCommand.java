package collectionCommands;

import classes.Routestorage;
import database.DataBaseManager;
import database.User;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

public class RemoveLowerKeyCommand implements Command, Serializable {
    private static final long serialVersionUID = 11L;
    private Routestorage routestorage;
    private Server server;
    private DataBaseManager dataBaseManager;
    private int key;

    public RemoveLowerKeyCommand(int key) {
        this.key = key;
    }

    @Override
    public void execute(CommandData commandData) {
        routestorage = commandData.getRoutestorage();
        server = commandData.getServer();
        dataBaseManager = commandData.getDataBaseManager();

        User user = commandData.getUser();
        routestorage.remove_lower_key(key, user, dataBaseManager);
        server.sendMessageToClient("\uD83D\uDFE2 Remove_lower_key: Все возможные объекты удалены.");
    }

    @Override
    public String toString() {
        return "remove_lower_key";
    }
}
