import Treasure.TreasureBag;

public abstract class Adventurer extends Character {
    Expertise combatExpertise;
    Expertise searchExpertise;
    public int health;
    public double dodgeChance;
    public ElementType resonance;
    public ElementType discord;
    protected TreasureBag treasureBag;

    public abstract void searchTreasure();
    public void takeTreasure() {
        if (room.treasure != null) {
            treasureBag = room.treasure.newBag(treasureBag);
            room.treasure = null;
            searchExpertise = searchExpertise.levelUp();
        }
    }

    public abstract void combat(Creature creature);
    public boolean dodgeFailure(double dodgeChance){
        return !(Math.random() < dodgeChance + treasureBag.dodgeBonus());
    }
    public boolean isDead(){
        return health + treasureBag.healthBonus() <= 0;
    }

}
