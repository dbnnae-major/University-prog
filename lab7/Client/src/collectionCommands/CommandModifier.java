package collectionCommands;
import database.User;
/**
 * Класс отвечающий за анализ введенной команды.
 */
public class CommandModifier {
    CommandExecutor executor;
    CommandData commandData;

    public CommandModifier(CommandExecutor executor, CommandData commandData) {
        this.executor = executor;
        this.commandData = commandData;
    }

    /**
     * Метод анализирующий пользовательский ввод.
     */
    public void analysis(String command) {
        command = command.replaceFirst("^\\s+", "");
        if (command.contains("update_id") | command.contains("remove_key") | command.contains("remove_lower_key")) {
            try {
                int key = Integer.parseInt(command.substring(command.indexOf(' ') + 1).trim());
                commandData.setKey(key);
                command = command.substring(0, command.indexOf(' '));
                executor.executeCommand(command.trim());
            } catch (Exception e) {
                System.out.println("Значение id/key введено неверно!");
            }
        }
        else if (command.contains("count_greater_than_distance") || command.contains("filter_by_distance")) {
            try {
                Float distance = Float.parseFloat(command.substring(command.indexOf(' ') + 1).trim());
                commandData.setDistance(distance);
                command = command.substring(0, command.indexOf(' '));
                executor.executeCommand(command.trim());
            } catch (Exception e) {
                System.out.println("Значение distance введено неверно!");
            }
        }
        else if (command.contains("filter_starts_with_name") || command.trim().contains("execute_script")) {
            try {
                String name = " ";
                name = command.substring(command.indexOf(' ') + 1).trim();
                commandData.setName(name);
                command = command.substring(0, command.indexOf(' '));
                executor.executeCommand(command.trim());
            } catch (Exception e) {
                System.out.println("Значение name введено неверно!");
            }
        }
        else executor.executeCommand(command.trim());
    }
}
