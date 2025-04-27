package collectionCommands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class FilterStartsWithNameCommand implements Command, Serializable {
    private static final long serialVersionUID = 14L;
    private String name;


    public FilterStartsWithNameCommand(String name) {
        this.name = name;
    }

    @Override
    public void execute(Client client) {
        client.sendObjectToServer(new FilterStartsWithNameCommand(name));
    }
}