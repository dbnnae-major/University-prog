import classes.Routestorage;
import collectionCommands.CommandData;
import collectionCommands.CommandExecutor;
import collectionCommands.Commands;
import database.DataBaseManager;
import elements.Route;
import server.Server;

import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        try {
            DataBaseManager dataBaseManager = new DataBaseManager();
            CommandData commandData = new CommandData();
            CommandExecutor executor = new CommandExecutor(commandData);
            Server server = new Server(executor, commandData, dataBaseManager);
            Routestorage routestorage = new Routestorage(server);
            Commands commands = new Commands(executor, server, routestorage, commandData, dataBaseManager);

            dataBaseManager.connect();
//      ПАРСИНГ ДАННЫХ ИЗ БД
            LinkedHashMap<Integer, Route> collection = dataBaseManager.loadCollectionFromDataBase();
            routestorage.setCollection(collection);
            commandData.setDataBaseManager(dataBaseManager);
            commandData.setServer(server);
            commandData.setRoutestorage(routestorage);
            server.run();
        } catch (Exception e) {
            System.out.println("Произошла ошибка...");
        }
    }
}