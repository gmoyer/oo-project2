public class Terravore extends Creature{

    // earth floor
    // don't move and stay at the position they spawn

    public Terravore(Room room) {
        this.room = room;
        room.creatures.add(this);
    }

    @Override
    public void move() {
        //does nothing
    }



    public String toString() {
        return "T";
    }
}
