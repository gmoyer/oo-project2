public class TerraVoyager extends Adventurer{
    public String toString() {
        return "TV";
    }

    public TerraVoyager(Room room){
        this.room = room;
        room.adventurers.add(this);

        health = 7;
        dodgeChance = 0.1;
        resonance = ElementType.EARTH;
        discord = ElementType.FIRE;
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
