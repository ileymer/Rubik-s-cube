
public class FullYellow {
    public static void start(StructureSides rubik)
    {
        int i = 0;

        i = check(rubik);
        if (i == 4)
            return;
        while(i != 4)
        {
            while (rubik.blue[0][0] != 'Y' && rubik.orange[0][2] != 'Y')
                Presentation.Moves('B', 'U', rubik);
            while (check(rubik) == i)
            {
                Presentation.Moves('B', 'L', rubik);
                Presentation.Moves('B', 'D', rubik);
                Presentation.Moves('B', 'l', rubik);
                Presentation.Moves('B', 'd', rubik);
            }
            i = check((rubik));

        }

    }


    public static int check(StructureSides rubik)
    {
        int i = 0;

        if (rubik.yellow[0][0] == 'Y')
            i++;
        if (rubik.yellow[0][2] == 'Y')
            i++;
        if (rubik.yellow[2][0] == 'Y')
            i++;
        if (rubik.yellow[2][2] == 'Y')
            i++;
        return  (i);
    }
}
