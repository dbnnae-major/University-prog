package Moves;

import ru.ifmo.se.pokemon.*;

public class DragonBreath extends SpecialMove {

    public DragonBreath() {
        super(Type.DRAGON, 60, 100);
    }

    int flag = 0;
    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() <= 0.3) {
            Effect.paralyze(pokemon);
            flag = 1;
        }
    }

    @Override
    protected String describe() {
        if (flag == 0){
            return "Dragon Breath";
        }
        else
        {
            return "Dragon Breath + PARALYZE";
        }

    }
}
