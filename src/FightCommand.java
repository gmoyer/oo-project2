public class FightCommand implements Command {
    private final Adventurer adventurer;
    public FightCommand(Adventurer adventurer) {
        this.adventurer = adventurer;
    }
    public void execute() {
        for (Creature creature : adventurer.room.creatures) {
            adventurer.combat(creature);
        }
    }

    @Override
    public boolean canExecute() {
        return !adventurer.room.creatures.isEmpty();
    }

    public String toString() {
        return "Fight creatures in room";
    }
}
