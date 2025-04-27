package Pokemons;

import Moves.Hypnosis;
import Moves.Waterfall;
import Moves.BellyDrum;
import ru.ifmo.se.pokemon.Type;

public class  Poliwhirl extends Poliwag {

    public Poliwhirl(String name, int level) {
        super(name, level);
        this.setStats(65, 65, 65, 50, 50, 90);
        this.setType(Type.WATER);
        this.setMove(new Waterfall(), new Hypnosis(), new BellyDrum());
    }
}
