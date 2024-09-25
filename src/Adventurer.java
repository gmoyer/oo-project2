import java.util.Random;

public abstract class Adventurer extends Character {
    private int health;
    private float dodgeChance;
    private int treasures;
    private Room room;
    private ElementType resonance;
    private ElementType discord;

    public void search(Floor floor){

    }
    /*
    public void combat(Creature creature){
        Random rand = new Random();
        int advRoll = 0;
        int creRoll = 0;
        for (int i = 0; i < 2; i++) {
            int s1 = rand.nextInt(1,6);
            int s2 = 6;//rand.nextInt(1,6);
            advRoll = advRoll + s1;
            creRoll = creRoll + s2;
        }
        System.out.println("Adventurer: " + advRoll);
        System.out.println("Creature: " + creRoll);
        if(advRoll < creRoll){
            System.out.println("Adventurer Lost!");
            System.out.println("Stand by for dodge chance");
            boolean hit = dodgeSuccess(dodgeChance);
            System.out.println(hit);
            if(hit == true){
                System.out.println("Adventurer gets hit and loses life");
            }else {
                System.out.println("Adventurer Survives");
            }
        }else if(advRoll > creRoll) {
            System.out.println("Adventurer Wins!");
            System.out.println("Creature Dies");
        }else {
            System.out.println("Nothing Happened!");
        }

    }
    public boolean dodgeSuccess(float dodgeChance){
        Random random = new Random();
        float numerator = dodgeChance*100;
        int denominator = 100;
        float chance = random.nextInt(1,denominator);
        if(chance < numerator){
            return false;
        }else {
            return true;
        }
    }

     */
    public int getTreasures(){
        return 100;
    }




}
