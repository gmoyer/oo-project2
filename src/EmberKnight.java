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
    }

    @Override
    public void move() {
        Room r = room.getRandomAdjacentRoom(true);
        room.adventurers.remove(this);
        room = r;
        room.adventurers.add(this);
    }

    @Override
    public int searchTreasure() {
        if(roll() >= 11){
            treasures++;
            return 1;
        }
        return 0;
    }

    @Override
    public void combat(Creature creature) {
        int playerRoll = roll();
        int creatureRoll = roll();
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
