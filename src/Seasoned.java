public class Seasoned implements Expertise{
    @Override
    public int bonus() {
        return 1;
    }

    @Override
    public Expertise levelUp() {
        if(Math.random() > randomLevelUp){
            return new Veteran();
        }
        else{
            return this;
        }
    }

    @Override
    public String toString() {
        return "Seasoned";
    }
}
