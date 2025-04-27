package commands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class HelpCommand implements Command, Serializable {
    private static final long serialVersionUID = 1L;
    public String getName(){
        return "help";
    }
    @Override
    public void execute(Client client) {
        client.sendObjectToServer(new HelpCommand());
    }
}
