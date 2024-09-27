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
        int roll = roll();
        if(room.elementType.equals(resonance)){
            roll += 2;
        }
        else if(room.elementType.equals(discord)){
            roll -= 2;
        }

        if(roll >= 11){
            treasures++;
            return 1;
        }
        return 0;
    }

    public void combat(Creature creature) {
        int playerRoll = roll();
        int creatureRoll = roll();
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
