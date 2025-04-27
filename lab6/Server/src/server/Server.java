package server;

import classes.FileParser;
import commands.CommandData;
import commands.CommandExecutor;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.logging.Logger;

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());
    private DatagramSocket ds;
    private InetAddress host;
    private int port = 6789;
    private CommandExecutor executor;
    private CommandData commandData;

    public Server(CommandExecutor executor, CommandData commandData) {
        this.commandData = commandData;
        this.executor = executor;
        try {
            ds = new DatagramSocket(port);
            logger.info("Server started and listening on port " + port);
        } catch (Exception e) {
            logger.severe("Error occurred while starting the server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            while (true) { // Бесконечный цикл для прослушивания запросов
                byte[] buffer = new byte[1048576];
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ds.receive(dp);

                host = dp.getAddress();
                port = dp.getPort();

                // Десериализация объекта
                ByteArrayInputStream byteInput = new ByteArrayInputStream(dp.getData());
                ObjectInputStream objectInput = new ObjectInputStream(byteInput);
//                Command receivedObject = (Command) objectInput.readObject(); //В СЛУЧАЕ ПИЗДЕЦА ВЕРНУТЬ
                Object receivedObject = objectInput.readObject();

                // Обработка принятого объекта
                logger.info("Received object of type: " + receivedObject.getClass());
//                System.out.println(receivedObject.toString());
                if (receivedObject.getClass().toString().contains("commands.")) {
                    executor.executeCommand(receivedObject.toString());
                }
                else {
                    commandData.setObject(receivedObject);
                    sendMessageToClient("✅ Объект получен.");
                }
                FileParser.save();
//                executor.executeCommand(receivedObject.toString()); //В СЛУЧАЕ ПИЗДЕЦА ВЕРНУТЬ
            }
        } catch (Exception e) {
            logger.severe("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close(); // Закрыть сокет при завершении работы сервера
            }
        }
    }
    public void sendMessageToClient(String message) {
        try {
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, host, port);
            DatagramSocket responseSocket = new DatagramSocket(); // Создание нового сокета для отправки ответа
            responseSocket.send(sendPacket);
//            System.out.println("Message sent to client: " + message);
            responseSocket.close(); // Закрытие сокета после отправки
        } catch (Exception e) {
            logger.severe("Error occurred while sending message to client: " + e.getMessage());
            e.printStackTrace();
        }
    }
}