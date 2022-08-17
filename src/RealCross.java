

public class RealCross {
    public static void start(StructureSides rubik) {
        int type = 0;

        type = checkCross(rubik.yellow);
        if (type == 1)
            return;
        if (type == 2)
        {
            helper(rubik);
        }
        else if (type == 3)
        {
            if (rubik.yellow[1][0] == 'Y' && rubik.yellow[0][1] == 'Y')
            {
                Presentation.Moves('B', 'F', rubik);
                rightHand(rubik, 'B');
                rightHand(rubik, 'B');
                Presentation.Moves('B', 'f', rubik);
            }
            else if (rubik.yellow[0][1] == 'Y' && rubik.yellow[1][2] == 'Y')
            {
                Presentation.Moves('O', 'F', rubik);
                rightHand(rubik, 'O');
                rightHand(rubik, 'O');
                Presentation.Moves('O', 'f', rubik);
            }
            else if (rubik.yellow[1][2] == 'Y' && rubik.yellow[2][1] == 'Y')
            {
                Presentation.Moves('G', 'F', rubik);
                rightHand(rubik, 'G');
                rightHand(rubik, 'G');
                Presentation.Moves('G', 'f', rubik);
            }
            else if (rubik.yellow[2][1] == 'Y' && rubik.yellow[1][0] == 'Y')
            {
                Presentation.Moves('R', 'F', rubik);
                rightHand(rubik, 'R');
                rightHand(rubik, 'R');
                Presentation.Moves('R', 'f', rubik);
            }
        }
        else if (type == 4)
        {
            Presentation.Moves('B', 'F', rubik);
            rightHand(rubik, 'B');
            rightHand(rubik, 'B');
            Presentation.Moves('B', 'f', rubik);
            helper(rubik);
        }



    }


    public static void helper(StructureSides rubik) {
        if (rubik.yellow[0][1] == 'Y' && rubik.yellow[2][1] == 'Y')
        {
            Presentation.Moves('O', 'F', rubik);
            rightHand(rubik, 'O');
            Presentation.Moves('O', 'f', rubik);
        }
        else if (rubik.yellow[1][0] == 'Y' && rubik.yellow[1][2] == 'Y')
        {
            Presentation.Moves('B', 'F', rubik);
            rightHand(rubik, 'B');
            Presentation.Moves('B', 'f', rubik);
        }
    }



    public static void rightHand(StructureSides rubik, char e) {
        Presentation.Moves(e, 'R', rubik);
        Presentation.Moves(e, 'U', rubik);
        Presentation.Moves(e, 'r', rubik);
        Presentation.Moves(e, 'u', rubik);
    }


    public static int checkCross(char [][]y)
    {
        if (y[0][1] == 'Y' && y[1][0] == 'Y' && y[1][2] == 'Y' && y[2][1] == 'Y')
            return (1);
        else if ((y[0][1] == 'Y' && y[2][1] == 'Y') || (y[1][0] == 'Y' && y[1][2] == 'Y'))
            return (2);
        else if ((y[1][0] == 'Y' && y[0][1] == 'Y') || (y[0][1] == 'Y' && y[1][2] == 'Y') || (y[1][2] == 'Y' && y[2][1] == 'Y') || (y[2][1] == 'Y' && y[1][0] == 'Y'))
            return (3);
        return (4);
    }
}
