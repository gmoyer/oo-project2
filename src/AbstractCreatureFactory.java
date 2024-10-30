import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract interface AbstractCreatureFactory {
    public ArrayList<Creature> createCreature(ElementType type, Floor floor);
}
