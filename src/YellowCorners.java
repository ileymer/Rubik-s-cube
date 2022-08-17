

public class YellowCorners {

    public static void start(StructureSides rubik, int f)
    {
        int i;
        char e = 'B';

        int []a = new int[5];
        i = 0;

            i = 0;
            a[1] = 0;
            a[2] = 0;
            a[3] = 0;
            a[4] = 0;
            if ((rubik.yellow[2][0] == 'O' || rubik.yellow[2][0] == 'B' || rubik.yellow[2][0] == 'Y') &&
                    (rubik.blue[0][0] == 'O' || rubik.blue[0][0] == 'B' || rubik.blue[0][0] == 'Y') &&
                    (rubik.orange[0][2] == 'O' || rubik.orange[0][2] == 'B' || rubik.orange[0][2] == 'Y'))
            {
                i++;
                e = 'B';
            }
            if ((rubik.yellow[0][0] == 'O' || rubik.yellow[0][0] == 'G' || rubik.yellow[0][0] == 'Y') &&
                    (rubik.green[0][2] == 'O' || rubik.green[0][2] == 'G' || rubik.green[0][2] == 'Y') &&
                    (rubik.orange[0][0] == 'O' || rubik.orange[0][0] == 'G' || rubik.orange[0][0] == 'Y')) {
                i++;
                e = 'O';
            }
            if ((rubik.yellow[0][2] == 'R' || rubik.yellow[0][2] == 'G' || rubik.yellow[0][2] == 'Y') &&
                    (rubik.green[0][0] == 'R' || rubik.green[0][0] == 'G' || rubik.green[0][0] == 'Y') &&
                    (rubik.red[0][2] == 'R' || rubik.red[0][2] == 'G' || rubik.red[0][2] == 'Y')) {
                i++;
                e = 'G';
            }
            if ((rubik.yellow[2][2] == 'R' || rubik.yellow[2][2] == 'B' || rubik.yellow[2][2] == 'Y') &&
                    (rubik.blue[0][2] == 'R' || rubik.blue[0][2] == 'B' || rubik.blue[0][2] == 'Y') &&
                    (rubik.red[0][0] == 'R' || rubik.red[0][0] == 'B' || rubik.red[0][0] == 'Y')) {
                i++;
                e = 'R';
            }

        if (i == 4)
            return;
        Presentation.Moves(e, 'R', rubik);
        Presentation.Moves(e, 'u', rubik);
        Presentation.Moves(e, 'l', rubik);
        Presentation.Moves(e, 'U', rubik);
        Presentation.Moves(e, 'r', rubik);
        Presentation.Moves(e, 'u', rubik);
        Presentation.Moves(e, 'L', rubik);
        Presentation.Moves(e, 'U', rubik);
i++;
        start(rubik, 1);

    }













    public static void leftHand(StructureSides rubik, char e)
    {
        Presentation.Moves(e, 'l', rubik);
        Presentation.Moves(e, 'u', rubik);
        Presentation.Moves(e, 'L', rubik);
        Presentation.Moves(e, 'U', rubik);
    }

    public static void locationTwo(int []a, StructureSides rubik, int f)
    {
        if (a[1] == 1 && a[3] == 1)
        {
            RealCross.rightHand(rubik, 'B');
            RealCross.rightHand(rubik, 'B');
            RealCross.rightHand(rubik, 'B');
            leftHand(rubik, 'R');
            leftHand(rubik, 'R');
            leftHand(rubik, 'R');
        }
        else if (a[2] == 1 && a[4] == 1)
        {
            RealCross.rightHand(rubik, 'O');
            RealCross.rightHand(rubik, 'O');
            RealCross.rightHand(rubik, 'O');
            leftHand(rubik, 'B');
            leftHand(rubik, 'B');
            leftHand(rubik, 'B');
        }
        else if (a[3] == 1 && a[1] == 1)
        {
            RealCross.rightHand(rubik, 'G');
            RealCross.rightHand(rubik, 'G');
            RealCross.rightHand(rubik, 'G');
            leftHand(rubik, 'O');
            leftHand(rubik, 'O');
            leftHand(rubik, 'O');
        }
        else if (a[4] == 1 && a[2] == 1)
        {
            RealCross.rightHand(rubik, 'R');
            RealCross.rightHand(rubik, 'R');
            RealCross.rightHand(rubik, 'R');
            leftHand(rubik, 'G');
            leftHand(rubik, 'G');
            leftHand(rubik, 'G');
        }
        if (f == 0)
        start(rubik, 1);
    }

    public static void locationOne(int []a, StructureSides rubik)
    {
        if (a[1] == 1 && a[2] == 1)
        {
            RealCross.rightHand(rubik, 'B');
            RealCross.rightHand(rubik, 'B');
            RealCross.rightHand(rubik, 'B');
            leftHand(rubik, 'R');
            leftHand(rubik, 'R');
            leftHand(rubik, 'R');
        }
        else if (a[2] == 1 && a[3] == 1)
        {
            RealCross.rightHand(rubik, 'O');
            RealCross.rightHand(rubik, 'O');
            RealCross.rightHand(rubik, 'O');
            leftHand(rubik, 'B');
            leftHand(rubik, 'B');
            leftHand(rubik, 'B');
        }
        else if (a[3] == 1 && a[4] == 1)
        {
            RealCross.rightHand(rubik, 'G');
            RealCross.rightHand(rubik, 'G');
            RealCross.rightHand(rubik, 'G');
            leftHand(rubik, 'O');
            leftHand(rubik, 'O');
            leftHand(rubik, 'O');
        }
        else if (a[4] == 1 && a[1] == 1)
        {
            RealCross.rightHand(rubik, 'R');
            RealCross.rightHand(rubik, 'R');
            RealCross.rightHand(rubik, 'R');
            leftHand(rubik, 'G');
            leftHand(rubik, 'G');
            leftHand(rubik, 'G');
        }
    }
}
