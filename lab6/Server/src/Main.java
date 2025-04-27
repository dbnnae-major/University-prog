import classes.FileParser;
import classes.Routestorage;
import commands.CommandData;
import commands.CommandExecutor;
import commands.Commands;
import server.Server;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        try {
            String fileName = "file.json";
            CommandData commandData = new CommandData();
            CommandExecutor executor = new CommandExecutor();
            Server server = new Server(executor, commandData);
            Routestorage routestorage = new Routestorage(server);
            FileParser fileParser = new FileParser(fileName, routestorage);
            Commands commands = new Commands(executor, server, routestorage, commandData);


            commands.registerAllCommands();
            fileParser.parse(routestorage);
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}