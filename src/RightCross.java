

public class RightCross {
    static public void start(StructureSides rubik)
    {
        while (rubik.blue[1][1] != rubik.blue[0][1]  || rubik.yellow[2][1] != 'W')
            Presentation.Moves('B', 'U', rubik);
        Presentation.Moves('B', 'F', rubik);
        Presentation.Moves('B', 'F', rubik);

        while (rubik.red[1][1] != rubik.red[0][1] || rubik.yellow[1][2] != 'W')
            Presentation.Moves('R', 'U', rubik);
        Presentation.Moves('R', 'F', rubik);
        Presentation.Moves('R', 'F', rubik);

        while (rubik.green[1][1] != rubik.green[0][1]  || rubik.yellow[0][1] != 'W')
            Presentation.Moves('G', 'U', rubik);
        Presentation.Moves('G', 'F', rubik);
        Presentation.Moves('G', 'F', rubik);

        while (rubik.orange[1][1] != rubik.orange[0][1] || rubik.yellow[1][0] != 'W')
            Presentation.Moves('O', 'U', rubik);
        Presentation.Moves('O', 'F', rubik);
        Presentation.Moves('O', 'F', rubik);
    }


}
