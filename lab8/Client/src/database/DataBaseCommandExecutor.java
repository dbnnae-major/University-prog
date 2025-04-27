package database;

import interfaces.DataBaseCommand;

import java.util.HashMap;
import java.util.Map;

public class DataBaseCommandExecutor {
    private Map<String, DataBaseCommand> commands;
    private User user = new User();

    public DataBaseCommandExecutor() {
        this.commands = new HashMap<>();
    }

    public void registerAllCommands(){
        registerCommand("2", new SignUpUserCommand());
        registerCommand("1",new LoginUserCommand());
    }
    public void registerCommand(String name, DataBaseCommand dataBaseCommand) {
        commands.put(name, dataBaseCommand);
    }

    public User executeCommand(String name) {
        DataBaseCommand dataBaseCommand = commands.get(name);
        if (dataBaseCommand != null) {
            user = dataBaseCommand.execute();
            return user;
        } else {
            System.out.println("Нет такой команды.");
            return null;
        }
    }
}
