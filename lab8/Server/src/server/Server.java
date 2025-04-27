package server;

import collectionCommands.CommandData;
import collectionCommands.CommandExecutor;
import database.DataBaseManager;
import database.User;
import elements.Route;
import interfaces.Command;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.LinkedHashMap;
import classes.Routestorage;
import java.util.logging.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; // Для использования пула потоков

public class Server {
    private static final Logger logger = Logger.getLogger(Server.class.getName());
    private DatagramSocket ds;
    private InetAddress host;
    private int port = 6789;
    private CommandExecutor executor;
    private CommandData commandData;
    private DataBaseManager dataBaseManager;
    private final ExecutorService requestThreadPool; // Пул потоков для обработки запросов
    private final ExecutorService responseThreadPool = Executors.newFixedThreadPool(10); // Фиксированный пул потоков для отправки ответов

    public Server(CommandExecutor executor, CommandData commandData, DataBaseManager dataBaseManager) {
        this.commandData = commandData;
        this.executor = executor;
        this.dataBaseManager = dataBaseManager;
        requestThreadPool = Executors.newCachedThreadPool(); // Инициализация пула потоков для обработки запросов
        try {
            ds = new DatagramSocket(port);
            logger.info("Server started and listening on port " + port);
        } catch (Exception e) {
            logger.severe("Error occurred while starting the server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            while (true) { // Бесконечный цикл для прослушивания запросов
                byte[] buffer = new byte[1048576];
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ds.receive(dp);

                host = dp.getAddress();
                port = dp.getPort();

                requestThreadPool.submit(new RequestHandler(dp.getData(), dp.getAddress(), dp.getPort()));


            }
        } catch (Exception e) {
            logger.severe("Error occurred: " + e.getMessage());
        } finally {
            if (ds != null) {
                ds.close(); // Закрыть сокет при завершении работы сервера
            }
            requestThreadPool.shutdown();
            responseThreadPool.shutdown();
        }
    }

    private class RequestHandler implements Runnable {
        private final byte[] data;
        private final InetAddress address;
        private final int port;

        public RequestHandler(byte[] data, InetAddress address, int port) {
            this.data = data;
            this.address = address;
            this.port = port;
        }

        @Override
        public void run() {
            try {
                ByteArrayInputStream byteInput = new ByteArrayInputStream(data);
                ObjectInputStream objectInput = new ObjectInputStream(byteInput);
                Object receivedObject = objectInput.readObject();

                logger.info("Received object of type: " + receivedObject.getClass());

                if (receivedObject.getClass().toString().contains("collectionCommands.")) {
                    executor.executeCommand((Command) receivedObject);
                } else if (receivedObject.getClass().toString().contains("database.")) {
                    User user = (User) receivedObject;
                    if (user.getRegFlag() == 0) {
                        dataBaseManager.signUpUser(user);
                        if (dataBaseManager.getSignUpFlag()) {
                            sendMessageToClient("✅ Пользователь зарегистрирован успешно.");
                            dataBaseManager.setSignUpFlag(false);
                            user.setRegFlag(3);
                        } else {
                            sendMessageToClient("Во время регистрации произошла ошибка: такой пользователь уже зарегистрирован.");
                        }
                    }
                    else if (user.getRegFlag() == 1) {
                        dataBaseManager.loginUser(user);
                        if (dataBaseManager.getLoginFlag()) {
                            sendMessageToClient("✅ Вы успешно вошли.");
                            user.setRegFlag(3);
                            dataBaseManager.setLoginFlag(false);
                        } else {
                            sendMessageToClient("Во время входа произошла ошибка: такой пользователь не зарегистрирован.");
                        }
                    }
                    else {
                        commandData.setObject(receivedObject);
                    }
                } else {
                    commandData.setObject(receivedObject);
//                    sendMessageToClient("✅ Объект получен.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Ошибка при принятии сообщения: " + e.getMessage());
            }
        }
    }


    public void sendMessageToClient(String message) {
        try {
            byte[] sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, host, port);
            responseThreadPool.submit(() -> {
                try {
                    ds.send(sendPacket);
                } catch (Exception e) {
                    System.err.println("Ошибка при попытке отправить клиенту сообщение: " + e.getMessage());
                }
            });
        } catch (Exception e) {
            logger.severe("Ошибка при попытке отправить клиенту сообщение: " + e.getMessage());
        }
    }

    public void sendObjectToClient(Routestorage routestorage) {
        try {
            // Преобразуем объект routestorage в массив байтов
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(routestorage);
            byte[] sendData = byteArrayOutputStream.toByteArray();

            // Отправляем массив байтов на клиент
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, host, port);
            responseThreadPool.submit(() -> {
                try {
                    ds.send(sendPacket);
                } catch (Exception e) {
                    System.err.println("Ошибка при попытке отправить клиенту сообщение: " + e.getMessage());
                }
            });

            // Закрываем потоки
            objectOutputStream.close();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Ошибка при попытке отправить клиенту сообщение: " + e.getMessage());
        }
    }
}