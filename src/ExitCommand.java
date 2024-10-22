public class ExitCommand implements Command {
    private final Dungeon dungeon;
    public ExitCommand(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    public void execute() {
        dungeon.userExit();
    }

    @Override
    public boolean canExecute() {
        return dungeon.adventurers.getFirst().room == dungeon.startingRoom;
    }

    public String toString() {
        return "Exit the dungeon";
    }
}
