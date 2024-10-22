public class Novice implements Expertise{

    @Override
    public int bonus() {
        return 0;
    }

    @Override
    public Expertise levelUp() {
        if(Math.random() > randomLevelUp){
            return new Seasoned();
        }
        else{
            return this;
        }

    }
    public String toString(){
        return "Novice";
    }
}
