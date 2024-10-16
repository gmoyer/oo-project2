public class Master implements Expertise{
    @Override
    public int bonus() {
        return 3;
    }

    @Override
    public Expertise levelUp() {
        return this;
    }

    public String toString(){
        return "Master";
    }

}
