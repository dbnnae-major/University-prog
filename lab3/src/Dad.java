import java.util.ArrayList;
import java.util.List;

public class Dad extends Mymi {
    private static Dad thoughts = new Dad("Мысли");
    public Dad(String name){
        super(name);
    }
    public Dad(String name, String role, String thirdform1, String thirdform2, String thirdform3, List<String> history) {
        super(name, role, thirdform1, thirdform2, thirdform3, new ArrayList<>());
    }

    public String getThoughts() {
        return thoughts.toString() + " ";
    }
}
