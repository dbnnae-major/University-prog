package Moves;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    public void applySelfEffects(Pokemon pokemon){
        pokemon.setMod(Stat.EVASION,+1);
    }

    @Override
    protected String describe() {
        return "Double Team";
    }
}
