public class Family {

    final String name;
    final Mymi mama;
    final Mymi dad;
    final Mymi child;

    private boolean isSleeping = true;

    public Family(String name, Mymi mama, Mymi dad, Mymi child) { //конкструктор семьи
        this.name = name;
        this.mama = mama;
        this.dad = dad;
        this.child = child;
    }

    public void getUp(String time) {
        System.out.print(name + " " + time + " проснулась");
        isSleeping = false;
    }

    public void fallAsleep(String time) {
        System.out.println(name + " " + time + " заснула");
        isSleeping = true;
    }

    public String rush() throws ActionException {
        if (isSleeping) {
            throw new ActionException("Невозможное действие, семья спит!");
        } else {
            return "бросилась к " + Location.window.getSex() + ". ";
        }
    }

    public String put(Mymi character, Location location) throws ActionException {
        if (isSleeping) {
            throw new ActionException("Невозможное действие, семья спит!");
        } else {
            return character.name + " поставили на " + location.toString() + ", ";
        }
    }

    @Override
    public String toString() {
        return name + " состоит из " + mama.thirdform3 + " " + dad.thirdform3 + " " + child.thirdform3 + "." + '\n' +
                "Состояние семьи = " + (isSleeping ? "спит." : "не спит.");
    }
}
