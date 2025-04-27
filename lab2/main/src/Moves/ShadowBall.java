package Moves;

import Pokemons.Poliwhirl;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class ShadowBall extends SpecialMove {
    public ShadowBall(){
        super(Type.GHOST,80,100);
    }
    int flag = 0;
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        if (Math.random() <= 0.2) {
            pokemon.setMod(Stat.SPECIAL_DEFENSE, -1);
            flag = 1;
        }
    }

    @Override
    protected String describe() {
        if (flag == 0){
            return "ShadowBall";
        }
        else{
            return "ShadowBall + SPECIAL_DEFENSE(-1)";
        }
    }
}
