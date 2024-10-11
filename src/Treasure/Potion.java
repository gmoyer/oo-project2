package Treasure;

public class Potion extends Treasure {
    @Override
    public int getValue() {
        return 500 + next.getValue();
    }

    @Override
    public int healthBonus() {
        return 1 + next.healthBonus();
    }

    @Override
    public String toString() {
        return "Potion " + next.toString();
    }
}
