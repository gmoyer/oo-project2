public class MoveStarterCommand implements Command {
    private final Adventurer adventurer;

    public MoveStarterCommand(Adventurer adventurer) {
        this.adventurer = adventurer;
    }
    private Room getRoom() {
        for (Room room : adventurer.room.adjacentRooms) {
            if (room.startingRoom) {
                return room;
            }
        }
        return null;
    }
    public void execute() {
        adventurer.userMove(getRoom());
    }
    public boolean canExecute() {
        return getRoom() != null;
    }

    public String toString() {
        return "Move to starting room";
    }
}
