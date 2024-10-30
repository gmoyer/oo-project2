public class AdventurerFactory implements AbstractAdventurerFactory {
    @Override
    public Adventurer createAdventurer(int choice, Room startingRoom) {

        return switch (choice) {
            case 1 -> new EmberKnight(startingRoom);
            case 2 -> new MistWalker(startingRoom);
            case 3 -> new TerraVoyager(startingRoom);
            case 4 -> new ZypherRogue(startingRoom);
            default -> {
                System.out.println("Invalid choice. Please choose a number between 1 and 4.");
                yield UserInput.chooseAdventurer(startingRoom);
            }
        };

    }
}
