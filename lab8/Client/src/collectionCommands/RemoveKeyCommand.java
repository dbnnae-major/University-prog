package collectionCommands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class RemoveKeyCommand implements Command, Serializable {
    private static final long serialVersionUID = 8L;
    private int key;
    private CommandData commandData;
    public RemoveKeyCommand(CommandData commandData, int key) {
        this.commandData = commandData;
        this.key = key;
    }
    @Override
    public void execute(Client client) {
        key = commandData.getKey();
        client.sendObjectToServer(new RemoveKeyCommand(commandData, key));
    }
}
