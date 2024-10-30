import java.util.ArrayList;

public class CreatureFactory implements AbstractCreatureFactory {

    ArrayList<Creature> creatures = new ArrayList<>();
    @Override
    public ArrayList<Creature> createCreature(ElementType type, Floor floor) {

        switch (type) {
            case FIRE:
                creatures.add(new Fireborn(floor.rooms[0][0]));
                creatures.add(new Fireborn(floor.rooms[0][2]));
                creatures.add(new Fireborn(floor.rooms[2][0]));
                creatures.add(new Fireborn(floor.rooms[2][2]));
                break;
            case WATER:
                for (int l = 0; l < 4; l++) {
                    creatures.add(new Aquarid(floor.getRandomRoom()));
                }
                break;
            case AIR:
                for (int l = 0; l < 4; l++) {
                    creatures.add(new Zyphral(floor.getRandomRoom()));
                }
                break;
            case EARTH:
                for (int l = 0; l < 4; l++) {
                    creatures.add(new Terravore(floor.getRandomRoom()));
                }
                break;
        }

        return creatures;

    }
}
