package Treasure;

public class Shield extends Treasure {
    @Override
    public int getValue() {
        return 800 + next.getValue();
    }

    @Override
    public int armorBonus() {
        return 1 + next.armorBonus();
    }

    @Override
    public String toString() {
        return "Shield " + next.toString();
    }
}
