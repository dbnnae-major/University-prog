package commands;

import client.Client;
import elements.Route;
import interfaces.Command;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

public class ExecuteScriptCommand implements Command, Serializable {
    private static final long serialVersionUID = 15L;
    private CommandData commandData;
    private String fileName;
    private CommandModifier commandModifier;
    private CommandExecutor executor;
    public ExecuteScriptCommand(CommandData commandData, CommandModifier commandModifier, CommandExecutor executor) {
        this.commandData = commandData;
        this.commandModifier = commandModifier;
        this.executor = executor;
    }

    @Override
    public void execute(Client client) {
        String fileName = commandData.getName();
        int i = 0;

        try {
            FileInputStream fileInputStream = new FileInputStream("src/"+fileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            StringBuilder currentLine = new StringBuilder();

            boolean insert = false;
            int c;
            String command = "";
            while ((c = bufferedInputStream.read()) != -1) {
                if (c == '\r') {
                    String line = currentLine.toString().replace((char) 65279, ' ').replaceFirst("^\\s+", "").replaceAll("\\x0D", "").replaceAll("\\x0A", "");
                    currentLine.setLength(0);
                    if (line.startsWith("execute_script")) {
                        commandData.setBreakpoint(commandData.getBreakpoint() + 1);
                        if (commandData.getBreakpoint() == 12) {
                            System.out.println("В скрипте найдена рекурсия, проверьте вызываемые скрипты!");
                            commandData.setBreakpoint(0);
                            System.out.println("Выход из приложения");
                            System.exit(0);
                            break;
                        }
                        else {
                            commandModifier.analysis(line);
                            client.receivedObjectFromServer();
                        }
                    } else if (line.startsWith("insert") || line.startsWith("update_id") || line.equals("remove_greater") || line.equals("remove_lower")) {
                        Route route = Commands.readFile(fileInputStream, bufferedInputStream, currentLine, line.startsWith("update_id"), line);
                        if (route == null) {
                            System.out.println("Объект создать не удалось из-за неправильно введенных данных. Чтобы узнать какие допустимые значения - введите команду info_objects. \n" +
                                    "Перезапишите данные в Script и заново запустите его.");
                            System.out.println("Выход из приложения");
                            System.exit(0);
                        } else {
                            if (line.trim().equals("insert")) {
                                client.sendObjectToServer(route);
                                client.sendObjectToServer(new InsertCommand());
                                client.receivedObjectFromServer();
                            } else if (line.equals("remove_greater")) {
                                client.sendObjectToServer(new RemoveGreaterCommand(commandData));
                                client.receivedObjectFromServer();
                            } else if (line.equals("remove_lower")) {
                                client.sendObjectToServer(new RemoveLowerCommand(commandData));
                                client.receivedObjectFromServer();
                            } else if (line.startsWith("update_id")) {
                                client.sendObjectToServer(route);
                                client.sendObjectToServer(new UpdateIdCommand(commandData));
                                client.receivedObjectFromServer();
                            }
                        }
                    }
                    else {
                        commandModifier.analysis(line);
                        if (executor.getFlag()) {
                            client.receivedObjectFromServer();
                        }
                    }
                }
                else {
                    currentLine.append((char) c);
                }
            }
            bufferedInputStream.close();
            fileInputStream.close();
            executor.setFlag(false);


        } catch (FileNotFoundException e) {
            System.out.println("Данный файл не найден!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}