public class Aquarid extends Creature{

    // water floor
    // if they are in a room adjacent to an adventurer, they will move
    // to that adventurers room
    // If no adventurer in adjacent room or if adventurer is already on the floor
    // they won't move

    public String toString() {
        return "A";
    }

    public Aquarid(Room room){
        this.room = room;
        room.creatures.add(this);
    }

    @Override
    public void move() {
        for (Room r : room.adjacentRooms) {
            if (!r.adventurers.isEmpty() && !r.startingRoom) {
                room.creatures.remove(this);
                room = r;
                room.creatures.add(this);
                return;
            }
        }
    }
}
