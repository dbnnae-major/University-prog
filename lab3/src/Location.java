public enum Location implements ToGetIn {
    porch("Крыльц", "С"),window("Окно","Окну"),windowsill("подоконник","м"),
    mountains("Горы","Цепи-гор"),trees("Деревья","-"),kitchen("Кухн","Ж"),
    locker("Навесной Шкафчик","М"),jar("Банка с кофе","Ж"),livingroom("Гостин","Ж"),
    water("вод","водой");

    protected String translation;
    protected String sex;
    Location(String translation, String sex) {
        this.translation = translation;
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }
    public void grow(){
        System.out.print("Деревья росли прямо из воды, ");
    }
    public void surround(Location location){
        System.out.print(location.getSex() +", окружавшие Муми-Дол, ");
    }
    public void destroy(){
        System.out.print("распались на множество островков. ");
    }
    public void keep(Location location) {
        switch (location.toString()) {
            case "Банка с кофе" -> System.out.print("где хранилась " + location + ". ");
            case "вод" -> System.out.print("где хранилась " + location + "а. ");
        }
    }
    public void wasnt(Location location){
        switch (location.toString()) {
            case "Кухн" -> System.out.print(location + "и не было,");
            case "Крыльц" -> System.out.print(location + "а не было,");
            case "Гостин" -> System.out.print(location + "ой не было,");
        }
    }
    public void dissapear(Location location1, Location location2){
        switch (location1.getSex()) {
            case "С" -> System.out.print("оно скрылось в беспокойной " + location2 + "е. ");
            case "М" -> System.out.print("он скрылся в беспокойной " + location2 + "е. ");
            case "Ж" -> System.out.print("она скрылась в беспокойной " + location2 + "е. ");
        }
    }
    public void direct(Location location){
        switch (location.toString()) {
            case "Кухн" -> System.out.println("ведущего в " + location + "ю.");
            case "Крыльц" -> System.out.println("ведущего в " + location + "о.");
            case "Гостин" -> System.out.println("ведущего в " + location + "ую.");
        }
    }
    @Override
    public String toGetIn(Location location1, Location location2) {
        System.out.print("Из " + location1 + " есть проход в " + location2);
        return null;
    }
    @Override
    public String toString() {
        return translation;
    }
}