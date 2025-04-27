package collectionCommands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class RemoveLowerKeyCommand implements Command, Serializable {
    private static final long serialVersionUID = 11L;
    private int key;
    private CommandData commandData;
    public RemoveLowerKeyCommand(CommandData commandData, int key) {
        this.commandData = commandData;
        this.key = key;
    }
    @Override
    public void execute(Client client) {
        key = commandData.getKey();
        client.sendObjectToServer(new RemoveLowerKeyCommand(commandData, key));
    }
}
