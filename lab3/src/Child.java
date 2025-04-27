import java.util.ArrayList;
import java.util.List;

public class Child extends Mymi {

    private Dress dress;
    private boolean inDangerous = true;
    private static Child thoughts = new Child("Мысли");
    public Child(String name){
        super(name);
    }
    public Child(String name, String role, String thirdform1, String thirdform2, String thirdform3, List<String> history) {
        super(name, role, thirdform1, thirdform2, thirdform3, new ArrayList<>());
        this.dress = new Dress();
    }
    public String hold(Mymi character, Location location) {
        class Falling {
            private Boolean isHolding = true;
            public String preventFalling() {
                if (isHolding) {
                    return dress.holdDress(character) + "чтобы предотвратить падение в " + location.toString() + ". ";
                }
                else {
                    return "Высокий риск падения!";
                }
                }
            }

        Falling falling = new Falling();
        return falling.preventFalling();
    }

    private class Dress {
        public String holdDress(Mymi character) {
            return character.getName() + " держала ее за платье, ";
        }
    }


    public String getThoughts() {
        return thoughts.toString() + " ";
    }
}
