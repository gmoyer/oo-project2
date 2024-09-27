import java.util.Random;

public abstract class Character {

    public int diceRollGenerator(){
        Random random = new Random();
        int roll1 = 5;//random.nextInt(1,6);
        int roll2 = 6;//random.nextInt(1,6);
        return roll1+roll2;
    }
}
