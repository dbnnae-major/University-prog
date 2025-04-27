package collectionCommands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class FilterByDistanceCommand implements Command, Serializable {
    private static final long serialVersionUID = 13L;
    private Float distance;
    private CommandData commandData;

    public FilterByDistanceCommand(Float distance) {
        this.distance = distance;
    }

    @Override
    public void execute(Client client) {
        client.sendObjectToServer(new FilterByDistanceCommand(distance));
    }
}
