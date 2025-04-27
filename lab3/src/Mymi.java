import java.util.List;
import java.util.Objects;

public abstract class Mymi implements ToGetIn {
    protected String name;
    protected String role;
    protected String thirdform1;
    protected String thirdform2;
    protected String thirdform3;

// ----------------------------------------------   СОХРАНЕНИЕ ИСТОРИИ ПЕРСОНАЖА
    private List<String> history;

    public List<String> getHistory() {
        return history;
    }
    public void performAction(String action) {
        history.add(action);
    }
// ----------------------------------------------   СОХРАНЕНИЕ ИСТОРИИ ПЕРСОНАЖА

    public Mymi(String name, String role, String thirdform1, String thirdform2, String thirdform3, List<String> history) {
        this.name = name;
        this.role = role;
        this.thirdform1 = thirdform1;
        this.thirdform2 = thirdform2;
        this.thirdform3 = thirdform3;
        this.history = history;
    }

    public Mymi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String doubt() {
        return "Однако " + thirdform1 + " засомневалась, ";
    }

    public String remember(Location location) {
        switch (location.toString()) {
            case "Кухн" -> {
                return thirdform2 + " вспомнилась " + location + "я, ";
            }
            case "Гостин" -> {
                return thirdform2 + " вспомнилась " + location + "ая, ";
            }
            case "Крыльц" -> {
                return thirdform2 + " вспомнилось " + location + "о, ";
            }
            case "Навесной Шкафчик" -> {
                return thirdform2 + " вспомнился " + location + ", ";
            }
        }
        return null;
    }

    public String think(Location location) {
        switch (location.toString()) {
            case "Кухн" -> {
                return thirdform1 + " подумала о своей " + location + "е. ";
            }
            case "Гостин" -> {
                return thirdform1 + " подумала о своей " + location + "ой. ";
            }
            case "Крыльц" -> {
                return thirdform1 + " подумала о своем " + location + "е. ";
            }
        }
        return null;
    }

    public String returns(Location location) {
        switch (location.toString()) {
            case "Навесной Шкафчик" -> {
                return thirdform3 + " все время возвращались к этому Шкафчику. ";
            }
            case "Кухн" -> {
                return thirdform3 + " все время возвращались к этой " + location + "е.";
            }
            case "Гостин" -> {
                return thirdform3 + " все время возвращались к этой " + location + "ой.";
            }
            case "Крыльц" -> {
                return thirdform3 + " все время возвращались к этому " + location + "у.";
            }
        }
        return null;
    }

    public String getThoughts() {
        return "хм..... ";
    }

    public String lookAt(Location location) {
        switch (location.toString()) {
            case "Кухн" -> {
                return this.role + " посмотрела в сторону " + location + "и, ";
            }
            case "Крыльц" -> {
                return this.role + " посмотрела в сторону " + location + "а, ";
            }
            case "Гостин" -> {
                return this.role + " посмотрела в сторону " + location + "ой, ";
            }
        }
        return null;
    }

    public String lookAt(Mymi character) {
        return character.getName() + " посмотрел на них.";
    }

    public String hold(Mymi character, Location location) {
        return character.getName() + "что-то держит";
    }


    @Override
    public String toGetIn(Location location1, Location location2) {
        switch (location1.toString()) {
            case "Кухн" -> {
                return "удастся ли " + thirdform2 + " попасть в свою " + location1 + "ю. ";
            }
            case "Гостин" -> {
                return "удастся ли " + thirdform2 + " попасть в свою " + location1 + "ую. ";
            }
            case "Крыльц" -> {
                return "удастся ли " + thirdform2 + " попасть на свое " + location1 + "о. ";
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Classes.classes.Human{" +
                "name='" + name + '\'' +
                ", thirdform1='" + thirdform1 + '\'' +
                ", thirdform2='" + thirdform2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mymi mymi = (Mymi) o;
        return Objects.equals(name, mymi.name) && Objects.equals(thirdform1, mymi.thirdform1) && Objects.equals(thirdform2, mymi.thirdform2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, thirdform1, thirdform2);
    }

}
