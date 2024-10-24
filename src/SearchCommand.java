public class SearchCommand implements Command {
    private final Adventurer adventurer;
    public SearchCommand(Adventurer adventurer) {
        this.adventurer = adventurer;
    }
    public void execute() {
        adventurer.searchTreasure();
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    public String toString() {
        return "Search for Treasure";
    }
}
