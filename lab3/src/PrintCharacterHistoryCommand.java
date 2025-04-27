import java.util.*;

public class PrintCharacterHistoryCommand implements Command{
    private Scanner scanner;
    private List<Mymi> characters;

    public PrintCharacterHistoryCommand(Scanner scanner, List<Mymi> characters) {
        this.scanner = scanner;
        this.characters = characters;
    }
    private Mymi findCharacterByName(String name) {
        for (Mymi character : characters) {
            if (character.getName().equals(name)) {
                return character;
            }
        }
        return null;
    }

    @Override
    public void execute() {
        System.out.print("Введите имя персонажа: ");
        String name = scanner.nextLine();

        Mymi character = findCharacterByName(name);

        if (character != null) {
            List<String> history = character.getHistory();
            System.out.println("История персонажа " + name + ":");
            if (!history.isEmpty()) {
                for (String action : history) {
                    System.out.println(action);
                }
            }
            else{
                System.out.println("у персонажа " + name + " нет истории(");
            }
        } else {
            System.out.println("Персонаж " + name + " не найден");
        }
    }

    @Override
    public String toString(){
        return "history";
    }
}
