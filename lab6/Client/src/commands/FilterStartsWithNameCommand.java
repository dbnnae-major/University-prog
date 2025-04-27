package commands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class FilterStartsWithNameCommand implements Command, Serializable {
    private static final long serialVersionUID = 14L;
    private String name;
    private CommandData commandData;

    public FilterStartsWithNameCommand(CommandData commandData) {
        this.commandData = commandData;
    }

    @Override
    public void execute(Client client) {
        name = commandData.getName();
        client.sendObjectToServer(name);
        client.sendObjectToServer(new FilterStartsWithNameCommand(commandData));
    }
}