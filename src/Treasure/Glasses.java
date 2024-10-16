package Treasure;

public class Glasses extends Treasure {
    @Override
    public int getValue() {
        return 900 + next.getValue();
    }

    @Override
    public int searchBonus() {
        return 1 + next.searchBonus();
    }

    @Override
    public String toString() {
        return "Glasses " + next.toString();
    }
}
