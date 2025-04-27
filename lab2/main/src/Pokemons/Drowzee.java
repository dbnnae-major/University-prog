    package Pokemons;

    import Moves.Hypnosis;
    import Moves.Waterfall;
    import ru.ifmo.se.pokemon.Pokemon;
    import ru.ifmo.se.pokemon.Type;
    import Moves.DoubleTeam;
    import Moves.ShadowBall;
    import Moves.Headbutt;
    public class Drowzee extends Pokemon {
        public Drowzee(String name, int level) {
            super(name, level);
            this.setStats(60, 48, 45, 43, 90, 42);
            this.setType(Type.PSYCHIC);
            this.setMove(new DoubleTeam(), new ShadowBall(), new Headbutt());
        }
    }
