public class Aquarid extends Creature{

    // water floor
    // if they are in a room adjacent to an adventurer, they will move
    // to that adventurers room
    // If no adventurer in adjacent room or if adventurer is already on the floor
    // they won't move

    Room roomA;
    int row = (int)Math.random()*3 + 1;
    int col = (int)Math.random()*3 + 1;

    public Aquarid(){
        roomA = new Room(row, col);
        if (roomA.adventurers.size() > 0) {
            // see if adventurer is in adjacent room
            // move to that room
        }
        else{
            //don't move
        }
    }

    @Override
    public void move() {
        // move to specific room
        
    }
}
