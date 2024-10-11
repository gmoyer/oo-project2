package Treasure;

public class Elixir extends Treasure {
    @Override
    public int getValue() {
        return 500 + next.getValue();
    }

    @Override
    public double dodgeBonus() {
        return 0.1 + next.dodgeBonus();
    }

    @Override
    public String toString() {
        return "Elixir " + next.toString();
    }
}
