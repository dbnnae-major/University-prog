package Moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Psychic extends SpecialMove {

    public Psychic() {
        super(Type.PSYCHIC,90,100);
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        if (Math.random() <= 0.1){
            pokemon.setMod(Stat.SPECIAL_DEFENSE, -1);
        }
    }


    @Override
    protected String describe() {
        return "Псутчик";
    }
}
