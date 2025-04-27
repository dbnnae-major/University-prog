public class Troll implements ToGetIn, Live {
    protected String name;
    public Troll(String name){
        this.name = name;
    }
    @Override
    public String toGetIn(Location location1, Location location2) {
        System.out.print(name + " бежит из " + location1 + " в " + location2);
        return null;
    }

    @Override
    public void live() {
        System.out.print(name +" жива");
    }

    @Override
    public void grow() {
        System.out.print(name +" жива");
    }
}
