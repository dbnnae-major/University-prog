import client.Client;
import commands.CommandData;
import commands.CommandExecutor;
import commands.CommandModifier;
import commands.Commands;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {

        try {
            Client client = new Client();
            CommandData commandData = new CommandData();
            CommandExecutor executor = new CommandExecutor(client);
            CommandModifier commandModifier = new CommandModifier(executor, commandData);
            Commands commands = new Commands(executor, commandData, commandModifier);
            Scanner scanner = new Scanner(System.in);

            commands.registerAllCommands();

            while (true) {
                System.out.print("Введите Команду (Сводка по командам help): ");
                String command = scanner.nextLine();
                commandModifier.analysis(command);

                if (executor.getFlag()) {
                    client.receivedObjectFromServer();
                }
            }
        } catch (Exception e) {
            System.out.println("Программа остановлена.");
        }
    }
}