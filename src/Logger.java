import Treasure.Treasure;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Logger implements Observer{
    //update string paramter
    //format string ex adventure enters room
    /*
    Adventurer/Creature enters the room X
    Adventurer/Creature win/loses combat
    Adventurer gains expertise
    Adventurer gains elemental Discord or Resonance
    Adventurer loses Health
    Adventurer/Creature is defeated/removed
    Adventurer finds treasure (include type of treasure)
    */
    List<Adventurer> adventurerList;
    List<Creature> creatureList;
    public int totalTreasureValue;
    public int adventurerActive;
    public int creaturesActive;
    public int turn;
    String file = "Logger-n.txt";
    public Logger(List<Adventurer> adventurerList, List<Creature> creatureList, int totalTreasureValue, int adventurerActive, int creaturesActive, int turn){
        this.adventurerList = adventurerList;
        this.creatureList = creatureList;
        this.totalTreasureValue = totalTreasureValue;
        this.adventurerActive = adventurerActive;
        this.creaturesActive = creaturesActive;
        this.turn = turn;
        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
            fileWriter.write("Arcane RPG Log:\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }
    public static void appendToLog(String filename, String str){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename,true));
            out.write(str);
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String advRoom(){
        String roomStr = "";
        String elementStr = "";
        String result = "";
        for (Adventurer a: adventurerList) {
            roomStr = String.format("%s is in %s ",a ,a.room.toString());
            if(a.room.elementType.equals(a.resonance)){
                elementStr = "and has room resonance\n";
                result += roomStr+elementStr;
            }
            else if (a.room.elementType.equals(a.discord)){
                elementStr = "and has room discord\n";
                result += roomStr+elementStr;
            }
            else{
                elementStr = "and has no resonance or discord with the room\n";
                result += roomStr+elementStr;
            }
        }
        return result;
    }
    public String creRoom(){
        String creRoom = "";
        for (Creature c: creatureList) {
            creRoom += String.format("%s is in %s\n",c ,c.room.toString());
        }
        return creRoom;
    }
    public String checkCombat(){
        String againstWho = "";
        String comConclusion = "";
        String charRemove = "";
        String result = "";
        for (Adventurer a: adventurerList){
            for(Creature c : a.room.creatures){
                againstWho = String.format("Adventurer %s %s is fighting Creature %s %s",a,a.room.toString(),c,c.room.toString());
                if (a.health+a.treasureBag.healthBonus() < a.maxHealth) {
                    comConclusion = String.format(", adventurer %s lost combat, new health is %s.\n",a,a.health);
                    result += againstWho+comConclusion;
                }
                else{
                    comConclusion = String.format(", adventurer %s won combat, health is still %s.\n",a, a.health);
                    charRemove = String.format("Creature %s was removed\n",c);
                    result += againstWho+comConclusion+charRemove;
                }
            }
        }
        return result;
    }
    public String checkExpertise(){
        String result = "";
        for (Adventurer a: adventurerList){
            result += String.format("Adventurer %s combat expertise is %s and search expertise is %s\n",a,a.combatExpertise,a.searchExpertise);
        }
        return result;
    }
    public String checkSearch(){
        String result = "";
        for(Adventurer a: adventurerList){
            result += String.format("Adventurer %s has %sin the treasure bag\n", a, a.treasureBag);
        }
        return result;
    }
    public String advRemove(){
        String result = "";
        ArrayList<String> oldList = new ArrayList<>();
        oldList.add("EK");
        oldList.add("ZR");
        oldList.add("MW");
        oldList.add("TV");
        for(String o: oldList){
            if(adventurerList.toString().contains(o)){

            }else{
                result+= String.format("Adventurer %s died, so was removed\n",o);
            }

        }
        return result;
    }
    public String specificTreasure(){
        String result = "";
        for(Adventurer a: adventurerList){
            String[] bag = a.treasureBag.toString().split(" ");
            if(bag.length != 0){
                result += String.format("Adventurer %s found %s\n",a,bag[0]);
            }
        }
        return result;
    }


    public void logWriter(){
        appendToLog(file, "------------------------------\n");
        appendToLog(file,"Turn: " + turn + "\n");
        appendToLog(file,"\n");

        appendToLog(file,"Where the adventures are:\n");
        appendToLog(file, advRoom());
        appendToLog(file,"\n");

        appendToLog(file,"Where the creatures are:\n");
        appendToLog(file, creRoom());
        appendToLog(file,"\n");

        appendToLog(file,"Combat Expertise and Search Expertise:\n");
        appendToLog(file, checkExpertise());
        appendToLog(file,"\n");

        appendToLog(file,"Combat:\n");
        appendToLog(file, checkCombat());
        appendToLog(file,"\n");

        appendToLog(file,"Adventurer Removed:\n");
        appendToLog(file, advRemove());
        appendToLog(file,"\n");

        appendToLog(file, "Adventurer Found Treasure:\n");
        appendToLog(file, specificTreasure());
        appendToLog(file,"\n");

        appendToLog(file, "Adventurer Treasure Bag:\n");
        appendToLog(file, checkSearch());
        appendToLog(file,"\n");

    }



    @Override
    public void update(int turn, int totalTreasureValue) {
        this.turn = turn;
    }
}
