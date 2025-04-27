package collectionCommands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class FilterByDistanceCommand implements Command, Serializable {
    private static final long serialVersionUID = 13L;
    private Float distance;
    private CommandData commandData;

    public FilterByDistanceCommand(CommandData commandData) {
        this.commandData = commandData;
    }

    @Override
    public void execute(Client client) {
        distance = commandData.getDistance();
        client.sendObjectToServer(distance);
        client.sendObjectToServer(new FilterByDistanceCommand(commandData));
    }
}
