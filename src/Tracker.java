import java.util.ArrayList;
import java.util.List;

public class Tracker implements Observer{

    //public Map<String, Integer> map;

    //public void toString();
    List<Adventurer> adventurerList;
    List<Creature> creatureList;
    public int totalTreasureValue;
    public int adventurerActive;
    public int creaturesActive;
    public Tracker(int totalTreasureValue, int adventurerActive, int creaturesActive, List<Adventurer> adventurerList, List<Creature> creatureList){
        this.totalTreasureValue = totalTreasureValue;
        this.adventurerActive = adventurerActive;
        this.creaturesActive = creaturesActive;
        this.adventurerList = adventurerList;
        this.creatureList = creatureList;
    }

    public void display() {
        System.out.println("Adventures \t\t Room\t\t Health\t\t Treasure\t\t Treasure Value");
        for (Adventurer a: adventurerList){
            System.out.println(a+"\t\t" +a.room+"\t\t"+a.health+"\t\t"+ "Treasure here");
        }
    }


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
