

public class WhiteSide {
    public static void start(StructureSides rubik) {
        while (checkX(rubik.white) != 1 || checkOne(rubik) != 1) {
            locationOne(rubik);
            locationTwo(rubik);
            locationThree(rubik);
            locationFour(rubik);
            locationX(rubik);
        }
    }


    public static int checkOne(StructureSides rubik)
    {
        int i;

        i = 0;
        i+=checkTwo(rubik.blue, 'B');
        i+=checkTwo(rubik.red, 'R');
        i+=checkTwo(rubik.green, 'G');
        i+=checkTwo(rubik.orange, 'O');
        if (i == 4)
            return (1);
        return (0);
    }

    public static int checkTwo(char [][]arr, char e)
    {
        int i;

        i = 0;
        while (i < 3)
        {
            if (arr[2][i++] != e)
                return (0);
        }
        return (1);
    }

    public static int checkX(char [][] w)
    {
        int i;
        int j;

        i = 0;
        while (i < 3)
        {
            j = 0;
            while (j < 3)
            {
                if (w[i][j++] != 'W')
                    return (0);
            }
            i++;
        }
        return (1);
    }

    public static void locationFour(StructureSides rubik) {
        if (rubik.blue[2][0] == 'W')
        {
            Presentation.Moves('B', 'F', rubik);
            Presentation.Moves('B', 'U', rubik);
            Presentation.Moves('B', 'f', rubik);
            locationTwo(rubik);
        }
        if (rubik.red[2][0] == 'W')
        {
            Presentation.Moves('R', 'F', rubik);
            Presentation.Moves('R', 'U', rubik);
            Presentation.Moves('R', 'f', rubik);
            locationTwo(rubik);
        }
        if (rubik.green[2][0] == 'W')
        {
            Presentation.Moves('G', 'F', rubik);
            Presentation.Moves('G', 'U', rubik);
            Presentation.Moves('G', 'f', rubik);
            locationTwo(rubik);
        }
        if (rubik.orange[2][0] == 'W')
        {
            Presentation.Moves('O', 'F', rubik);
            Presentation.Moves('O', 'U', rubik);
            Presentation.Moves('O', 'f', rubik);
            locationTwo(rubik);
        }


        if (rubik.blue[2][2] == 'W')
        {
            Presentation.Moves('B', 'f', rubik);
            Presentation.Moves('B', 'u', rubik);
            Presentation.Moves('B', 'F', rubik);
            locationTwo(rubik);
        }
        if (rubik.red[2][2] == 'W')
        {
            Presentation.Moves('R', 'f', rubik);
            Presentation.Moves('R', 'u', rubik);
            Presentation.Moves('R', 'F', rubik);
            locationTwo(rubik);
        }
        if (rubik.green[2][2] == 'W')
        {
            Presentation.Moves('G', 'f', rubik);
            Presentation.Moves('G', 'u', rubik);
            Presentation.Moves('G', 'F', rubik);
            locationTwo(rubik);
        }
        if (rubik.orange[2][2] == 'W')
        {
            Presentation.Moves('O', 'f', rubik);
            Presentation.Moves('O', 'u', rubik);
            Presentation.Moves('O', 'F', rubik);
            locationTwo(rubik);
        }
    }

    public static void locationX(StructureSides rubik)
    {
        if (rubik.white[0][0] == 'W' && (rubik.orange[2][2] != 'O' || rubik.blue[2][0] != 'B'))
        {
            Presentation.Moves('B', 'l', rubik);
            Presentation.Moves('B', 'u', rubik);
            Presentation.Moves('B', 'L', rubik);
            locationOne(rubik);
        }
        if (rubik.white[2][0] == 'W' && (rubik.orange[2][0] != 'O' || rubik.green[2][2] != 'G'))
        {
            Presentation.Moves('B', 'L', rubik);
            Presentation.Moves('B', 'U', rubik);
            Presentation.Moves('B', 'l', rubik);
            locationTwo(rubik);
        }
        if (rubik.white[0][2] == 'W' && (rubik.blue[2][2] != 'B' || rubik.red[2][0] != 'R'))
        {
            Presentation.Moves('B', 'R', rubik);
            Presentation.Moves('B', 'U', rubik);
            Presentation.Moves('B', 'r', rubik);
            locationOne(rubik);
        }
        if (rubik.white[2][2] == 'W' && (rubik.red[2][2] != 'R' || rubik.green[2][0] != 'G'))
        {
            Presentation.Moves('B', 'r', rubik);
            Presentation.Moves('B', 'u', rubik);
            Presentation.Moves('B', 'R', rubik);
            locationOne(rubik);
        }
    }

    public static void locationThree(StructureSides rubik)
    {
        int i;
        int j;

        i = 0;
        j = 0;
        while (i == 0 && j < 3) {
            if (rubik.yellow[0][0] == 'W')
            i = startThree(rubik, 0, 0);
            if (i == 1)
                break;
            if (rubik.yellow[0][2] == 'W')
            i = startThree(rubik, 0, 2);
            if (i == 1)
                break;
            if (rubik.yellow[2][0] == 'W')
            i = startThree(rubik, 2, 0);
            if (i == 1)
                break;
            if (rubik.yellow[2][2] == 'W')
            i = startThree(rubik, 2, 2);
            if (i == 1)
                break;
            j++;



        }
    }


