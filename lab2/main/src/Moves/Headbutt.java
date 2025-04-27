package Moves;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Headbutt extends PhysicalMove {
    public Headbutt(){
        super(Type.NORMAL,70,100);
    }
    int flag = 0;
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        if (Math.random() <= 0.3){
            Effect.flinch(pokemon);
            flag = 1;
        }
    }

    @Override
    protected String describe(){
        if (flag == 0){
            return "Headbutt";
        }
        else{
            return "Headbutt + FLINCH";
        }
    }
}
