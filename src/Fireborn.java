public class Fireborn extends Creature{

    //get room and column then go to adjacent room
    //remove from current room
    // add creature to new room and update reference

    //move in the fire floor, clockwise or counterclockwise
    //Won't move if an adventurer is on floor
    Room roomF;
    int row = (int)Math.random()*3 + 1;
    int col = (int)Math.random()*3 + 1;
    public Fireborn() {
        // spawn a new fireborn creature
        // pick a random room on the fire floor

        roomF = new Room(row, col);
        if(roomF.adventurers.size() == 0) {
            move();
        }
    }

    @Override
    public void move() {
            //move to adjacent room -- counter/clockwise
            roomF.getAdjacentRoom(row, col);

    }
}
