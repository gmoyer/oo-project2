public class Main {
    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon();
        dungeon.floors[0].rooms[0][1].creatures.add(new Terravore());
        dungeon.floors[1].rooms[0][1].adventurers.add(new ZypherRogue());
        dungeon.floors[0].rooms[1][1].creatures.add(new Terravore());
        dungeon.floors[0].rooms[1][1].creatures.add(new Terravore());
        System.out.println(dungeon);

        Adventurer ad1 = new TerraVoyager();
        Adventurer ad2 = new MistWalker();

        System.out.println(dungeon.floors[0].rooms[0][0].elementType);
        ad1.combat(new Terravore(),dungeon.floors[0].rooms[0][0]);
        System.out.println(ad1.getHealth());
        //System.out.println(ad1.getDodgeChance());
        System.out.println();

        System.out.println(dungeon.floors[1].rooms[0][0].elementType);
        ad1.combat(new Terravore(),dungeon.floors[1].rooms[0][0]);
        System.out.println(ad1.getHealth());
        //System.out.println(ad1.getDodgeChance());
        System.out.println();
        System.out.println(dungeon.floors[2].rooms[0][0].elementType);
        ad1.combat(new Terravore(),dungeon.floors[2].rooms[0][0]);
        System.out.println(ad1.getHealth());
        //System.out.println(ad1.getDodgeChance());
        System.out.println();
        System.out.println(dungeon.floors[3].rooms[0][0].elementType);
        ad1.combat(new Terravore(),dungeon.floors[3].rooms[0][0]);
        System.out.println(ad1.getHealth());
        //System.out.println(ad1.getDodgeChance());



    }
}