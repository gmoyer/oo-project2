package Treasure;

public class Sword extends Treasure {
    @Override
    public int getValue() {
        return 1100 + next.getValue();
    }

    @Override
    public int combatBonus() {
        return 1 + next.combatBonus();
    }

    @Override
    public String toString() {
        return "Sword " + next.toString();
    }
}
