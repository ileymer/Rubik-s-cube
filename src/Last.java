
public class Last {

    public static void start(StructureSides rubik)
    {
        while (rubik.blue[1][1] != rubik.blue[0][1])
            Presentation.Moves('B', 'U', rubik);
    }



    public static int assembled(StructureSides rubik)
    {
        if (assembledHelper(rubik.yellow) == 0)
            return (0);
        if (assembledHelper(rubik.white) == 0)
            return (0);
        if (assembledHelper(rubik.blue) == 0)
            return (0);
        if (assembledHelper(rubik.red) == 0)
            return (0);
        if (assembledHelper(rubik.green) == 0)
            return (0);
        if (assembledHelper(rubik.orange) == 0)
            return (0);
        return (1);
    }

    public static int assembledHelper(char [][]e) {
        int i = 0;
        int j;

        while (i < 3) {
            j = 0;
            while (j < 3) {
                if (e[i][j++] != e[1][1])
                    return (0);
            }
            i++;
        }
        return (1);
    }

}
