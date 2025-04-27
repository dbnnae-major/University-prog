package commands;

import client.Client;
import elements.Route;
import interfaces.Command;

import java.io.Serializable;

public class RemoveLowerCommand implements Command, Serializable {
    private static final long serialVersionUID = 9L;
    private CommandData commandData;
    private Route route;

    public RemoveLowerCommand(CommandData commandData) {
        this.commandData = commandData;
    }

    @Override
    public void execute(Client client) {
        route = Commands.insertWithKey();
        client.sendObjectToServer(route);
        client.sendObjectToServer(new RemoveLowerCommand(commandData));
    }
}
