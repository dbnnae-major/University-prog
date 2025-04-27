package commands;

import client.Client;
import elements.Route;
import interfaces.Command;

import java.io.Serializable;
import java.util.Scanner;

public class RemoveKeyCommand implements Command, Serializable {
    private static final long serialVersionUID = 8L;
    private int key;
    private CommandData commandData;
    public RemoveKeyCommand(CommandData commandData) {
        this.commandData = commandData;
    }
    @Override
    public void execute(Client client) {
        key = commandData.getKey();
        client.sendObjectToServer(key);
        client.sendObjectToServer(new RemoveKeyCommand(commandData));
    }
}
