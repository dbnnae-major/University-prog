package commands;

import classes.Routestorage;
import interfaces.Command;

public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Все доступные команды:\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции.\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении. \n" +
                "insert : добавить новый элемент с заданным ключом. \n" +
                "update_id : обновить значение элемента коллекции, id которого равен заданному. \n" +
                "remove_key : удалить элемент из коллекции по его ключу. \n" +
                "exit : завершить программу (без сохранения в файл). \n" +
                "clear : очистить коллекцию. \n" +
                "remove_greater : удалить из коллекции все элементы, превышающие заданный. \n" +
                "remove_lower : удалить из коллекции все элементы, меньшие, чем заданный. \n" +
                "remove_lower_key : удалить из коллекции все элементы, ключ которых меньше, чем заданный. \n" +
                "count_greater_than_distance : вывести количество элементов, значение поля distance которых больше заданного. \n" +
                "filter_by_distance distance : вывести элементы, значение поля distance которых равно заданному. \n" +
                "filter_starts_with_name : вывести элементы, значение поля name которых начинается с заданной подстроки. \n");
    }
}
