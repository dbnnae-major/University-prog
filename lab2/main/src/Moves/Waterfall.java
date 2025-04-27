package Moves;

import ru.ifmo.se.pokemon.*;

public class Waterfall extends PhysicalMove {
    public Waterfall() {
        super(Type.WATER, 80, 100);
    }

    int flag = 0;

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() <= 0.2) {
            Effect.flinch(pokemon);
            flag = 1;
        }
    }

    @Override
    protected String describe() {
        if (flag == 0) {
            return "Waterfall";
        } else {
            return "Waterfall + FLINCH";
        }
    }

}
