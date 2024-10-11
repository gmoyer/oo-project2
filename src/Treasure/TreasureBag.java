package Treasure;

public abstract class TreasureBag {
    protected int value;

    public abstract int getValue();
    public abstract int combatBonus();
    public abstract int armorBonus();
    public abstract int healthBonus();
    public abstract int searchBonus();
    public abstract int dodgeBonus();
    public abstract int creatureBonus();
}
