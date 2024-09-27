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
        if (playerRoll > creatureRoll){
            creature.dead = true;
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
