import java.util.*;

public class Main {
    static final Mymi mama = new Mama("Мюмла", "Мама", "Она", "Ей", "Мамы", new ArrayList<>());
    static final Mymi dad = new Dad("Муми-папа", "Папа", "Он", "Ему", "Папы", new ArrayList<>());
    static final Mymi child = new Child("Малышка Мю", "Ребенок", "Она", "Ей", "Малышки Мю", new ArrayList<>());
    static final Family family = new Family("Семья Муми-троллей", mama, dad, child);
    static final Woodshed.RoofPart roofpart = new Woodshed.RoofPart();
    static final World world = new World();

    private static void story() {
        family.getUp("тотчас");
        System.out.print(" и ");
        try {
            System.out.print(family.rush());
        } catch (ActionException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.print(family.put(child,Location.windowsill));
        } catch (ActionException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("а ");

        System.out.println(child.hold(mama, Location.window));
        mama.performAction(child.hold(mama, Location.window));

        System.out.print(world.change());
        try {
            System.out.print(world.dissapear(world.jasmine,world.lilac));
            System.out.print(world.dissapear(world.bridge,world.river));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


        System.out.println(roofpart.riseAbove(Location.water));

        Hookable company = new Hookable() {
            @Override
            public void hook() {
                System.out.print("Какая-то " + name + " видимо лесных жителей, судорожно цеплялась за " + roofpart + ". ");
            }
        };
        company.hook();

        Location.trees.grow();
        Location.mountains.surround(Location.mountains);
        Location.trees.destroy();

        System.out.print(mama.lookAt(Location.porch));
        mama.performAction(mama.lookAt(Location.porch));

        Location.porch.direct(Location.livingroom);
        Location.porch.wasnt(Location.porch);
        Location.porch.dissapear(Location.porch, Location.water);

        System.out.print(mama.think(Location.kitchen));
        mama.performAction(mama.think(Location.kitchen));

        System.out.print(mama.remember(Location.locker));
        mama.performAction(mama.remember(Location.locker));

        Location.locker.keep(Location.jar);

        System.out.println(mama.doubt());
        mama.performAction(mama.doubt());

        System.out.print(mama.toGetIn(Location.kitchen, Location.kitchen));
        mama.performAction(mama.toGetIn(Location.kitchen, Location.kitchen));

        System.out.print(mama.getThoughts());
        mama.performAction(mama.getThoughts());

        System.out.print(mama.returns(Location.locker));
        mama.performAction(mama.returns(Location.locker));

        System.out.println(dad.lookAt(dad));
        dad.performAction(dad.lookAt(dad));

        System.out.println("------------------------------------------------ Конец истории -----------------------------------------------");
    }

    public static void main(String[] args){
        Main.story();

        Scanner scanner = new Scanner(System.in);
        List<Mymi> characters = new ArrayList<>();
        Deque<Command> historyStack = new ArrayDeque<>();
        characters.add(mama);
        characters.add(dad);
        characters.add(child);
        CommandExecutor executor = new CommandExecutor(historyStack);

        executor.registerCommand("history", new PrintCharacterHistoryCommand(scanner, characters));
        executor.registerCommand("exit", new ExitCommand());
        executor.registerCommand("all", new PrintAllCharactersCommand(characters));
        executor.registerCommand("request", new PrintLastFiveActionsCommand(historyStack));

        System.out.println("all - Выводит список персонажей" + "\n"  +
                "history - Выводит историю персонажа" + "\n" + "request - Выводит последние 5 вызванных команд" + "\n" +
                "exit - Выход из приложения" + "\n" + "Введите команду:");
        while (true) {
            String command = scanner.nextLine();
            executor.executeCommand(command, historyStack);
        }
    }
}