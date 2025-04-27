package collectionCommands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class InfoCommand implements Command, Serializable {
    private static final long serialVersionUID = 5L;
    public String getName(){
        return "info";
    }
    @Override
    public void execute(Client client) {
        client.sendObjectToServer(new InfoCommand());
    }
}
