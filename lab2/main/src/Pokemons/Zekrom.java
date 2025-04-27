package Pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import Moves.ThunderFang;
import Moves.DragonBreath;
import Moves.DragonRage;
import Moves.SteelWing;

public class Zekrom extends Pokemon {
    public Zekrom(String name, int level) {
        super(name, level);
        this.setStats(100, 150, 120, 120, 100, 90);
        this.setType(Type.DRAGON, Type.ELECTRIC);
        this.setMove(new ThunderFang(), new DragonBreath(), new DragonRage(), new SteelWing());
    }
}
