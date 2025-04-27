package Pokemons;

import Moves.DoubleTeam;
import Moves.Headbutt;
import Moves.ShadowBall;
import Moves.FocusBlast;
import ru.ifmo.se.pokemon.Type;

public class Hypno extends Drowzee{
    public Hypno(String name, int level){
        super(name, level);
        this.setStats(85,73,70,73,115,67);
        this.setType(Type.PSYCHIC);
        this.setMove(new DoubleTeam(), new ShadowBall(), new Headbutt(), new  FocusBlast());
    }
}
