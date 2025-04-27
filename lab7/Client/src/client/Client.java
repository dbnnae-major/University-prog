package client;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;


public class Client {
    private DatagramSocket ds;
    private DatagramPacket dp;
    private InetAddress host;
    private String ip = "localhost";
    private int port;
    private DatagramPacket responsePacket;
    private byte[] receivedData;
    private Boolean flag = false;
    private ClientData clientData;

    public Client(ClientData clientData) throws IOException {
        this.clientData = clientData;
        ds = new DatagramSocket();
        host = InetAddress.getByName(ip);
        port = 6789;
    }

    public Boolean getFlag() {
        return flag;
    }

    public <T> void sendObjectToServer(T object) {
        try {
            // Сериализация объекта
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(object);
            objectStream.flush();

            // Получение сериализованных данных и отправка на сервер
            byte[] serializedData = byteStream.toByteArray();
            dp = new DatagramPacket(serializedData, serializedData.length, host, port);
            ds.send(dp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receivedObjectFromServer() {
        try {
            flag = false;
            while (true) {
                ds.setSoTimeout(500);

                byte[] responseData = new byte[1048576];
                responsePacket = new DatagramPacket(responseData, responseData.length);
                ds.receive(responsePacket);

                receivedData = responsePacket.getData();

                printReceivedData();
            }
        } catch (SocketTimeoutException e) {
            if (flag) System.out.println("✅ Сервер закончил отправку данных.");
            else System.out.println("❌ Сервер временно не доступен ИЛИ ваш запрос введен неверно.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printReceivedData () {
        try {
            flag = true;
            String receivedMessage = new String(receivedData, 0, responsePacket.getLength()); // Преобразование в строку

            if (receivedMessage.equals("Во время регистрации произошла ошибка: такой пользователь уже зарегистрирован.")) {
                clientData.setRegFlag(false);
            }

            if (receivedMessage.equals("Во время входа произошла ошибка: такой пользователь не зарегистрирован.")) {
                clientData.setLoginFlag(false);
            }

            System.out.println(receivedMessage);
        } catch (NullPointerException e) {
            System.out.println("⚠\uFE0F От сервера не поступало никаких ответов. ⚠\uFE0F");
        }
    }
}
