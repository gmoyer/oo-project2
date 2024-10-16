import Treasure.EmptyTreasureBag;

public class MistWalker extends Adventurer{
    public String toString() {
        return "MW";
    }

    public MistWalker(Room room){
        this.room = room;
        room.adventurers.add(this);

        health = 3;
        dodgeChance = 0.5;
        resonance = ElementType.WATER;
        discord = ElementType.AIR;
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
        if(roll()+ treasureBag.searchBonus() + searchExpertise.bonus() >= 11 ){
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
            double dc = dodgeChance;
            if(room.elementType == resonance){
                dc += 0.25;
            }
            else if(room.elementType == discord){
                dc -= 0.25;
            }
            if (dodgeFailure(dc)){
                health -= 2;
            }
        }
    }
}
