public class Zyphral extends Creature{

    //move on air floor
    // randomly move between rooms on the floor
    // won't move if an adventurer is present

    Room roomZ;
    int row = (int)Math.random()*3 + 1;
    int col = (int)Math.random()*3 + 1;

    public Zyphral(){
        roomZ = new Room(row,col);
        if(roomZ.adventurers.size() == 0) {
            move();
        }
    }

    public void move(){
        roomZ.getRandomAdjacentRoom();
    }

}
