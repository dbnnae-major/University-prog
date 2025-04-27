package Moves;

import ru.ifmo.se.pokemon.*;
public class Hypnosis extends StatusMove {

    public Hypnosis() {
        super(Type.PSYCHIC, 0, 60);
    }

    @Override
    public void applyOppEffects(Pokemon pokemon){
        Effect.sleep(pokemon);
    }

    @Override
    protected String describe() {
        return "Hypnosis";
    }
}
