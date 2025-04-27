package commands;

import client.Client;
import interfaces.Command;

import javax.swing.text.StyledEditorKit;
import java.util.*;

public class CommandExecutor {
    private Map<String, Command> commands;
    private Client client;
    private Boolean flag = true;

    public CommandExecutor(Client client) {
        this.commands = new HashMap<>();
        this.client = client;
    }
    public void registerCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void executeCommand(String name) {
        Command command = commands.get(name);
        if (command != null & !name.startsWith("execute_script")) {
            command.execute(client);
            flag = true;
        } else {
            flag = false;
            if (name.startsWith("execute_script")){
                command.execute(client);
            }
            else {
                System.out.println("Нет такой команды.");
            }
        }
    }

    public Boolean getFlag() {
        return flag;
    }
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
