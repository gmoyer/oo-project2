import Treasure.Sword;
import Treasure.Shield;
import Treasure.Potion;
import Treasure.Glasses;
import Treasure.Gem;
import Treasure.Elixir;

import Treasure.Treasure;

import java.util.ArrayList;

public class Dungeon {
    public Room startingRoom;
    public Floor[] floors = new Floor[ElementType.values().length];

    public ArrayList<Adventurer> adventurers = new ArrayList<Adventurer>();
    public ArrayList<Creature> creatures = new ArrayList<Creature>();

    // This is an example of encapsulation since we are making sure no one can see
    // our turn number and total treasures
    private int turn = 0;

    public Dungeon() {

        // Set up the floors
        startingRoom = new Room(null, 1, 1,ElementType.AIR, true);
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Floor(ElementType.values()[i]);

            // Connect the middle room to the starting room
            floors[i].rooms[1][1].addAdjacentRoom(startingRoom);
            startingRoom.addAdjacentRoom(floors[i].rooms[1][1]);

            switch(floors[i].elementType) {
                case FIRE:
                    creatures.add(new Fireborn(floors[i].rooms[0][0]));
                    creatures.add(new Fireborn(floors[i].rooms[0][2]));
                    creatures.add(new Fireborn(floors[i].rooms[2][0]));
                    creatures.add(new Fireborn(floors[i].rooms[2][2]));
                    break;
                case WATER:
                    for (int l = 0; l < 4; l++) {
                        creatures.add(new Aquarid(floors[i].getRandomRoom()));
                    }
                    break;
                case AIR:
                    for (int l = 0; l < 4; l++) {
                        creatures.add(new Zyphral(floors[i].getRandomRoom()));
                    }
                    break;
                case EARTH:
                    for (int l = 0; l < 4; l++) {
                        creatures.add(new Terravore(floors[i].getRandomRoom()));
                    }
                    break;
            }
        }

        // Add treasures to the floors
        for (int i = 0; i < 4; i++) {
            addTreasureToRandomRoom(new Sword());
        }
        for (int i = 0; i < 4; i++) {
            addTreasureToRandomRoom(new Shield());
        }
        for (int i = 0; i < 4; i++) {
            addTreasureToRandomRoom(new Potion());
        }
        for (int i = 0; i < 4; i++) {
            addTreasureToRandomRoom(new Glasses());
        }
        for (int i = 0; i < 4; i++) {
            addTreasureToRandomRoom(new Elixir());
        }
        for (int i = 0; i < 15; i++) {
            addTreasureToRandomRoom(new Gem());
        }

        // Set up the adventurers
        adventurers.add(new EmberKnight(startingRoom));
        adventurers.add(new ZypherRogue(startingRoom));
        adventurers.add(new MistWalker(startingRoom));
        adventurers.add(new TerraVoyager(startingRoom));

    }

    public void start() {
        boolean adventurersWon = false;
        boolean creaturesWon = false;
        while (!adventurersWon && !creaturesWon) {
            runTurn();
            System.out.println(this);

            // Check if the adventurers won

            // Check total value condition
            int totalValue = 0;
            for (Adventurer adventurer : adventurers) {
                totalValue += adventurer.treasureBag.getValue();
            }
            // Check treasure left condition
            boolean treasureLeft = false;
            for (Floor floor : floors) {
                for (Room[] row : floor.rooms) {
                    for (Room room : row) {
                        if (room.treasure != null) {
                            treasureLeft = true;
                            break;
                        }
                    }
                }
            }
            if (creatures.isEmpty() || totalValue >= 15000 || !treasureLeft) {
                adventurersWon = true;
            }

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

    public void runTurn() {
        turn++;

        // Run the adventurers
        for (Adventurer adventurer : adventurers) {
            adventurer.move();
        }

        // Run the creatures
        for (Creature creature : creatures) {
            creature.move();
        }

        // Resolve any conflicts
        for (Adventurer adventurer : adventurers) {
            if (adventurer.room.creatures.isEmpty()) {
                adventurer.searchTreasure();
            } else {
                for (Creature creature : adventurer.room.creatures) {
                    adventurer.combat(creature);
                }
            }
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
}
