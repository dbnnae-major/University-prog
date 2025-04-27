import java.util.*;

public class PrintAllCharactersCommand implements Command{
    private List<Mymi> characters;
    public PrintAllCharactersCommand(List<Mymi> characters) {
        this.characters = characters;
    }

    @Override
    public void execute() {
        if (!characters.isEmpty()) {
            System.out.println("Список всех персонажей:");
            for (Mymi character : characters) {
                System.out.println(character.getName());
            }
        } else {
            System.out.println("Нет добавленных персонажей");
        }
    }

    @Override
    public String toString(){
        return "all";
    }
}
