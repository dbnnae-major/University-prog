package collectionCommands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class ShowCommand implements Command, Serializable {
    private static final long serialVersionUID = 4L;
    public String getName(){
        return "show";
    }
    @Override
    public void execute(Client client) {
        client.sendObjectToServer(new ShowCommand());
    }
}
