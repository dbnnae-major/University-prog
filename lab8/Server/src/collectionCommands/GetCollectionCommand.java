package collectionCommands;
import classes.Routestorage;
import elements.Route;
import interfaces.Command;
import server.Server;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class GetCollectionCommand implements Command, Serializable {
    private static final long serialVersionUID = 133333L;
    private LinkedHashMap<Integer, Route> map;
    private Server server;
    private Routestorage routestorage;

    public GetCollectionCommand(LinkedHashMap<Integer, Route> map){
        this.map = map;
    }

    @Override
    public void execute(CommandData commandData) {
        routestorage = commandData.getRoutestorage();
        server = commandData.getServer();

        server.sendObjectToClient(routestorage);
    }
}
