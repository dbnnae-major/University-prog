public class Woodshed {

    private String name;
    public Woodshed(String name){
        this.name = name;
    }
    public static class RoofPart {
        private String name2;
        public RoofPart(){
            this.name2 = "конек крыши";
        }
        public String riseAbove(Location location) {
            return "Лишь часть крыши дровяного сарая возвышалась над " + location.getSex() + ". ";
        }

        @Override
        public String toString(){
            return name2;
        }

    }
}
