import Treasure.EmptyTreasureBag;

public class TerraVoyager extends Adventurer{
    public String toString() {
        return "TV";
    }

    public TerraVoyager(Room room){
        this.room = room;
        room.adventurers.add(this);
        maxHealth = 14;
        health = 14;
        dodgeChance = 0.1;
        resonance = ElementType.EARTH;
        discord = ElementType.FIRE;
        treasureBag = new EmptyTreasureBag();
        combatExpertise = new Novice();
        searchExpertise = new Novice();
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
        if(roll()+ treasureBag.searchBonus()+ searchExpertise.bonus() >= 7 ){
            takeTreasure();
        }
    }

    @Override
    public void combat(Creature creature) {
        int playerRoll = roll() + treasureBag.combatBonus() + combatExpertise.bonus();
        int creatureRoll = roll() - treasureBag.armorBonus() + treasureBag.creatureBonus();
        if (playerRoll > creatureRoll){
            creature.dead = true;
            combatExpertise = combatExpertise.levelUp();
        }
        else if (playerRoll < creatureRoll){
            if (dodgeFailure(dodgeChance)){
                if(room.elementType==resonance){
                    health -= 1;
                }
                else if(room.elementType == discord){
                    health -= 3;
                }
            }
        }
    }

}
