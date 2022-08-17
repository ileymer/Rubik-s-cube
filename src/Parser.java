
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Parser {
    static int s = 0;
    static int b = 0;
    static int v = 0;
    static String[] commands = {"FRUBLD", "'2"};
    static ArrayList<String> list = new ArrayList<>();

    public static void helpMenu() {
        System.out.println("Usage: java rubik [-h] [-s] [-b] [-v] [-g number of commands] [-f file] \"commands\"");
        System.out.println("\th - Help");
        System.out.println("\ts - Simulator");
        System.out.println("\tb - Detailed output");
        System.out.println("\tv - Visualizer");
        System.out.println("\tg - Generator");
        System.out.println("\tf - Input via file");
        System.exit(0);
    }

    public static void errorInput() {
        System.err.println("Error Input");
        System.exit(1);
    }

    public static void parseFlags(String[] arg) {
        if (arg.length == 0)
            helpMenu();

        for (int i = 0; i < arg.length; i++) {
            switch (arg[i]) {
                case "-h":
                    helpMenu();
                case "-s":
                    s = 1;
                    return;
                case "-b":
                    b = 1;
                    break;
                case "-v":
                    v = 1;
                    break;
                case "-f":
                    try {
                        readFile(arg[++i]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        errorInput();
                    }
                    break;
                case "-g":
                    try {
                        list = Generator.createCmd(Double.parseDouble(arg[++i]));
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        errorInput();
                    }
                    break;
                default:
                    checkCommand(arg[i]);
            }
        }

        if (list.isEmpty() && s != 1)
            errorInput();
        else {
            System.out.print("Commands: ");
            for (String c : list)
                System.out.print(c + " ");
            System.out.println();
        }
    }

    public static void checkCommand(String str) {
        String[] cmd = str.split(" ");

        for (String com : cmd) {
            if (com.length() == 0)
                continue;
            if (com.length() > 2)
                errorInput();
            char[] lineCMD = com.toCharArray();
            if (commands[0].indexOf(lineCMD[0]) >= 0) {
                if (com.length() != 1) {
                    if (commands[1].indexOf(lineCMD[1]) < 0) {
                        System.err.println("Error - Incorrect commands");
                        System.exit(1);
                    }
                }
            } else {
                System.err.println("Error - Incorrect commands");
                System.exit(1);
            }
            list.add(com);
        }
    }

    public static void readFile(String fileName) {
        FileReader fr = null;

        try {
            fr = new FileReader(fileName);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error - No file");
            System.exit(1);
        }
        Scanner scan = new Scanner(fr);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            checkCommand(line);
        }
        if (list.isEmpty()) {
            System.err.println("Error - File is empty");
            System.exit(1);
        }
    }
}
