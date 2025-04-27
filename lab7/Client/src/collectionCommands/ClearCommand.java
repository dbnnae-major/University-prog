package collectionCommands;

import client.Client;
import interfaces.Command;

import java.io.Serializable;

/**
 * Вызываемая команда для отчистки коллекции.
 */
public class ClearCommand implements Command, Serializable {
    private static final long serialVersionUID = 2L;
    public String getName(){
        return "clear";
    }
    @Override
    public void execute(Client client) {
        client.sendObjectToServer(new ClearCommand());
    }
}
