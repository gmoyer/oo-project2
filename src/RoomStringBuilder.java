import java.util.ArrayList;

public class RoomStringBuilder {
    private static String buildCharacterString(ArrayList<? extends Character> characters) {
        StringBuilder characterString = new StringBuilder();
        for (Character character : characters) {
            characterString.append(character.toString()).append(",");
        }
        if (!characterString.isEmpty()) {
            characterString.deleteCharAt(characterString.length() - 1);
        }
        return characterString.toString();
    }

    public static String borderString() {
        return "+---------------------------";
    }
    public static String mainString(Room room) {
        int strLen = 13;

        // Build the string of adventurers and creatures
        String adventurersString = buildCharacterString(room.adventurers);
        String creaturesString = buildCharacterString(room.creatures);

        // Build the main string, adding spaces so that the string is always the same length
        StringBuilder mainString = new StringBuilder();
        mainString.append("|");

        // Adventurers
        if (adventurersString.length() < strLen) {
            mainString.append(" ".repeat(strLen - adventurersString.length()));
        }
        mainString.append(adventurersString);

        // Add a colon between adventurers and creatures
        mainString.append(":");

        // Creatures
        mainString.append(creaturesString);
        if (creaturesString.length() < strLen) {
            mainString.append(" ".repeat(strLen - creaturesString.length()));
        }

        return mainString.toString();
    }
    public static String borderTailString() {
        return "+\n";
    }
    public static String mainTailString() {
        return "|\n";
    }
}
