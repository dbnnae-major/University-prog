package collectionCommands;

import client.Client;
import elements.Route;
import interfaces.Command;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class GetCollectionCommand implements Command, Serializable {
    private static final long serialVersionUID = 133333L;
    private LinkedHashMap<Integer, Route> map;

    public GetCollectionCommand(LinkedHashMap<Integer, Route> map){
        this.map = map;
    }
    @Override
    public void execute(Client client) {
        client.sendObjectToServer(this);
    }
}
