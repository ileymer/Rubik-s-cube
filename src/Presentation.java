
public class Presentation {

    static public void Moves(char e, char m, StructureSides r) {
        if (e == 'R')
        {
            if (m == 'U')
                r.Up();
            else if (m == 'u')
                r.UpI();
            else if (m == 'D')
                r.Down();
            else if (m == 'd')
                r.DownI();
            else if (m == 'R')
                r.Back();
            else if (m == 'r')
                r.BackI();
            else if (m == 'L')
                r.Front();
            else if (m == 'l')
                r.FrontI();
            else if (m == 'F')
                r.Right();
            else if (m == 'f')
                r.RightI();
            else if (m == 'B')
                r.Left();
            else if (m == 'b')
                r.LeftI();
        }

        if (e == 'G')
        {
            if (m == 'U')
                r.Up();
            else if (m == 'u')
                r.UpI();
            else if (m == 'D')
                r.Down();
            else if (m == 'd')
                r.DownI();
            else if (m == 'R')
                r.Left();
            else if (m == 'r')
                r.LeftI();
            else if (m == 'L')
                r.Right();
            else if (m == 'l')
                r.RightI();
            else if (m == 'F')
                r.Back();
            else if (m == 'f')
                r.BackI();
            else if (m == 'B')
                r.Front();
            else if (m == 'b')
                r.FrontI();
        }

        if (e == 'O')
        {
            if (m == 'U')
                r.Up();
            else if (m == 'u')
                r.UpI();
            else if (m == 'D')
                r.Down();
            else if (m == 'd')
                r.DownI();
            else if (m == 'R')
                r.Front();
            else if (m == 'r')
                r.FrontI();
            else if (m == 'L')
                r.Back();
            else if (m == 'l')
                r.BackI();
            else if (m == 'F')
                r.Left();
            else if (m == 'f')
                r.LeftI();
            else if (m == 'B')
                r.Right();
            else if (m == 'b')
                r.RightI();
        }

        if (e == 'Y')
        {
            if (m == 'U')
                r.Back();
            else if (m == 'u')
                r.BackI();
            else if (m == 'D')
                r.Front();
            else if (m == 'd')
                r.FrontI();
            else if (m == 'R')
                r.Right();
            else if (m == 'r')
                r.RightI();
            else if (m == 'L')
                r.Left();
            else if (m == 'l')
                r.LeftI();
            else if (m == 'F')
                r.Up();
            else if (m == 'f')
                r.UpI();
            else if (m == 'B')
                r.Down();
            else if (m == 'b')
                r.DownI();
        }

        if (e == 'B')
        {
            if (m == 'U')
                r.Up();
            else if (m == 'u')
                r.UpI();
            else if (m == 'D')
                r.Down();
            else if (m == 'd')
                r.DownI();
            else if (m == 'R')
                r.Right();
            else if (m == 'r')
                r.RightI();
            else if (m == 'L')
                r.Left();
            else if (m == 'l')
                r.LeftI();
            else if (m == 'F')
                r.Front();
            else if (m == 'f')
                r.FrontI();
            else if (m == 'B')
                r.Back();
            else if (m == 'b')
                r.BackI();
        }
        r.n++;
        if (Parser.b == 1)
        Rubik.viv(r.n, r.yellow, r.white, r.blue, r.red, r.green, r.orange);
        if (Parser.v == 1 && r.f == 1)
        {
            Rubik.vivLive(r);
            if (Last.assembled(r) != 1)
            Rubik.clearScreen();
        }
    }
}
