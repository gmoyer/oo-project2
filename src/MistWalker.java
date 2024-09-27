public class MistWalker extends Adventurer{
    private int health = 3;
    private float dodgeChance = 0.5F;
    private float ogDodgeChance = 0.5F;
    private int treasures = 0;
    private ElementType resonance = ElementType.WATER;
    private ElementType discord = ElementType.AIR;
    public String toString() {
        return "MW";
    }

    @Override
    public void searchTreasure(Room room) {
        int roll = diceRollGenerator();
        if(Integer.compare(roll,11) == 0){
            System.out.println("Adventurer found TREASURE!");
            addTreasures(1);
        }
        else{
            System.out.println("No treasure was found");
        }
    }

    @Override
    public void combat(Creature creature, Room room) {
        int playerRoll = 5;//diceRollgenerator();
        int creatureRoll = 8;//diceRollgenerator();
        if(Integer.compare(playerRoll,creatureRoll) == 1){
            //Adventurer wins and creature gets removed because of lost
            System.out.println("Adventurer Wins!");
            //creature.remove();
            System.out.println("Creature Removed");
        }
        else if (Integer.compare(playerRoll,creatureRoll) == -1){
            System.out.println("Creature Wins");
            System.out.println("Adventure has a dodge chance!");
            boolean dodge = dodgeSuccess(dodgeChance);
            //if statement takes into account resonance and discord
            if(room.elementType.equals(resonance)){
                float d = dodgeChance+0.25F;
                setDodgeChance(d);
                dodge = dodgeSuccess(d);
            }
            else if(room.elementType.equals(discord)){
                float d = dodgeChance-0.25F;
                setDodgeChance(d);
                dodge = dodgeSuccess(d);
            }
            else{
                float d = ogDodgeChance;
                setDodgeChance(d);
                dodge = dodgeSuccess(d);
            }

            if (Boolean.compare(dodge,true) == 0){
                System.out.println("Dodge Success. Creature missed");
            }
            else {
                System.out.println("Dodge Failed!. Creature hit adventure!");
                removeHealth(2);
                boolean healthCheck = checkHealth();
                System.out.println(healthCheck);
                if(Boolean.compare(healthCheck,true) == 0){
                    //remove adventurer
                    System.out.println("Adventure took to much damage! Adventure dies!");
                }
            }
        }
        else {
            System.out.println("Adventure and Creature tied nothing happens.");
        }
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void removeHealth(int hit) {
        health-=hit;
    }
    @Override
    public float getDodgeChance(){
        return dodgeChance;
    }

    public void setDodgeChance(float dodgeChance) {
        this.dodgeChance = dodgeChance;
    }
}
