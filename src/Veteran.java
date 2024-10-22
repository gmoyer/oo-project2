public class Veteran implements Expertise{
    @Override
    public int bonus() {
        return 2;
    }

    @Override
    public Expertise levelUp() {
        if(Math.random() > randomLevelUp){
            return new Master();
        }
        else{
            return this;
        }
    }

    @Override
    public String toString() {
        return "Veteran";
    }
}
