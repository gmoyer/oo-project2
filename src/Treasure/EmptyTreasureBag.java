package Treasure;

public class EmptyTreasureBag extends TreasureBag {
    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public int combatBonus() {
        return 0;
    }

    @Override
    public int armorBonus() {
        return 0;
    }

    @Override
    public int healthBonus() {
        return 0;
    }

    @Override
    public int searchBonus() {
        return 0;
    }

    @Override
    public double dodgeBonus() {
        return 0;
    }

    @Override
    public int creatureBonus() {
        return 0;
    }

    @Override
    public String toString() {
        return "";
    }
}
