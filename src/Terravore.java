public class Terravore extends Creature{

    // earth floor
    // don't move and stay at the position they spawn

    Room roomT;
    int row = (int)Math.random()*3 + 1;
    int col = (int)Math.random()*3 + 1;

    public Terravore() {
        roomT = new Room(row, col);
        if (roomT.adventurers.size() == 0) {
            move();
        }
    }

    @Override
    public void move() {
        //does nothing
    }



    public String toString() {
        return "T";
    }
}
