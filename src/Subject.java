public interface Subject {
    public void registerObserver(Observer observer);

    public void unregisterObserver(Observer observer);

    public void notifyRoomChange(Room newRoom);

    public void notifyCombatStatus(Adventurer adventurer);

    public void notifyAdventurerExpertise(Adventurer adventurer);

    public void notifyAdventurerResonance(ElementType type);

    public void notifyAdventurerDiscord(ElementType type);

    public void notifyHealth(Adventurer adventurer);

    public void notifyCharacterRemove(Character character);

    //public void notifyTreasure(Treasure treasure);
}
