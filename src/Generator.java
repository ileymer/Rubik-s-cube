
import java.util.ArrayList;

public abstract class Generator {
    static ArrayList<String> commands = new ArrayList<>();
    static String[] array = {"FRUBLD", "'2"};

    public static ArrayList<String> createCmd(double value) {
        for (int i = 0; i < value; i++) {
            String cmd = "";
            int firstIndex = (int) (Math.random() * 6);
            char firstChar = array[0].charAt(firstIndex);
            cmd += firstChar;
            int secondIndex = (int) (Math.random() * 3);
            if (secondIndex != 2) {
                char secondChar = array[1].charAt(secondIndex);
                cmd += secondChar;
            }
            commands.add(cmd);
        }
        return (commands);
    }
}
