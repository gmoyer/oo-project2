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
}