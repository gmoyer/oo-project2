import Treasure.Treasure;

import java.util.ArrayList;

//This is an example of cohesion because this class only deals with the rooms in the floors and nothing else

public class Room {
    public int row;
    public int col;
    public boolean startingRoom;

    public Floor floor;
    public ElementType elementType;
    public final ArrayList<Room> adjacentRooms = new ArrayList<Room>();
    public ArrayList<Adventurer> adventurers = new ArrayList<Adventurer>();
    public ArrayList<Creature> creatures = new ArrayList<Creature>();

    public Treasure treasure;

    public Room(Floor floor, int row, int col, ElementType elementType, boolean startingRoom) {
        this.floor = floor;
        this.elementType = elementType;
        this.row = row;
        this.col = col;
        this.startingRoom = startingRoom;
    }

    public void addAdjacentRoom(Room room) {
        adjacentRooms.add(room);
    }

    public Room getRandomAdjacentRoom(boolean includeStartingRoom) {
        int randomIndex = (int)(Math.random() * adjacentRooms.size());
        if (!includeStartingRoom && adjacentRooms.get(randomIndex).startingRoom) {
            return getRandomAdjacentRoom(false);
        } else {
            return adjacentRooms.get(randomIndex);
        }
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
