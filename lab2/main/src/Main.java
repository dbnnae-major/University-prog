import Pokemons.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Zekrom p1 = new Zekrom("Дракончелла", 1);
        Poliwag p2 = new Poliwag("Блюп", 1);
        Poliwhirl p3 = new Poliwhirl("Блюп X2", 1);
        Drowzee p4 = new Drowzee("Нос >_<", 1);
        Hypno p5 = new Hypno("Колдун", 1);
        Poliwrath p6 = new Poliwrath("Ламбада", 1);
        b.addAlly(p2);
        b.addAlly(p1);
        b.addFoe(p4);
        b.addFoe(p3);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }
}
