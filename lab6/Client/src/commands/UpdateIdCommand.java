package commands;

import client.Client;
import elements.Route;
import interfaces.Command;

import java.io.Serializable;

public class UpdateIdCommand implements Command, Serializable {
    private static final long serialVersionUID = 7L;
    private CommandData commandData;
    private Route route;
    public UpdateIdCommand(CommandData commandData) {
        this.commandData = commandData;
    }
    @Override
    public void execute(Client client){
        int key = commandData.getKey();
        route = Commands.insertWithOutKey(key);
        client.sendObjectToServer(route);
        client.sendObjectToServer(new UpdateIdCommand(commandData));
    }
}
