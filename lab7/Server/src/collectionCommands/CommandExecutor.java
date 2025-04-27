package collectionCommands;

import classes.Routestorage;
import database.DataBaseManager;
import interfaces.Command;
import server.Server;

import java.util.*;

public class CommandExecutor {
    private Map<String, Command> commands;
    private CommandData commandData;
    public CommandExecutor(CommandData commandData) {
        this.commands = new HashMap<>();
        this.commandData = commandData;
    }

    public void registerCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void executeCommand(Command command) {
        if (command != null) {
            command.execute(commandData);
        } else {
            System.out.println("Нет такой команды.");
        }
    }
}
