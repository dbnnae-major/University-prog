package Moves;

import ru.ifmo.se.pokemon.*;

public class FocusBlast extends SpecialMove {
    public FocusBlast(){
        super(Type.FIGHTING,120,70);
    }
    int flag = 0;
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        if (Math.random() <= 0.1){
            pokemon.setMod(Stat.SPECIAL_DEFENSE, 0);
            flag = 1;
        }
    }
    @Override
    protected String describe(){
        if (flag == 0){
            return "Focus Blast";
        }
        else{
            return "Focus Blast + SPECIAL_DEFENSE(0)";
        }
    }
}
