public class Fireborn extends Creature{

    //get room and column then go to adjacent room
    //remove from current room
    // add creature to new room and update reference

    //move in the fire floor, clockwise or counterclockwise
    //Won't move if an adventurer is on floor
    public Fireborn(Room room) {
        this.room = room;
        room.creatures.add(this);
    }

    public String toString() {
        return "F";
    }

    @Override
    public void move() {
        int newRow = room.row;
        int newCol = room.col;
        if (room.row == 0 && room.col > 0) {
            newCol = room.col - 1;
        } else if (room.col == 0 && room.row < 2) {
            newRow = room.row + 1;
        } else if (room.row == 2 && room.col < 2) {
            newCol = room.col + 1;
        } else {
            newRow = room.row - 1;
        }
        Room r = room.getAdjacentRoom(newRow, newCol);
        room.creatures.remove(this);
        room = r;
        room.creatures.add(this);
    }
}
