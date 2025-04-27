package classes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import elements.Coordinates;
import elements.Location1;
import elements.Location2;
import elements.Route;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
/**
 * Класс отвечающий за чтения данных из файла и ввода их в коллекцию.
 */
public class FileParser {
    /**
     * Класс, хранящий коллекцию.
     */
    /**
     * Путь к файлу.
     */
    private String fileName;
    private static Routestorage routestorage;
    public FileParser(String fileName, Routestorage routestorage) {
        this.fileName = fileName;
        this.routestorage = routestorage;
    }
    /**
     * Читает данные с файла в формате json и записывает их в коллекцию.
     */
    public void parse(Routestorage routestorage) {
        String json = null;
        try {
            json = new String(Files.readAllBytes(Path.of("src/"+fileName)));
        } catch (NoSuchFileException e){
            System.out.println("Нет такого файла");
        }
        catch (AccessDeniedException e){
            System.out.println("Нет доступа к файлу");
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
        Gson gson = new Gson();
        try {
            java.lang.reflect.Type mapType = new com.google.gson.reflect.TypeToken<LinkedHashMap<Integer, Route>>() {
            }.getType();
            LinkedHashMap<Integer, Route> routesMap = gson.fromJson(json, mapType);

            if (routesMap == null) {
                routesMap = new LinkedHashMap<Integer, Route>();
            }
            routestorage.setCollection(routesMap);
        }
        catch (JsonSyntaxException e) {
            System.out.println("Файл заполнен неверно!");
        }
    }
    public static void save() {
        String fileName = "src/file.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type type = new TypeToken<LinkedHashMap<Integer, Route>>(){}.getType();
        String json = gson.toJson(routestorage.getCollection(), type);
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}