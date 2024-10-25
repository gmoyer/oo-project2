public class MoveDownCommand implements Command {
    private final Adventurer adventurer;
    public MoveDownCommand(Adventurer adventurer) {
        this.adventurer = adventurer;
    }
    private Room getRoom() {
        if (adventurer.room.startingRoom) {
            return adventurer.room.adjacentRooms.get(1);
        }
        int row = adventurer.room.row + 1;
        int col = adventurer.room.col;
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
            return "Move to the water floor";
        } else {
            return "Move down";
        }
    }
}
