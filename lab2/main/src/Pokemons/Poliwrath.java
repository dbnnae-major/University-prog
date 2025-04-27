package Pokemons;

import Moves.DoubleTeam;
import Moves.Headbutt;
import Moves.ShadowBall;
import Moves.Psychic;
import ru.ifmo.se.pokemon.Type;

public class Poliwrath extends Poliwhirl {
    public Poliwrath(String name, int level) {
        super(name, level);
        this.setStats(65,65,65,50,50,90);
        this.setType(Type.WATER);
        this.setMove(new DoubleTeam(), new ShadowBall(), new Headbutt(), new Psychic());
    }
}
