import java.util.ArrayList;

public class UserRemote {
    ArrayList<Command> slots = new ArrayList<Command>();

    public UserRemote() {}

    public void addCommand(Command command) {
        slots.add(command);
    }

    public void removeCommand(Command command) {
        slots.remove(command);
    }

    public boolean buttonWasPressed(int row) {
        if (row >= slots.size() || row < 0) {
            return false;
        }
        slots.get(row).execute();
        return true;
    }

    public void printOptions(){
        for(int i = 0; i < slots.size(); i++){
            System.out.println(i + ": " + slots.get(i));
        }
    }
}
