import java.util.ArrayList;

public abstract class Character implements Subject {
    ArrayList<Observer> observers = new ArrayList<Observer>();

    public Room room;

    /*
    * Move characters around a room on a specific floor
    */

    public abstract void move();

    public String toString(){
        return "";
    }

    public int roll(){
        int roll1 = (int)(Math.random() * 6) + 1;
        int roll2 = (int)(Math.random() * 6) + 1;
        return roll1+roll2;
    }
    @Override
    public void registerObserver(Observer observer){
        observers.add(observer);
    }
    @Override
    public void unregisterObserver(Observer observer){
        observers.remove(observer);
    }
    @Override
    public void notifyRoomChange(Room newRoom){
        for(Observer observer: observers){
            observer.updateRoomChange(newRoom);
        }
    }

    public void notifyCombatStatus(Adventurer adventurer) {

    }

    public void notifyAdventurerExpertise(Adventurer adventurer) {

    }

    public void notifyAdventurerResonance(ElementType type) {

    }

    public void notifyAdventurerDiscord(ElementType type) {

    }

    public void notifyHealth(Adventurer adventurer) {

    }

    public void notifyCharacterRemove(Character character) {

    }


}
