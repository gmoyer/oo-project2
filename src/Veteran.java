public class Veteran implements Expertise{
    @Override
    public int bonus() {
        return 2;
    }

    @Override
    public Expertise levelUp() {
        if(Math.random() > 0.5){
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
