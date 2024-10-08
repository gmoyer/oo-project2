import javax.swing.text.Element;

public class Floor {
    public Room[][] rooms = new Room[3][3];
    public final ElementType elementType;
    public Dungeon dungeon;

    public Floor(ElementType elementType) {
        this.elementType = elementType;
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {
                rooms[row][col] = new Room(this, row, col, elementType, false);
            }
        }

        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[row].length; col++) {
                if (row > 0) {
                    rooms[row][col].addAdjacentRoom(rooms[row - 1][col]);
                }
                if (row < rooms.length - 1) {
                    rooms[row][col].addAdjacentRoom(rooms[row + 1][col]);
                }
                if (col > 0) {
                    rooms[row][col].addAdjacentRoom(rooms[row][col - 1]);
                }
                if (col < rooms[row].length - 1) {
                    rooms[row][col].addAdjacentRoom(rooms[row][col + 1]);
                }
            }
        }
    }

    public Room getRandomRoom() {
        int row = (int)(Math.random() * rooms.length);
        int col = (int)(Math.random() * rooms[row].length);
        return rooms[row][col];
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(elementType).append(" Floor:\n");
        for (Room[] row : rooms) {
            for (Room room : row) {
                out.append(RoomStringBuilder.borderString());
            }
            out.append(RoomStringBuilder.borderTailString());
            for (Room room : row) {
                out.append(RoomStringBuilder.mainString(room));
            }
            out.append(RoomStringBuilder.mainTailString());
        }
        for (Room room : rooms[0]) {
            out.append(RoomStringBuilder.borderString());
        }
        out.append(RoomStringBuilder.borderTailString());

        return out.toString();
    }
}
