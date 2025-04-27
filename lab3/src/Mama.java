import java.util.*;

public class Mama extends Mymi implements Live {

    private static Mama thoughts = new Mama("Мысли");

    public Mama(String name) {
        super(name);
    }

    public Mama(String name, String role, String thirdform1, String thirdform2, String thirdform3, List<String> history) {
        super(name, role, thirdform1, thirdform2, thirdform3, new ArrayList<>());
    }

    public String getThoughts() {
        return thoughts.toString() + " ";
    }

    @Override
    public void live() {
        System.out.print("Мама жива");
    }

    @Override
    public void grow() {
        System.out.print("Мама растет");
    }

    @Override
    public String toString() {
        return name;
    }
}
