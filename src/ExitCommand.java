public class ExitCommand implements Command {
    private final Dungeon dungeon;
    public ExitCommand(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    public void execute() {
        dungeon.userExit();
    }
    public String toString() {
        return "Exit the dungeon";
    }
}
