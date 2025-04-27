package collectionCommands;

import client.Client;
import elements.Route;
import interfaces.Command;

import java.io.Serializable;

public class RemoveLowerCommand implements Command, Serializable {
    private static final long serialVersionUID = 9L;
    private Route route;
    public RemoveLowerCommand(Route route) {
        this.route = route;
    }

    @Override
    public void execute(Client client) {
        this.route = collectionCommands.Commands.insertWithKey();
        client.sendObjectToServer(new RemoveLowerCommand(route));
    }
}
