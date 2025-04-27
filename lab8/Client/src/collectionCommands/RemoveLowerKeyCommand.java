package collectionCommands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class RemoveLowerKeyCommand implements Command, Serializable {
    private static final long serialVersionUID = 11L;
    private int key;
    public RemoveLowerKeyCommand(int key) {
        this.key = key;
    }
    @Override
    public void execute(Client client) {
        client.sendObjectToServer(new RemoveLowerKeyCommand(key));
    }
}
