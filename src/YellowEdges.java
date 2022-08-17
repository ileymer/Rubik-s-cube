
public class YellowEdges {

    public static void start(StructureSides rubik)
    {
        int i;
        char e;

        while ((i = checkEdges(rubik)) == 0)
            Presentation.Moves('B', 'U', rubik);
        if (i == 4)
            return;
        e = edge(rubik, i);
        if (i < 0)
        {
            locationOne(rubik, e);
        }
        else
            locationTwo(rubik, e);
        start (rubik);
    }


    public static char edge(StructureSides rubik, int i)
    {
        if (i == 5 || i == -5)
            return ('B');
        if (i == 6 || i == -6)
            return ('R');
        if (i == 7 || i == -7)
            return ('G');
        if (i == 8 || i == -8)
            return ('O');
        return (0);
    }

    public static void locationOne(StructureSides rubik, char e)
    {
        Presentation.Moves(e, 'R', rubik);
        Presentation.Moves(e, 'U', rubik);
        Presentation.Moves(e, 'r', rubik);
        Presentation.Moves(e, 'U', rubik);
        Presentation.Moves(e, 'R', rubik);
        Presentation.Moves(e, 'u', rubik);
        Presentation.Moves(e, 'u', rubik);
        Presentation.Moves(e, 'r', rubik);
    }

    public static void locationTwo(StructureSides rubik, char e)
    {
        int i;

        i = WhiteSide.nRevolutions('B', e);
        if (i == 0)
            e = 'G';
        if (i == 1)
            e = 'O';
        if (i == 2)
            e = 'B';
        if (i == -1)
            e = 'R';

        Presentation.Moves(e, 'R', rubik);
        Presentation.Moves(e, 'U', rubik);
        Presentation.Moves(e, 'r', rubik);
        Presentation.Moves(e, 'U', rubik);
        Presentation.Moves(e, 'R', rubik);
        Presentation.Moves(e, 'u', rubik);
        Presentation.Moves(e, 'u', rubik);
        Presentation.Moves(e, 'r', rubik);
        Presentation.Moves(e, 'U', rubik);
    }

    public static int checkEdges(StructureSides rubik)
    {
        int i;

        i = 0;
        int e = 0;

        if (rubik.blue[0][1] == 'B') {
            i++;
            e = 5;
        }
        if (rubik.red[0][1] == 'R') {
            i++;
            e = 6;
        }
        if (rubik.green[0][1] == 'G') {
            i++;
            e = 7;
        }
        if (rubik.orange[0][1] == 'O')
        {
            i++;
            e = 8;
        }
        if (i == 4)
            return (i);
        if (i == 2)
        {
            if ((rubik.blue[0][1] == 'B' &&  rubik.green[0][1] == 'G') || ((rubik.red[0][1] == 'R') && (rubik.orange[0][1] == 'O')))
                return (e * (-1));
            return (e);
        }
        return (0);



    }

}

