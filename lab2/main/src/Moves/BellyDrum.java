package Moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class BellyDrum extends StatusMove {

    public BellyDrum() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon){
        if (Math.random() <= 0.1){
            pokemon.setMod(Stat.SPECIAL_DEFENSE, 0);
        }
    }

    @Override
    protected String describe() {
        return "BellyDrum";
    }

}
