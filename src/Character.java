public abstract class Character {
    //This is an example of abstraction. This class is abstract so we can implement our different types
    // of characters we have
    public Room room;

    /*
    * Move characters around a room on a specific floor
    */

    public abstract void move();

    public String toString(){
        return "";
    }

    public int roll(){
        int roll1 = (int)(Math.random() * 6) + 1;
        int roll2 = (int)(Math.random() * 6) + 1;
        return roll1+roll2;
    }


}
