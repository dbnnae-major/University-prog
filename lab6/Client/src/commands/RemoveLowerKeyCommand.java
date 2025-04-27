package commands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class RemoveLowerKeyCommand implements Command, Serializable {
    private static final long serialVersionUID = 11L;
    private int key;
    private CommandData commandData;
    public RemoveLowerKeyCommand(CommandData commandData) {
        this.commandData = commandData;
    }
    @Override
    public void execute(Client client) {
        key = commandData.getKey();
        client.sendObjectToServer(key);
        client.sendObjectToServer(new RemoveLowerKeyCommand(commandData));
    }
}
