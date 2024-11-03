import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Tracker_LoggerTest {

    @Test
    public void testTrackerEagerSingleton(){
        Tracker tracker_instance1 = Tracker.getInstance();
        Tracker tracker_instance2 = Tracker.getInstance();
        assertSame(tracker_instance1,tracker_instance2);
    }
    @Test
    public void testTrackerInitialization(){
        Tracker tracker_instance = Tracker.getInstance();
        Tracker.initialize(4,300,3,8,new ArrayList<>(),new ArrayList<>());
        assertEquals(4,tracker_instance.turn);
        assertEquals(300,tracker_instance.totalTreasureValue);
        assertEquals(3,tracker_instance.adventurerActive);
        assertEquals(8,tracker_instance.creaturesActive);
        assertNotNull(tracker_instance.adventurerList);
        assertNotNull(tracker_instance.creatureList);
    }
    @Test
    public void testTrackerUpdate(){
        Tracker tracker_instance = Tracker.getInstance();
        tracker_instance.update(2,300);
        assertEquals(2,tracker_instance.turn);
        assertEquals(300, tracker_instance.totalTreasureValue);
    }
    @Test
    public void testLoggerLazySingleton(){
        Logger logger_instance1 = Logger.getInstance(new ArrayList<>(),new ArrayList<>(),300,2,8,3);
        Logger logger_instance2 = Logger.getInstance(new ArrayList<>(),new ArrayList<>(),300,2,8,3);
        assertSame(logger_instance1,logger_instance2);
    }
    @Test
    public void testLoggerLazySingletonInitialization() {
        Logger logger_instance = Logger.getInstance(new ArrayList<>(), new ArrayList<>(), 300, 2, 8, 3);
        assertNotNull(logger_instance.adventurerList);
        assertNotNull(logger_instance.creatureList);
        assertEquals(300, logger_instance.totalTreasureValue);
        assertEquals(2, logger_instance.adventurerActive);
        assertEquals(8, logger_instance.creaturesActive);
        assertEquals(3, logger_instance.turn);

    }



}
