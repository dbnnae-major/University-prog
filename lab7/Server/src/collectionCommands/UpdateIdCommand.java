package collectionCommands;

import classes.Routestorage;
import database.DataBaseManager;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;
import java.sql.SQLException;

public class UpdateIdCommand implements Command, Serializable {
    private static final long serialVersionUID = 7L;
    private Routestorage routestorage;
    private Server server;
    private DataBaseManager dataBaseManager;
    private Route route;
    public UpdateIdCommand(Route route) {
        this.route = route;
    }
    @Override
    public void execute(CommandData commandData) {
        routestorage = commandData.getRoutestorage();
        server = commandData.getServer();
        dataBaseManager = commandData.getDataBaseManager();

        if (routestorage.getCollection().containsKey(route.getId())) {
            try {
                if (dataBaseManager.isOwner(route)) {
                    routestorage.updateobject(route);
                    dataBaseManager.updateRouteToDataBase(route);
                }
                else {
                    server.sendMessageToClient("\uD83D\uDFE2 Update_id: Вы не являетесь владельцем данного объекта.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
