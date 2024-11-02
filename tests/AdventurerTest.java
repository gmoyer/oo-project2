import Treasure.Potion;
import Treasure.Treasure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventurerTest {

    @Test
    void isDead_noBonusNoHealth_true() {
        // Given
        // No health bonus, health <= 0
        Adventurer a1 = new EmberKnight(new Room(new Floor(ElementType.FIRE),0,0,ElementType.FIRE,false));
        a1.health = 0;

        assertTrue(a1.isDead());
    }

    @Test
    void isDead_yesBonusNoHealth_false() {
        // Given
        // Health bonus, health <= 0
        Room r1 = new Room(new Floor(ElementType.FIRE),0,0,ElementType.FIRE,false);
        Adventurer a1 = new EmberKnight(r1);
        a1.health = 0;
        r1.treasure = new Potion();
        a1.takeTreasure();

        assertFalse(a1.isDead());
    }

    @Test
    void isEmberKnight_Adventurer_true() {
        int choice = 1;
        Room startingRoom = new Room(new Floor(ElementType.FIRE),0,0,ElementType.FIRE,false);
        AbstractAdventurerFactory factory = new AdventurerFactory();
        Adventurer ek = factory.createAdventurer(choice,startingRoom);

        assertTrue(ek instanceof EmberKnight);

    }

    @Test
    void is_MistWalker_Adventurer_true() {
        int choice = 2;
        Room startingRoom = new Room(new Floor(ElementType.FIRE),0,0,ElementType.FIRE,false);
        AbstractAdventurerFactory factory = new AdventurerFactory();
        Adventurer mw = factory.createAdventurer(choice,startingRoom);

        assertTrue(mw instanceof  MistWalker);

    }

    @Test
    void is_TerraVoyager_Adventurer_true() {
        int choice = 3;
        Room startingRoom = new Room(new Floor(ElementType.FIRE),0,0,ElementType.FIRE,false);
        AbstractAdventurerFactory factory = new AdventurerFactory();
        Adventurer tv = factory.createAdventurer(choice,startingRoom);

        assertTrue(tv instanceof TerraVoyager);

    }

    @Test
    void is_ZypherRogue_Adventurer_true() {
        int choice = 4;
        Room startingRoom = new Room(new Floor(ElementType.FIRE),0,0,ElementType.FIRE,false);
        AbstractAdventurerFactory factory = new AdventurerFactory();
        Adventurer zr = factory.createAdventurer(choice,startingRoom);

        assertTrue(zr instanceof ZypherRogue);

    }
}