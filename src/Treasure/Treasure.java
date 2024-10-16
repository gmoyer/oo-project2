package Treasure;

public abstract class Treasure extends TreasureBag {
    protected TreasureBag next;

    public Treasure newBag(TreasureBag next) {
        this.next = next;
        return this;
    }

    @Override
    public int combatBonus() {
        return next.combatBonus();
    }

    @Override
    public int armorBonus() {
        return next.armorBonus();
    }

    @Override
    public int healthBonus() {
        return next.healthBonus();
    }

    @Override
    public int searchBonus() {
        return next.searchBonus();
    }

    @Override
    public double dodgeBonus() {
        return next.dodgeBonus();
    }

    @Override
    public int creatureBonus() {
        return next.creatureBonus();
    }
}
