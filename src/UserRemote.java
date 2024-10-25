import java.util.ArrayList;

public class UserRemote {
    ArrayList<Command> slots = new ArrayList<Command>();
    ArrayList<Command> availableSlots = new ArrayList<Command>();

    public UserRemote() {}

    public void addCommand(Command command) {
        slots.add(command);
    }

    public void removeCommand(Command command) {
        slots.remove(command);
    }

    public void updateAvailableSlots() {
        availableSlots.clear();
        for (Command command : slots) {
            if (command.canExecute()) {
                availableSlots.add(command);
            }
        }
    }

    public boolean buttonWasPressed(int row) {
        updateAvailableSlots();
        if (row >= availableSlots.size() || row < 0) {
            return false;
        }
        availableSlots.get(row).execute();
        return true;
    }

    public void printOptions(){
        updateAvailableSlots();
        for(int i = 0; i < availableSlots.size(); i++){
            System.out.println(i + ": " + availableSlots.get(i));
        }
    }
}
