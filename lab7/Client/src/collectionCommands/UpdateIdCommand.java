package collectionCommands;

import client.Client;
import elements.Route;
import interfaces.Command;

import java.io.Serializable;

public class UpdateIdCommand implements Command, Serializable {
    private static final long serialVersionUID = 7L;
    private CommandData commandData;
    private Route route;
    public UpdateIdCommand(CommandData commandData, Route route) {
        this.commandData = commandData;
        this.route = route;
    }
    @Override
    public void execute(Client client){
        int key = commandData.getKey();
        route = collectionCommands.Commands.insertWithOutKey(key);
        client.sendObjectToServer(new UpdateIdCommand(commandData, route));
    }
}
