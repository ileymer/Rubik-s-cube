public class CrossYellow {

    static public void start(StructureSides rubik)
    {
        while(CheckCross(rubik.yellow) == false) {
            secondOfYellow(rubik);
            firstOfYellow(rubik);
            thirdOfYellow(rubik);
            whiteOfYellow(rubik);
        }
    }



    static public void firstOfYellow(StructureSides rubik)
    {
        int i = 9;
        int f;

        f = 1;

        while(f == 1)
        {
            f = 0;
            if (rubik.blue[0][1] == 'W')
            {
                if (rubik.yellow[1][0] != 'W') {
                    Presentation.Moves('B', 'f', rubik);
                    Presentation.Moves('B', 'l', rubik);
                }
                else
                {
                    if (rubik.yellow[0][1] != 'W') {
                        Presentation.Moves('B', 'f', rubik);
                        Presentation.Moves('B', 'u', rubik);
                        Presentation.Moves('B', 'l', rubik);
                    }
                    else if (rubik.yellow[2][1] != 'W') {
                        Presentation.Moves('B', 'f', rubik);
                        Presentation.Moves('B', 'U', rubik);
                        Presentation.Moves('B', 'l', rubik);
                    }
                    else {
                        Presentation.Moves('B', 'F', rubik);
                        Presentation.Moves('B', 'R', rubik);
                    }

                }
            }

            if (rubik.red[0][1] == 'W')
            {
                if (rubik.yellow[2][1] != 'W') {
                    Presentation.Moves('R', 'f', rubik);
                    Presentation.Moves('R', 'l', rubik);
                    i++;
                }
                else
                {
                    if (rubik.yellow[1][0] != 'W') {
                        Presentation.Moves('R', 'f', rubik);
                        Presentation.Moves('R', 'u', rubik);
                        Presentation.Moves('R', 'l', rubik);
                    }
                    else if (rubik.yellow[1][2] != 'W') {
                        Presentation.Moves('R', 'f', rubik);
                        Presentation.Moves('R', 'U', rubik);
                        Presentation.Moves('R', 'l', rubik);
                    }
                    else {
                        Presentation.Moves('R', 'F', rubik);
                        Presentation.Moves('R', 'R', rubik);
                    }

                }
            }

            if (rubik.green[0][1] == 'W')
            {
                if (rubik.yellow[1][2] != 'W') {
                    Presentation.Moves('G', 'f', rubik);
                    Presentation.Moves('G', 'l', rubik);
                }
                else
                {
                    if (rubik.yellow[2][1] != 'W') {
                        Presentation.Moves('G', 'f', rubik);
                        Presentation.Moves('G', 'u', rubik);
                        Presentation.Moves('G', 'l', rubik);
                    }
                    else if (rubik.yellow[0][1] != 'W') {
                        Presentation.Moves('G', 'f', rubik);
                        Presentation.Moves('G', 'U', rubik);
                        Presentation.Moves('G', 'l', rubik);
                    }
                    else {
                        Presentation.Moves('G', 'F', rubik);
                        Presentation.Moves('G', 'R', rubik);
                    }

                }
            }

            if (rubik.orange[0][1] == 'W')
            {
                if (rubik.yellow[0][1] != 'W') {
                    Presentation.Moves('O', 'f', rubik);
                    Presentation.Moves('O', 'l', rubik);
                }
                else
                {
                    if (rubik.yellow[1][2] != 'W') {
                        Presentation.Moves('O', 'f', rubik);
                        Presentation.Moves('O', 'u', rubik);
                        Presentation.Moves('O', 'l', rubik);
                    }
                    else if (rubik.yellow[0][1] != 'W') {
                        Presentation.Moves('O', 'f', rubik);
                        Presentation.Moves('O', 'U', rubik);
                        Presentation.Moves('O', 'l', rubik);
                    }
                    else {
                        Presentation.Moves('O', 'F', rubik);
                        Presentation.Moves('O', 'R', rubik);
                    }

                }
            }
        }
    }


    static public void secondOfYellow(StructureSides rubik)
    {
        int i = 0;

        if (rubik.blue[1][0] == 'W')
        {
            secondStart(rubik, rubik.blue, 1, 0, 'l');
        }
        if (rubik.blue[1][2] == 'W')
        {
            secondStart(rubik, rubik.blue, 1, 2, 'R');
        }
        if (rubik.red[1][0] == 'W')
        {
            secondStart(rubik, rubik.red, 2, 1, 'l');
        }
        if (rubik.red[1][2] == 'W')
        {
            secondStart(rubik, rubik.red, 0, 1, 'R');
        }
        if (rubik.green[1][0] == 'W')
        {
            secondStart(rubik, rubik.green, 1, 2, 'l');
        }
        if (rubik.green[1][2] == 'W')
        {
            secondStart(rubik, rubik.green, 1, 0, 'R');
        }
        if (rubik.orange[1][0] == 'W')
        {
            secondStart(rubik, rubik.orange, 0, 1, 'l');
        }
        if (rubik.orange[1][2] == 'W')
        {
            secondStart(rubik, rubik.orange, 2, 1, 'R');
        }
    }

    static public void secondStart(StructureSides rubik, char [][] edge, int iy, int jy, char m)
    {
        int i;

        i = 0;
        if (rubik.yellow[iy][jy] != 'W')
        {
            Presentation.Moves(edge[1][1], m, rubik);
        }
        else
        {
            while (i < 3)
            {
                Presentation.Moves(edge[1][1], 'U', rubik);
                if (rubik.yellow[iy][jy] != 'W')
                {
                    Presentation.Moves(edge[1][1], m, rubik);
                    break;
                }
                i++;
            }

        }
    }


    static public void thirdOfYellow(StructureSides rubik)
    {
        if (rubik.blue[2][1] == 'W')
        {
            thirdStart(rubik, 'B', 2, 1);
        }
        if (rubik.red[2][1] == 'W')
        {
            thirdStart(rubik, 'R', 1, 2);
        }
        if (rubik.green[2][1] == 'W')
        {
            thirdStart(rubik, 'G', 0, 1);
        }
        if (rubik.orange[2][1] == 'W')
        {
            thirdStart(rubik, 'O', 1, 0);
        }
    }


    static public void thirdStart(StructureSides rubik, char e, int iy, int jy)
    {
        int i = 0;

        if (rubik.yellow[iy][jy] != 'W')
        {
            Presentation.Moves(e, 'F', rubik);
            Presentation.Moves(e, 'U', rubik);
            Presentation.Moves(e, 'l', rubik);
        }
        else
        {
            while (i < 3)
            {
                Presentation.Moves(e, 'U', rubik);

                if (rubik.yellow[iy][jy] != 'W')
                {
                    Presentation.Moves(e, 'F', rubik);
                    Presentation.Moves(e, 'U', rubik);
                    Presentation.Moves(e, 'l', rubik);
                    break;
                }
                i++;

            }

        }
    }



    static public void whiteOfYellow(StructureSides rubik)
    {
        if (rubik.white[0][1] == 'W')
            whiteStart(rubik, 'B', 2, 1, 'F');
        if (rubik.white[1][2] == 'W')
            whiteStart(rubik, 'B', 1, 2, 'R');
        if (rubik.white[2][1] == 'W')
            whiteStart(rubik, 'B', 0, 1, 'B');
        if (rubik.white[1][0] == 'W')
            whiteStart(rubik, 'B', 1, 0, 'L');

    }

    static public void whiteStart(StructureSides rubik, char e, int iy, int jy, char m)
    {
        int i = 0;

        if (rubik.yellow[iy][jy] != 'W')
        {
            Presentation.Moves(e, m, rubik);
            Presentation.Moves(e, m, rubik);
        }
        else
        {
            while (i < 3)
            {
                Presentation.Moves(e, 'U', rubik);
                if (rubik.yellow[iy][jy] != 'W')
                {
                    Presentation.Moves(e, m, rubik);
                    Presentation.Moves(e, m, rubik);
                    break;
                }
                i++;

            }

        }
    }



    static public boolean CheckCross(char [][] yellow)
    {
        if (yellow[0][1] != 'W')
            return (false);
        if (yellow[1][0] != 'W')
            return (false);
        if (yellow[1][2] != 'W')
            return (false);
        if (yellow[2][1] != 'W')
            return (false);
        return (true);
    }
}
