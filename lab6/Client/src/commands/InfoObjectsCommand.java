package commands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

public class InfoObjectsCommand implements Command, Serializable {
    private static final long serialVersionUID = 3L;

    public String getName() {
        return "info_objects";
    }

    @Override
    public void execute(Client client) {
        client.sendObjectToServer(new InfoObjectsCommand());
    }
}
