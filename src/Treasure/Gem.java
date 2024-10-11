package Treasure;

public class Gem extends Treasure {
    @Override
    public int getValue() {
        return 1000 + next.getValue();
    }

    @Override
    public int creatureBonus() {
        return 1 + next.creatureBonus();
    }

    @Override
    public String toString() {
        return "Gem " + next.toString();
    }
}
