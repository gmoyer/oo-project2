import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class CreatureClass {
    @Test
    public void testCreatureCreation() {
        AbstractCreatureFactory factory = new CreatureFactory();
        Floor[] floors = new Floor[ElementType.values().length];
        Room startingRoom = new Room(null, 1, 1,ElementType.AIR, true);
        ArrayList<Creature> creatures = new ArrayList<Creature>();
        for (int i = 0; i < floors.length; i++) {
            floors[i] = new Floor(ElementType.values()[i]);

            // Connect the middle room to the starting room
            floors[i].rooms[1][1].addAdjacentRoom(startingRoom);
            startingRoom.addAdjacentRoom(floors[i].rooms[1][1]);

            creatures = factory.createCreature(floors[i].elementType, floors[i]);

        }
        assertTrue(creatures.size() == 16);
    }
}
