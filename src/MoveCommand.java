public class MoveCommand implements Command {
    private final Adventurer adventurer;
    private UserRemote remote;
    public MoveCommand(Adventurer adventurer) {
        this.adventurer = adventurer;

        remote = new UserRemote();
        remote.addCommand(new MoveUpCommand(adventurer));
        remote.addCommand(new MoveDownCommand(adventurer));
        remote.addCommand(new MoveLeftCommand(adventurer));
        remote.addCommand(new MoveRightCommand(adventurer));
        remote.addCommand(new MoveStarterCommand(adventurer));
    }
    public void execute() {
        for (Creature creature : adventurer.room.creatures) {
            adventurer.health -= 1;
        }
        UserInput.userTurn(remote);
    }

    @Override
    public boolean canExecute() {
        return true;
    }

    public String toString() {
        return "Move to another room";
    }
}
