import Treasure.EmptyTreasureBag;

public class ZypherRogue extends Adventurer{
    public String toString() {
        return "ZR";
    }

    public ZypherRogue(Room room){
        this.room = room;
        room.adventurers.add(this);

        health = 3;
        dodgeChance = 0.25;
        resonance = ElementType.AIR;
        discord = ElementType.EARTH;
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
        int roll = roll();
        if(room.elementType.equals(resonance)){
            roll += 2;
        }
        else if(room.elementType.equals(discord)){
            roll -= 2;
        }

        if(roll+ treasureBag.searchBonus() + searchExpertise.bonus() >= 11 ){
            takeTreasure();
        }
    }


    public void combat(Creature creature) {
        int playerRoll = roll() + treasureBag.combatBonus() + combatExpertise.bonus();
        int creatureRoll = roll() - treasureBag.armorBonus() + treasureBag.creatureBonus();
        if (playerRoll > creatureRoll){
            creature.dead = true;
            combatExpertise = combatExpertise.levelUp();
        }
        else if (playerRoll < creatureRoll){
            if (dodgeFailure(dodgeChance)){
                health -= 2;
            }
        }
    }

}
