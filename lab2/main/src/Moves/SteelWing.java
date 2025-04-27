package Moves;

import ru.ifmo.se.pokemon.*;
public class SteelWing extends PhysicalMove {

    public SteelWing() {
        super(Type.STEEL, 70, 90);
    }

    int flag = 0;
    protected void applySelfEffects(Pokemon pokemon){
        if (Math.random() <= 0.1) {
            pokemon.setMod(Stat.DEFENSE, +1);
            flag = 1;
        }

    }

    @Override
    protected String describe() {
        if (flag == 0) {
            return "Steel Wing";
        }
        else {
            return "Steel Wing + DEFENSE(+1)";
        }
    }
}
