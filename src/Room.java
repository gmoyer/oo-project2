import java.util.ArrayList;

public class Room {
    public int row;
    public int col;

    public ElementType elementType;
    private final ArrayList<Room> adjacentRooms = new ArrayList<Room>();
    public ArrayList<Adventurer> adventurers = new ArrayList<Adventurer>();
    public ArrayList<Creature> creatures = new ArrayList<Creature>();

    public Room(int row, int col, ElementType elementType) {
        this.elementType = elementType;
        this.row = row;
        this.col = col;

    }

    public void addAdjacentRoom(Room room) {
        adjacentRooms.add(room);
    }

    public Room getRandomAdjacentRoom() {
        int randomIndex = (int)(Math.random() * adjacentRooms.size());
        return adjacentRooms.get(randomIndex);
    }

    public Room getAdjacentRoom(int row, int col) {
        for (Room room : adjacentRooms) {
            if (room.row == row && room.col == col) {
                return room;
            }
        }
        return null;
    }
}
