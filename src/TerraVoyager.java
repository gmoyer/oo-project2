public class TerraVoyager extends Adventurer{
    private int health = 7;
    private float dodgeChance = 0.1F;
    private int treasures;
    private ElementType resonance = ElementType.EARTH;
    private ElementType discord = ElementType.FIRE;
    public String toString() {
        return "TV";
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
            if (Boolean.compare(dodge,true) == 0){
                System.out.println("Dodge Success. Creature missed");
            }
            else {
                System.out.println("Dodge Failed!. Creature hit adventure!");
                if(room.elementType.equals(resonance)){
                    removeHealth(1);
                }
                else if(room.elementType.equals(discord)){
                    removeHealth(3);
                }else{
                    removeHealth(2);
                }

                boolean healthCheck = checkHealth();
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

}
