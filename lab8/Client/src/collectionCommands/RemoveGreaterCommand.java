package collectionCommands;

import client.Client;
import elements.Route;
import interfaces.Command;

import java.io.Serializable;

public class RemoveGreaterCommand implements Command, Serializable {
    private static final long serialVersionUID = 10L;
    private CommandData commandData;
    private Route route;

    public RemoveGreaterCommand(Route route) {
        this.route = route;
    }

    @Override
    public void execute(Client client) {
        route = collectionCommands.Commands.insertWithKey();

        client.sendObjectToServer(new RemoveGreaterCommand(route));
    }
}
