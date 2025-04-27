public class World {

    private Boolean isChange = false;
    public Bridge bridge;
    public River river;
    public Lilac lilac;
    public Jasmine jasmine;

    public World() {
        bridge = new Bridge();
        river = new River();
        lilac = new Lilac();
        jasmine = new Jasmine();
    }

    public Bridge getBridge() throws NullPointerException {
        return bridge;
    }

    public River getRiver() throws NullPointerException {
        return river;
    }

    public Lilac getLilac() throws NullPointerException {
        return lilac;
    }

    public Jasmine getJasmine() throws NullPointerException {
        return jasmine;
    }

    public class Bridge {
        private int length;
        private String state;

        public void setLength(int length) {
            this.length = length;
        }

        public void setState(String state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return "мост";
        }
    }

    public class Lilac {
        private String color;
        private int height;

        public void setColor(String color) {
            this.color = color;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "сирень";
        }
    }

    public class Jasmine {
        private String fragrance;
        private int petals;

        public void setFragrance(String fragrance) {
            this.fragrance = fragrance;
        }

        public void setPetals(int petals) {
            this.petals = petals;
        }

        @Override
        public String toString() {
            return "жасмин";
        }
    }

    public class River {
        private int length;
        private int width;
        private int waterLevel;

        public void setLength(int length) {
            this.length = length;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setWaterLevel(int waterLevel) {
            this.waterLevel = waterLevel;
        }

        @Override
        public String toString() {
            return "река";
        }
    }

    public String change() {
        isChange = true;
        return "Весь мир изменился. ";
    }

    public String dissapear(Bridge bridge, River river) throws NullPointerException {
        if (bridge == null || river == null) {
            throw new NullPointerException("Объектов не существует, вы ссылаетесь на объект типа null");
        } else {
            this.bridge = null;
            this.river = null;
            return "не стало моста и целой реки. ";
        }
    }

    public String dissapear(Jasmine jasmine, Lilac lilac) throws NullPointerException {
        if (jasmine == null || lilac == null) {
            throw new NullPointerException("Объектов не существует, вы ссылаетесь на объект типа null");
        } else {
            this.jasmine = null;
            this.lilac = null;
            return "Не стало жасмина и сирени, ";
        }
    }

    @Override
    public String toString() {
        return "Состояние мира: " + (isChange ? " изменен" : " прежний");
    }
}
