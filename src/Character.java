import java.util.Random;

public abstract class Character {
    Room room;

    /*
    * Move characters around a room on a specific floor
    */
    public abstract void move();

    public String toString(){
        return "";
    }

    public int diceRollGenerator(){
        Random random = new Random();
        int roll1 = 5;//random.nextInt(1,6);
        int roll2 = 6;//random.nextInt(1,6);
        return roll1+roll2;
    }


}
