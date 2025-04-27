import GUI.AppForm;
import GUI.LoginForm;
import client.Client;
import client.ClientData;
import collectionCommands.CommandData;
import collectionCommands.CommandExecutor;
import collectionCommands.CommandModifier;
import collectionCommands.Commands;
import database.DataBaseCommandExecutor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {

        try {
            Scanner scanner = new Scanner(System.in);
            ClientData clientData = new ClientData();
            Client client = new Client(clientData);
            // DataBase classes
            DataBaseCommandExecutor dataBaseCommandExecutor = new DataBaseCommandExecutor();
            // Collection classes
            CommandData commandData = new CommandData();
            CommandExecutor executor = new CommandExecutor(client);
            CommandModifier commandModifier = new CommandModifier(executor, commandData);
            Commands commands = new Commands(executor, commandData, commandModifier);
            //GUI
            AppForm appForm = new AppForm(client, commandData);
            LoginForm loginForm = new LoginForm(client, clientData, appForm);

            commands.registerAllCommands();
            dataBaseCommandExecutor.registerAllCommands();

//      Процесс принятия запросов
            while (true) {
                System.out.print("Введите Команду (Сводка по командам help): ");
                String command = scanner.nextLine();
                client.sendObjectToServer(CommandData.getUser());
                commandModifier.analysis(command);

                if (executor.getFlag()) {
                    client.receivedObjectFromServer();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Программа остановлена.");
        }
    }
}