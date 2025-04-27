package Pokemons;


import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import Moves.Waterfall;
import Moves.Hypnosis;

public class Poliwag extends Pokemon {
    public Poliwag(String name, int level) {
        super(name, level);
        this.setStats(40, 50, 40, 40, 40, 90);
        this.setType(Type.WATER);
        this.setMove(new Waterfall(), new Hypnosis());
    }
}
