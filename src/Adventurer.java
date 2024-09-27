public abstract class Adventurer extends Character {
    public int health;
    public double dodgeChance;
    public int treasures = 0;
    public ElementType resonance;
    public ElementType discord;

    public abstract int searchTreasure();

    public abstract void combat(Creature creature);
    public boolean dodgeFailure(double dodgeChance){
        return !(Math.random() < dodgeChance);
    }
    public boolean isDead(){
        return health <= 0;
    }

}
