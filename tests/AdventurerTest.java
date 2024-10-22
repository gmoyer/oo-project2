import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdventurerTest {

    @Test
    void isDead_noBonusNoHealth_true() {
        // Given
        // No health bonus, health <= 0
        Adventurer a1 = new EmberKnight(new Room(new Floor(ElementType.FIRE),0,0,ElementType.FIRE,false));
        a1.health = 0;


        // When
        // is dead is called
        assertTrue(a1.isDead());

        // Then
        // Expect isDead() == true
    }
}