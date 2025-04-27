package commands;

import client.Client;
import elements.Route;
import interfaces.Command;

import java.io.Serializable;
import java.lang.reflect.Method;

public class InsertCommand implements Command, Serializable {
    private static final long serialVersionUID = 6L;
    private Route route;
    @Override
    public void execute(Client client) {
        route = Commands.insertWithKey();
        client.sendObjectToServer(route);
        client.sendObjectToServer(new InsertCommand());
    }
}
