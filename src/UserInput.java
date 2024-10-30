import java.util.Scanner;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);
    static AbstractAdventurerFactory factory = new AdventurerFactory();
    public static Adventurer chooseAdventurer(Room startingRoom) {
        System.out.println("Choose an adventurer (1-4):");
        System.out.println("1. EmberKnight");
        System.out.println("2. MistWalker");
        System.out.println("3. TerraVoyager");
        System.out.println("4. ZypherRogue");

        int choice = scanner.nextInt();
        return factory.createAdventurer(choice,startingRoom);
    }

    public static void userTurn(UserRemote remote) {
        remote.printOptions();
        System.out.println("Choose an option:");
        int choice = scanner.nextInt();

        boolean success = remote.buttonWasPressed(choice);
        if (!success) {
            System.out.println("Invalid choice. Please try again.");
            userTurn(remote);
        }
    }
}
