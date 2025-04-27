package Moves;

import ru.ifmo.se.pokemon.*;

public class ThunderFang extends SpecialMove {
    public ThunderFang() {
        super(Type.ELECTRIC, 90, 100);
    }

    int flag1 = 0;
    int flag2 = 0;

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() <= 0.1) {
            Effect.paralyze(pokemon);
            flag1 = 1;
        }
        if (Math.random() <= 0.1) {
            Effect.flinch(pokemon);
            flag2 = 1;
        }
    }

    @Override
    protected String describe() {
        if (flag1 == 0) {
            if (flag2 == 0) {
                return "Thunder Fang";
            } else {
                return "Thunder Fang + FLINCH";
            }
        } else {
            if (flag2 == 0) {
                return "Thunder Fang + PARALYZE";
            } else {
                return "Thunder Fang + PARALYZE + FLINCH";
            }
        }

    }
}
