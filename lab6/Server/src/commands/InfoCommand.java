package commands;

import classes.Routestorage;
import interfaces.Command;
import server.Server;

import java.io.Serializable;

/**
 * Вызываемая команда для вывода информации о коллекции.
 */
public class InfoCommand implements Command, Serializable {
    private static final long serialVersionUID = 5L;
    private Server server;
    private Routestorage routestorage;

    public InfoCommand(Server server, Routestorage routestorage) {
        this.server = server;
        this.routestorage = routestorage;
    }

    @Override
    public String toString() {
        return "info";
    }

    public void execute() {
        String message = "Информация по данной коллекции: " + "\n"
                + "Тип коллекции: " + routestorage.getType() + "\n"
                + "Дата инициализации: " + routestorage.getDate() + "\n"
                + "Количество элементов: " + routestorage.getLength() + "\n"
                + "Тип хранимых объектов: " + routestorage.getContainType() + "\n";

        server.sendMessageToClient(message);
    }

}
