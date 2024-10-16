import java.util.Map;

public class Logger implements Observer{

    //Filewriter filewriter;
    public Map<String,Integer> map;

    /*
    public void printFile(Filewriter filewriter) {

    }

     */

    @Override
    public void updateRoomChange(Room newRoom) {

    }

    @Override
    public void updateCombatStatus(Adventurer adventurer) {

    }

    @Override
    public void updateAdventurerExpertise(Adventurer adventurer) {

    }

    @Override
    public void updateAdventurerResonance(ElementType type) {

    }

    @Override
    public void updateAdventurerDiscord(ElementType type) {

    }

    @Override
    public void updateHealth(Adventurer adventurer) {

    }

    @Override
    public void updateCharacterRemove(Character character) {

    }
    /*
    @Override
    public void updateTreasure(Treasure treasure) {

    }

     */
}
