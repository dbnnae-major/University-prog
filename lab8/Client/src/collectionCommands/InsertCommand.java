package collectionCommands;

import client.Client;
import elements.Route;
import interfaces.Command;

import java.io.Serializable;

public class InsertCommand implements Command, Serializable {
    private static final long serialVersionUID = 6L;
    private Route route;
    public InsertCommand (Route route) {
        this.route = route;
    }
    @Override
    public void execute(Client client) {
        this.route = collectionCommands.Commands.insertWithKey();
        client.sendObjectToServer(new InsertCommand(route));
    }
}
