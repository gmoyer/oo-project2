import java.util.ArrayList;

public class Dungeon {
    public Room startingRoom;
    public Floor[] floors = new Floor[ElementType.values().length];

    public ArrayList<Adventurer> adventurers = new ArrayList<Adventurer>();
    public ArrayList<Creature> creatures = new ArrayList<Creature>();

    private int turn = 0;

    public Dungeon() {

        // Set up the floors
        startingRoom = new Room(1, 1,ElementType.AIR);
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Floor(ElementType.values()[i]);

            // Connect the middle room to the starting room
            floors[i].rooms[1][1].addAdjacentRoom(startingRoom);
            startingRoom.addAdjacentRoom(floors[i].rooms[1][1]);
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("----------Turn-15----------\n");
        out.append("Starting Room:\n");
        out.append(RoomStringBuilder.borderString()).append(RoomStringBuilder.borderTailString());
        out.append(RoomStringBuilder.mainString(startingRoom)).append(RoomStringBuilder.mainTailString());
        out.append(RoomStringBuilder.borderString()).append(RoomStringBuilder.borderTailString());

        for (Floor floor : floors) {
            out.append(floor.toString());
        }

        return out.toString();
    }
}
