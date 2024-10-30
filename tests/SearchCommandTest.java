import Treasure.Potion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchCommandTest {
    @Test
    void canExecute_noTreasure_false() {
        // Given
        // No treasure in the room
        Room r1 = new Room(new Floor(ElementType.FIRE),0,0,ElementType.FIRE,false);
        Adventurer a1 = new EmberKnight(r1);
        SearchCommand sc1 = new SearchCommand(a1);

        assertFalse(sc1.canExecute());
    }

    @Test
    void canExecute_yesTreasure_true() {
        // Given
        // Treasure in the room
        Room r1 = new Room(new Floor(ElementType.FIRE),0,0,ElementType.FIRE,false);
        Adventurer a1 = new EmberKnight(r1);
        r1.treasure = new Potion();
        SearchCommand sc1 = new SearchCommand(a1);

        assertTrue(sc1.canExecute());
    }

//    @Test
//    void execute_yesTreasure_noTreasureInRoom() {
//        // Given
//        // Treasure in the room
//        Room r1 = new Room(new Floor(ElementType.FIRE),0,0,ElementType.FIRE,false);
//        Adventurer a1 = new EmberKnight(r1);
//        a1 = mock(EmberKnight.class);
//        r1.treasure = new Potion();
//        SearchCommand sc1 = new SearchCommand(a1);
//
//        // When
//        when(a1.roll()).thenReturn(11);
//        sc1.execute();
//
//        // Then
//        assertNull(r1.treasure);
//        assertNotNull(a1.treasureBag);
//    }
}
