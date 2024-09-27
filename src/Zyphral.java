public class Zyphral extends Creature{

    //move on air floor
    // randomly move between rooms on the floor
    // won't move if an adventurer is present

    public String toString() {
        return "Z";
    }


    public Zyphral(Room room){
        this.room = room;
        room.creatures.add(this);
    }

    @Override
    public void move(){
        Floor floor = room.floor;
        for (Room[] row : floor.rooms) {
            for (Room r : row) {
                if (!r.adventurers.isEmpty()) {
                    return;
                }
            }
        }
        Room r = room.getRandomAdjacentRoom(false);
        room.creatures.remove(this);
        room = r;
        room.creatures.add(this);
    }

}
