public class MoveCommand implements Command {
    private final Adventurer adventurer;
    public MoveCommand(Adventurer adventurer) {
        this.adventurer = adventurer;
    }
    public void execute() {
        for (Creature creature : adventurer.room.creatures) {
            adventurer.health -= 1;
        }
        adventurer.move();
    }
    public String toString() {
        return "Move to another room";
    }
}
