import Treasure.Sword;
import Treasure.Shield;
import Treasure.Potion;
import Treasure.Glasses;
import Treasure.Gem;
import Treasure.Elixir;
import Treasure.Treasure;
import java.util.ArrayList;

public class Dungeon implements Subject {
    public Room startingRoom;
    public Floor[] floors = new Floor[ElementType.values().length];

    public ArrayList<Adventurer> adventurers = new ArrayList<Adventurer>();
    public ArrayList<Creature> creatures = new ArrayList<Creature>();
    public ArrayList<Observer> observers;

    // This is an example of encapsulation since we are making sure no one can see
    // our turn number and total treasures
    private int turn = 0;
    private int totalTreasures = 0;
    public Tracker tracker;
    public Logger logger;
    final int treasureToWin = 60000;

    public UserRemote remote;
    public boolean adventurersWon = false;
    public boolean creaturesWon = false;

    public Dungeon() {
        observers = new ArrayList<Observer>();


        AbstractCreatureFactory factory = new CreatureFactory();


        // Set up the floors
        startingRoom = new Room(null, 1, 1,ElementType.AIR, true);
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Floor(ElementType.values()[i]);

            // Connect the middle room to the starting room
            floors[i].rooms[1][1].addAdjacentRoom(startingRoom);
            startingRoom.addAdjacentRoom(floors[i].rooms[1][1]);

            creatures = factory.createCreature(floors[i].elementType, floors[i]);

        }


        // Add treasures to the floors
        for (int i = 0; i < 4; i++) {
            addTreasureToRandomRoom(new Sword());
            addTreasureToRandomRoom(new Shield());
            addTreasureToRandomRoom(new Potion());
            addTreasureToRandomRoom(new Glasses());
            addTreasureToRandomRoom(new Elixir());
        }
        for (int i = 0; i < 15; i++) {
            addTreasureToRandomRoom(new Gem());
        }

        // Set up the adventurers
        Adventurer adventurer = UserInput.chooseAdventurer(startingRoom);
        adventurers.add(adventurer);

        remote = new UserRemote();
        remote.addCommand(new MoveCommand(adventurer));
        remote.addCommand(new SearchCommand(adventurer));
        remote.addCommand(new FightCommand(adventurer));
        remote.addCommand(new ExitCommand(this));

        tracker = Tracker.getInstance();
        Tracker.initialize(turn,totalTreasures,adventurers.size(),creatures.size(),adventurers,creatures);
        logger = Logger.getInstance(adventurers, creatures, totalTreasures, adventurers.size(), creatures.size(), turn);
        observers.add(tracker); //This is where observers get regisitered
        observers.add(logger);

    }

    public void start() {
        while (!adventurersWon && !creaturesWon) {
            runTurn();
            System.out.println(this);

            updateTotalTreasures();

            // Check if the creatures won
            if (adventurers.isEmpty()) {
                creaturesWon = true;
            }
        }

        if (adventurersWon) {
            System.out.println("The adventurers won!");
        } else {
            System.out.println("The creatures won!");
        }

    }

    public void updateTotalTreasures() {
        int totalValue = 0;
        for (Adventurer adventurer : adventurers) {
            totalValue += adventurer.treasureBag.getValue();
        }
        totalTreasures = totalValue;
    }

    public void userExit() {
        updateTotalTreasures();
        if (creatures.isEmpty() || totalTreasures >= treasureToWin) {
            adventurersWon = true;
        } else {
            creaturesWon = true;
        }
    }

    public void runTurn() {
        turn++;

        // Run the adventurer
        UserInput.userTurn(remote);

        // Run the creatures
        for (Creature creature : creatures) {
            creature.move();
        }

        // See if anyone died
        for (int i = adventurers.size() - 1; i >= 0; i--) {
            if (adventurers.get(i).isDead()) {
                adventurers.get(i).room.adventurers.remove(adventurers.get(i));
                adventurers.remove(i);
            }
        }

        for (int i = creatures.size() - 1; i >= 0; i--) {
            if (creatures.get(i).dead) {
                creatures.get(i).room.creatures.remove(creatures.get(i));
                creatures.remove(i);
            }
        }
        notifyObserver();
        tracker.display();
        logger.logWriter();
    }

    public void addTreasureToRandomRoom(Treasure treasure) {
        Floor floor = floors[(int)(Math.random() * floors.length)];
        Room room = floor.getRandomRoom();
        if (room.treasure == null) {
            room.treasure = treasure;
        } else {
            addTreasureToRandomRoom(treasure);
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("----------Turn ").append(turn).append("----------\n");
        out.append("Starting Room:\n");
        out.append(RoomStringBuilder.borderString()).append(RoomStringBuilder.borderTailString());
        out.append(RoomStringBuilder.mainString(startingRoom)).append(RoomStringBuilder.mainTailString());
        out.append(RoomStringBuilder.borderString()).append(RoomStringBuilder.borderTailString());

        for (Floor floor : floors) {
            out.append(floor.toString());
        }

        // Print the adventurers
        for (Adventurer adventurer : adventurers) {
            out.append("--- ").append(adventurer.toString()).append(" ---\n")
                    .append("Treasure Bag: ").append(adventurer.treasureBag).append("\n")
                    .append("Treasure Value: ").append(adventurer.treasureBag.getValue()).append("\n")
                    .append("Combat Expertise: ").append(adventurer.combatExpertise)
                    .append(", Search Expertise: ").append(adventurer.searchExpertise).append("\n")
                    .append("Health remaining: ").append(adventurer.health + adventurer.treasureBag.healthBonus()).append("\n");
        }
        out.append("\n");

        // Print the count of each creature
        int fireborn = 0;
        int aquarid = 0;
        int zyphral = 0;
        int terravore = 0;
        for (Creature creature : creatures) {
            if (creature instanceof Fireborn) {
                fireborn++;
            } else if (creature instanceof Aquarid) {
                aquarid++;
            } else if (creature instanceof Zyphral) {
                zyphral++;
            } else if (creature instanceof Terravore) {
                terravore++;
            }
        }
        out.append("Fireborn - ").append(fireborn).append(" remaining\n");
        out.append("Aquarid - ").append(aquarid).append(" remaining\n");
        out.append("Zyphral - ").append(zyphral).append(" remaining\n");
        out.append("Terravore - ").append(terravore).append(" remaining\n");



        return out.toString();
    }
    @Override
    public void notifyObserver() {
        for(Observer o: observers){
            o.update(turn,totalTreasures);
        }
    }
}
