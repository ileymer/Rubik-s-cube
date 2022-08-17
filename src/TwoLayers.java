
public class TwoLayers {

    static public void start(StructureSides rubik)
    {
        int i;

        i = 0;

        while (i < 3) {
            if (rubik.yellow[2][1] != 'Y' && rubik.blue[0][1] != 'Y') {
                putInPlace(rubik, rubik.yellow[2][1], rubik.blue[0][1], 'B');
            }
            if (rubik.yellow[1][0] != 'Y' && rubik.orange[0][1] != 'Y') {
                putInPlace(rubik, rubik.yellow[1][0], rubik.orange[0][1], 'O');
            }
            if (rubik.yellow[0][1] != 'Y' && rubik.green[0][1] != 'Y') {
                putInPlace(rubik, rubik.yellow[0][1], rubik.green[0][1], 'G');
            }
            if (rubik.yellow[1][2] != 'Y' && rubik.red[0][1] != 'Y') {
                putInPlace(rubik, rubik.yellow[1][2], rubik.red[0][1], 'R');
            }
            i++;
        }

        if (check(rubik) == 0)
        {
            putInPlaceHelper(rubik);
            start(rubik);
        }


    }


    static public void putInPlaceHelper(StructureSides rubik)
    {
        if (rubik.blue[1][2] != 'Y' && rubik.red[1][0] != 'Y' && (rubik.blue[1][2] != 'B' || rubik.red[1][0] != 'R'))
            helper('B', 'R', rubik);
        if (rubik.red[1][2] != 'Y' && rubik.green[1][0] != 'Y' && (rubik.red[1][2] != 'R' || rubik.green[1][0] != 'G'))
            helper('R', 'G', rubik);
        if (rubik.green[1][2] != 'Y' && rubik.orange[1][0] != 'Y' && (rubik.green[1][2] != 'G' || rubik.orange[1][0] != 'O'))
            helper('G', 'O', rubik);
        if (rubik.orange[1][2] != 'Y' && rubik.blue[1][0] != 'Y' && (rubik.orange[1][2] != 'O' || rubik.blue[1][0] != 'B'))
            helper('O', 'B', rubik);

    }


    static public void helper(char e, char ey, StructureSides rubik)
    {
        Presentation.Moves(e, 'U', rubik);
        Presentation.Moves(e, 'R', rubik);
        Presentation.Moves(e, 'U', rubik);
        Presentation.Moves(e, 'r', rubik);
        Presentation.Moves(e, 'u', rubik);
        Presentation.Moves(ey, 'l', rubik);
        Presentation.Moves(ey, 'u', rubik);
        Presentation.Moves(ey, 'L', rubik);
    }

    static public int check(StructureSides rubik)
    {
        if (rubik.blue[1][0] != rubik.blue[1][1] || rubik.blue[1][2] != rubik.blue[1][1])
            return (0);
        if (rubik.red[1][0] != rubik.red[1][1] || rubik.red[1][2] != rubik.red[1][1])
            return (0);
        if (rubik.green[1][0] != rubik.green[1][1] || rubik.green[1][2] != rubik.green[1][1])
            return (0);
        if (rubik.orange[1][0] != rubik.orange[1][1] || rubik.orange[1][2] != rubik.orange[1][1])
            return (0);
        return (1);
    }

    static public void putInPlace(StructureSides rubik, char ey, char e, char ec)
    {
        int n;

        n = WhiteSide.nRevolutions(ec, e);
        if (n == -1)
        {
            Presentation.Moves('B', 'U', rubik);
        }
        else if (n == 1)
            Presentation.Moves('B', 'u', rubik);
        else if (n == 2)
        {
            Presentation.Moves('B', 'u', rubik);
            Presentation.Moves('B', 'u', rubik);
        }

        n = WhiteSide.nRevolutions(e, ey);
        if (n == 1)
        {
            Presentation.Moves(e, 'U', rubik);
            Presentation.Moves(e, 'R', rubik);
            Presentation.Moves(e, 'U', rubik);
            Presentation.Moves(e, 'r', rubik);
            Presentation.Moves(e, 'u', rubik);
            Presentation.Moves(ey, 'l', rubik);
            Presentation.Moves(ey, 'u', rubik);
            Presentation.Moves(ey, 'L', rubik);

        }
        else if (n == -1)
        {
            Presentation.Moves(e, 'u', rubik);
            Presentation.Moves(e, 'l', rubik);
            Presentation.Moves(e, 'u', rubik);
            Presentation.Moves(e, 'L', rubik);
            Presentation.Moves(e, 'U', rubik);
            Presentation.Moves(ey, 'R', rubik);
            Presentation.Moves(ey, 'U', rubik);
            Presentation.Moves(ey, 'r', rubik);
        }
    }






}
