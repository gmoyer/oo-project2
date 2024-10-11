import Treasure.EmptyTreasureBag;

public class EmberKnight extends Adventurer {
    public String toString() {
        return "EK";
    }


    public EmberKnight(Room room){
        this.room = room;
        room.adventurers.add(this);
        dodgeChance = 0.2;
        resonance = ElementType.FIRE;
        discord = ElementType.WATER;
        health = 5;
        treasureBag = new EmptyTreasureBag();
    }

    @Override
    public void move() {
        Room r = room.getRandomAdjacentRoom(true);
        room.adventurers.remove(this);
        room = r;
        room.adventurers.add(this);
    }

    @Override
    public void searchTreasure() {
        if(roll() >= 11 + treasureBag.searchBonus()){
            takeTreasure();
        }
    }

    @Override
    public void combat(Creature creature) {
        int playerRoll = roll() + treasureBag.combatBonus();
        int creatureRoll = roll() - treasureBag.armorBonus() + treasureBag.creatureBonus();
        if(room.elementType==resonance){
            playerRoll += 2;
        }
        else if(room.elementType == discord){
            playerRoll -= 2;
        }
        if (playerRoll > creatureRoll){
            creature.dead = true;
        }
        else if (playerRoll < creatureRoll){
            if (dodgeFailure(dodgeChance)){
                health -= 2;
            }
        }
    }
}
