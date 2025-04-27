import java.util.*;

public class CommandExecutor {
    private Map<String, Command> commands;
    private Deque<Command> historyStack;

    public CommandExecutor(Deque<Command> historyStack) {
        commands = new HashMap<>();
        this.historyStack = historyStack;
    }

    public void registerCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void executeCommand(String name, Deque<Command> historyStack) {
        Command command = commands.get(name);
        if (command != null) {
            if (historyStack.size() < 5){
                historyStack.add(command);
            }
            else{
                historyStack.removeFirst();
                historyStack.add(command);
            }

            command.execute();
        } else {
            System.out.println("Неверная команда");
        }
    }
}