    public static int startThree(StructureSides rubik, int i , int j)
    {
        while(threeValid(i, j, rubik.white) != 1)
        {
            if (i == 0 && j == 0)
            {
                j = 2;

            }
            else if (i == 0 && j == 2)
            {
                i = 2;
                j = 2;
            }
            else if (i == 2 && j == 2)
            {
                i = 2;
                j = 0;
            }
            else if (i == 2 && j == 0)
                i = 0;

            Presentation.Moves('B', 'U', rubik);
        }
        if (threeValid(i, j, rubik.white) == 1)
        {
            if (i == 0 && j == 0)
            {
                Presentation.Moves('B', 'L', rubik);
                Presentation.Moves('B', 'U', rubik);
                Presentation.Moves('B', 'U', rubik);
                Presentation.Moves('B', 'l', rubik);
            }
            else if (i == 0 && j ==2)
            {
                Presentation.Moves('B', 'r', rubik);
                Presentation.Moves('B', 'U', rubik);
                Presentation.Moves('B', 'U', rubik);
                Presentation.Moves('B', 'R', rubik);
            }
            else if (i == 2 && j ==0)
            {
                Presentation.Moves('B', 'l', rubik);
                Presentation.Moves('B', 'U', rubik);
                Presentation.Moves('B', 'U', rubik);
                Presentation.Moves('B', 'L', rubik);
            }
            else if (i == 2 && j == 2)
            {
                Presentation.Moves('B', 'R', rubik);
                Presentation.Moves('B', 'U', rubik);
                Presentation.Moves('B', 'U', rubik);
                Presentation.Moves('B', 'r', rubik);
            }

            locationTwo(rubik);
            return (1);
        }
        return (0);
    }


    public static int threeValid(int i, int j, char [][]w)
    {
        if (i == 0 && j == 0)
        {
            if (w[2][0] != 'W')
                return (1);
        }
        else if (i == 0 && j ==2)
        {
            if (w[2][2] != 'W')
                return (1);
        }
        else if (i == 2 && j == 0)
        {
            if (w[0][0] != 'W')
                return (1);
        }
        else if (i == 2 && j == 2)
        {
            if (w[0][2] != 'W')
                return (1);
        }
        return (0);

    }


    public static void locationTwo(StructureSides rubik)
    {
        if (rubik.blue[0][2] == 'W')
        {
            startTwo(rubik, 'B', 2,2);
        }
        if (rubik.red[0][2] == 'W')
        {
            startTwo(rubik, 'R',0 ,2);
        }
        if (rubik.green[0][2] == 'W')
        {
            startTwo(rubik, 'G',0 ,0);
        }
        if (rubik.orange[0][2] == 'W')
        {
            startTwo(rubik, 'O', 2,0);
        }

    }

    public static void startTwo(StructureSides rubik, char e, int iy, int jy)
    {
        int n;
        char e2;

        e2 = rubik.yellow[iy][jy];
        n = nRevolutions(e, e2);

        if (n == 2)
        {
            Presentation.Moves(e, 'U', rubik);
            Presentation.Moves(e, 'U', rubik);
            Presentation.Moves(e, 'U', rubik);

        }
        else if (n == -1) {
            Presentation.Moves(e, 'U', rubik);
            Presentation.Moves(e, 'U', rubik);
        }
        else if (n == 1) {
            Presentation.Moves(e, 'u', rubik);
            Presentation.Moves(e, 'U', rubik);
        }

        Presentation.Moves(e2, 'R', rubik);
        Presentation.Moves(e2, 'u', rubik);
        Presentation.Moves(e2, 'r', rubik);
    }




    public static void locationOne(StructureSides rubik)
    {
        if (rubik.blue[0][0] == 'W')
        {
            startOne(rubik, 'B', 2,0);
        }
        if (rubik.red[0][0] == 'W')
        {
            startOne(rubik, 'R',2 ,2);
        }
        if (rubik.green[0][0] == 'W')
        {
            startOne(rubik, 'G',0 ,2);
        }
        if (rubik.orange[0][0] == 'W')
        {
            startOne(rubik, 'O', 0,0);
        }

    }

    public static void startOne(StructureSides rubik, char e, int iy, int jy)
    {
        int n;
        char e2;

        e2 = rubik.yellow[iy][jy];
        n = nRevolutions(e, e2);

        if (n == 2)
        {
            Presentation.Moves(e, 'U', rubik);
            Presentation.Moves(e, 'U', rubik);
        }
        else if (n == -1)
            Presentation.Moves(e, 'U', rubik);
        else if (n == 1)
            Presentation.Moves(e, 'u', rubik);
        Presentation.Moves(e2, 'F', rubik);
        Presentation.Moves(e2, 'U', rubik);
        Presentation.Moves(e2, 'f', rubik);
    }





    public static int nRevolutions(char e1, char e2)
    {
        if (e1 == 'B')
        {
            if (e2 == 'B')
                return (0);
            else if (e2 == 'G')
                return (2);
            else if (e2 == 'R')
                return (1);
            else if (e2 == 'O')
                return (-1);
        }
        else if (e1 == 'R')
        {
            if (e2 == 'R')
                return (0);
            else if (e2 == 'O')
                return (2);
            else if (e2 == 'G')
                return (1);
            else if (e2 == 'B')
                return (-1);
        }
        else if (e1 == 'G')
        {
            if (e2 == 'G')
                return (0);
            else if (e2 == 'B')
                return (2);
            else if (e2 == 'O')
                return (1);
            else if (e2 == 'R')
                return (-1);
        }
        else if (e1 == 'O')
        {
            if (e2 == 'O')
                return (0);
            else if (e2 == 'R')
                return (2);
            else if (e2 == 'B')
                return (1);
            else if (e2 == 'G')
                return (-1);
        }
        return (0);
    }



    public static int theCycle(char e)
    {
        if (e == 'B')
            return (2);
        else if (e == 'R')
            return (3);
        else if (e == 'G')
            return (4);
        else if (e == 'O')
            return (1);
        return (1);
    }



}
