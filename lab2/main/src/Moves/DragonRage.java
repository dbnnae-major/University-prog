package Moves;

import ru.ifmo.se.pokemon.*;

public class DragonRage extends SpecialMove {
    public DragonRage() {
        super(Type.DRAGON, 40, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon){
        if (Math.random() <= 0.2) {
            pokemon.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }

    @Override
    protected String describe() {
        return "Dragon Rage";
    }
}
