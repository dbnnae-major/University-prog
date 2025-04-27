package collectionCommands;

import client.Client;
import interfaces.Command;

public class ExitCollectionsCommand implements Command {
    @Override
    public void execute(Client client) {
        System.out.println("Выход из приложения");
        System.exit(0);
    }
}
