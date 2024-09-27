public class Zyphral extends Creature{
    // This class is an example of inheritance. It inherits Creature since it is a specific type of creature

    public String toString() {
        return "Z";
    }


    public Zyphral(Room room){
        this.room = room;
        //This is an example of identity. Adding a creature to the list of creatures in the room
        room.creatures.add(this);
    }

    // This is an example of polymorphism since we are overriding the move function from the class Character
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
