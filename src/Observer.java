public interface Observer {
    public void updateRoomChange(Room newRoom);
    public void updateCombatStatus(Adventurer adventurer);
    public void updateAdventurerExpertise(Adventurer adventurer);
    public void updateAdventurerResonance(ElementType type);
    public void updateAdventurerDiscord(ElementType type);
    public void updateHealth(Adventurer adventurer);
    public void updateCharacterRemove(Character character);
    //public void updateTreasure(Treasure treasure);
}
