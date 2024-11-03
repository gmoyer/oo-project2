import java.util.ArrayList;
import java.util.List;

public class Tracker implements Observer {
    // Eagerly create the singleton instance with default values
    private static final Tracker tracker_instance = new Tracker(1, 0, 0, 0, new ArrayList<>(), new ArrayList<>());

    public List<Adventurer> adventurerList;
    public List<Creature> creatureList;
    public int totalTreasureValue;
    public int adventurerActive;
    public int creaturesActive;
    public int turn;

    private Tracker(int turn, int totalTreasureValue, int adventurerActive, int creaturesActive, List<Adventurer> adventurerList, List<Creature> creatureList) {
        this.turn = turn;
        this.totalTreasureValue = totalTreasureValue;
        this.adventurerActive = adventurerActive;
        this.creaturesActive = creaturesActive;
        this.adventurerList = adventurerList;
        this.creatureList = creatureList;
    }

    // Public method to provide access to the singleton instance
    public static Tracker getInstance() {
        return tracker_instance;
    }

    public static Tracker initialize(int turn, int totalTreasureValue, int adventurerActive, int creaturesActive, List<Adventurer> adventurerList, List<Creature> creatureList) {
        tracker_instance.turn = turn;
        tracker_instance.totalTreasureValue = totalTreasureValue;
        tracker_instance.adventurerActive = adventurerActive;
        tracker_instance.creaturesActive = creaturesActive;
        tracker_instance.adventurerList = adventurerList != null ? adventurerList : new ArrayList<>();
        tracker_instance.creatureList = creatureList != null ? creatureList : new ArrayList<>();
        return null;
    }

    public void display() {
        String format = "%-20s%-20s%-20s%-20s%-40s";
        System.out.println();
        System.out.println("Tracker: " + turn);
        System.out.println();
        System.out.println("Total Treasure: " + totalTreasureValue);
        System.out.println();
        System.out.println("Active Adventurers: " + adventurerActive);
        System.out.format(format, "Adventures", "Room", "Health", "Treasure", "Treasure Value");
        System.out.println();
        for (Adventurer a : adventurerList) {
            System.out.format(format, a, a.room.toString(), a.health, a.treasureBag, a.treasureBag.getValue());
            System.out.println();
        }
        System.out.println();
        System.out.println("Elemental Resonance: ");
        for (Adventurer a : adventurerList) {
            if (a.room.elementType.equals(a.resonance)) {
                System.out.format("%-20s\n", a);
            }
        }
        System.out.println();

        System.out.println("Elemental Discord: ");
        for (Adventurer a : adventurerList) {
            if (a.room.elementType.equals(a.discord)) {
                System.out.format("%-20s\n", a);
            }
        }
        System.out.println();
        System.out.format("%-20s%-20s", "Creature", "Room");
        System.out.println();
        for (Creature c : creatureList) {
            System.out.format("%-20s%-20s", c, c.room.toString());
            System.out.println();
        }
    }

    @Override
    public void update(int turn, int totalTreasureValue) {
        this.turn = turn;
        this.totalTreasureValue = totalTreasureValue;
        adventurerActive = this.adventurerList != null ? this.adventurerList.size() : 0;
        creaturesActive = this.creatureList != null ? this.creatureList.size() : 0;
    }
}
