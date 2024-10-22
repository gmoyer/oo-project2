public class MoveLeftCommand implements Command {
    private final Adventurer adventurer;
    public MoveLeftCommand(Adventurer adventurer) {
        this.adventurer = adventurer;
    }
    private Room getRoom() {
        if (adventurer.room.startingRoom) {
            return adventurer.room.adjacentRooms.get(2);
        }
        int row = adventurer.room.row;
        int col = adventurer.room.col - 1;
        return adventurer.room.getAdjacentRoom(row, col);
    }
    public void execute() {
        adventurer.userMove(getRoom());
    }
    public boolean canExecute() {
        return getRoom() != null;
    }

    public String toString() {
        if (adventurer.room.startingRoom) {
            return "Move to the earth floor";
        } else {
            return "Move left";
        }
    }
}