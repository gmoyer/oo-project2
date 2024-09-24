public class Main {
    public static void main(String[] args) {
        Dungeon dungeon = new Dungeon();
        dungeon.floors[0].rooms[0][1].creatures.add(new Terravore());
        dungeon.floors[0].rooms[0][1].adventurers.add(new ZypherRogue());
        dungeon.floors[0].rooms[1][1].creatures.add(new Terravore());
        dungeon.floors[0].rooms[1][1].creatures.add(new Terravore());
        System.out.println(dungeon);
    }
}