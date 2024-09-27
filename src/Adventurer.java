import java.util.Random;

public abstract class Adventurer extends Character {
    private int health;
    private float dodgeChance;
    private int treasures;
    private Room room;
    private ElementType resonance;
    private ElementType discord;

    public abstract void searchTreasure(Room room);

    public abstract void combat(Creature creature, Room room);
    public boolean dodgeSuccess(float dodgeChance){
        Random random = new Random();
        float numerator = dodgeChance * 100;
        int denominator = 100;
        float chance = random.nextInt(denominator);
        if(chance > numerator){
            return false;
        }else {
            return true;
        }
    }
    public int getTreasures(){
        return treasures;
    }
    public abstract int getHealth();
    public void addTreasures(int treasures){
        this.treasures += treasures;
    }
    //Theres a bug in checkHealth, sometimes it works others it doesn't
    public boolean checkHealth(){
        if(Integer.compare(health,0) == -1){
            return true;
        }
        else if (Integer.compare(health,0)==0){
            return true;
        }
        else {
            return false;
        }
    }
    public abstract void removeHealth(int hit);
    public abstract float getDodgeChance();

}
