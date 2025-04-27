import client.Client;
import client.ClientData;
import collectionCommands.CommandData;
import collectionCommands.CommandExecutor;
import collectionCommands.CommandModifier;
import collectionCommands.Commands;
import database.DataBaseCommandExecutor;
import database.User;

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


            commands.registerAllCommands();
            dataBaseCommandExecutor.registerAllCommands();
//      Процесс авторизации
            User user = null;
            while (true) {
                System.out.print("Введите < 1 >, если у вас есть аккаунт \n" +
                        "Введите < 2 >, если у вас нет аккаунта и вы хотите зарегистрироваться. \n");
                String command = scanner.nextLine();
                if (command.equals("exit")) {commandModifier.analysis(command);}
                user = dataBaseCommandExecutor.executeCommand(command.trim());
                CommandData.setUser(user);
                if (user != null) {
                    client.sendObjectToServer(user);
                    client.receivedObjectFromServer();
                    if (clientData.getRegFlag() && command.equals("2") && client.getFlag()) {user.setRegFlag(3); break;}
                    else if (clientData.getLoginFlag() && command.equals("1") && client.getFlag()) {user.setRegFlag(3); break;}
                    clientData.setRegFlag(true);
                    clientData.setLoginFlag(true);
                }
            }
//      Процесс принятия запросов
            while (true) {
                System.out.print("Введите Команду (Сводка по командам help): ");
                String command = scanner.nextLine();
                client.sendObjectToServer(user);
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