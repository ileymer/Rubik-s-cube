import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rubik {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_ORANGE = "\u001B[91m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void main(String[] args) throws IOException {


    StructureSides r = new StructureSides();
    r.orange[0][0] = 'O'; r.orange[0][1] = 'O'; r.orange[0][2] = 'O'; r.yellow[0][0] = 'Y'; r.yellow[0][1] = 'Y'; r.yellow[0][2] = 'Y'; r.red[0][0] = 'R'; r.red[0][1] = 'R'; r.red[0][2] = 'R';
    r.orange[1][0] = 'O'; r.orange[1][1] = 'O'; r.orange[1][2] = 'O'; r.yellow[1][0] = 'Y'; r.yellow[1][1] = 'Y'; r.yellow[1][2] = 'Y'; r.red[1][0] = 'R'; r.red[1][1] = 'R'; r.red[1][2] = 'R';
    r.orange[2][0] = 'O'; r.orange[2][1] = 'O'; r.orange[2][2] = 'O'; r.yellow[2][0] = 'Y'; r.yellow[2][1] = 'Y'; r.yellow[2][2] = 'Y'; r.red[2][0] = 'R'; r.red[2][1] = 'R'; r.red[2][2] = 'R';
                                                                      r.blue[0][0] = 'B'; r.blue[0][1] = 'B'; r.blue[0][2] = 'B';
                                                                      r.blue[1][0] = 'B'; r.blue[1][1] = 'B'; r.blue[1][2] = 'B';
                                                                      r.blue[2][0] = 'B'; r.blue[2][1] = 'B'; r.blue[2][2] = 'B';
                                                                      r.white[0][0] = 'W'; r.white[0][1] = 'W'; r.white[0][2] = 'W';
                                                                      r.white[1][0] = 'W'; r.white[1][1] = 'W'; r.white[1][2] = 'W';
                                                                      r.white[2][0] = 'W'; r.white[2][1] = 'W'; r.white[2][2] = 'W';
                                                                      r.green[0][0] = 'G'; r.green[0][1] = 'G'; r.green[0][2] = 'G';
                                                                      r.green[1][0] = 'G'; r.green[1][1] = 'G'; r.green[1][2] = 'G';
                                                                      r.green[2][0] = 'G'; r.green[2][1] = 'G'; r.green[2][2] = 'G';



		ArrayList<String> s;


		Parser.parseFlags(args);

		if (Parser.s == 1) {
			readInput(r);
			System.exit(0);
		}

		s = Parser.list;
		r.f = 0;
		orientir(s, r);

		r.f = 1;
		if (Last.assembled(r) != 1)
		assembly(r);
		optimization(r.list);
		if (Parser.b == 1) {
			System.out.println();
			System.out.println();
		}
		System.out.print("Decision: ");
		vivStep(r.list);
		System.out.println();
		if (Parser.b == 0)
		System.out.println("Spins: " + r.list.size());

    }
	public static void clearScreen() {
		try {
			Thread.sleep(120);
		} catch (InterruptedException error) {
			System.out.println("sleep");
		}
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void assembly(StructureSides r)
	{
		if (Parser.b == 1)
		System.out.println(ANSI_PURPLE + "1. Cross on the first layer." + ANSI_RESET);
		CrossYellow.start(r);
		RightCross.start(r);
		if (Parser.b == 1)
		System.out.println(ANSI_PURPLE + "2. Placement of the corners of the first layer (the layer is assembled)." + ANSI_RESET);
		WhiteSide.start(r);
		if (Parser.b == 1)
		System.out.println(ANSI_PURPLE + "3. The edges of the middle layer (the layer is assembled)." + ANSI_RESET);
		TwoLayers.start(r);
		if (Parser.b == 1)
		System.out.println(ANSI_PURPLE + "4. Cross of the third layer." + ANSI_RESET);
		RealCross.start(r);
		if (Parser.b == 1)
		System.out.println(ANSI_PURPLE + "5. Edges of the third layer" + ANSI_RESET);
		YellowEdges.start(r);
		if (Parser.b == 1)
		System.out.println(ANSI_PURPLE + "6. Arrangement of the corners of the third layer." + ANSI_RESET);
		YellowCorners.start(r, 0);
		if (Parser.b == 1)
		System.out.println(ANSI_PURPLE + "7. Correct rotation of the corners of the third layer (the layer is assembled, the cube is assembled)" + ANSI_RESET);
		FullYellow.start(r);
		Last.start(r);
	}




	public static String readLineI(Scanner input) {
		String s = input.nextLine();
		return s;
	}


	public static int readInput(StructureSides r) {
		int i = 0;

		Scanner input = new Scanner(System.in);
		String s = "e";

		while (!s.equals("/"))
		{
			s = readLineI(input);
			orientirSimulator(s, r);
			i++;
		}
		return (0);
	}

	public static void vivStep(ArrayList<String> list) {

		for (String one : list) {
			System.out.print(one + " ");
		}
	}

	public static void optimization(ArrayList<String> list) {
		int i = 0;
		int j;
		String s = "1";
		String ss;
		ArrayList<Integer> n = new ArrayList<>();

		for (String one : list) {
			if (s != "1") {
				if (one == s) {
					list.set(i, one.replace("'", "") + "2");
					s = "1";
					n.add(i - 1);
				}
				else
					s = one;
			}
			else
				s = one;
			i++;
		}
int f = 0;
		for (int q = 0;  q < n.size(); q++)
		{
			i = n.get(q) - f++;
			list.remove(i);
		}
	}

	public static void	orientir(ArrayList<String> str, StructureSides r)
	{
		int i;
		i = 1;

		for (String one : str){

			if (one.equals("U"))
				r.Up();
			if (one.equals("U2")) {
				r.Up();
				r.Up();
			}
			if (one.equals("U'"))
				r.UpI();
			if (one.equals("D"))
				r.Down();
			if (one.equals("D2")) {
				r.Down();
				r.Down();
			}
			if (one.equals("D'"))
				r.DownI();
			if (one.equals("R"))
				r.Right();
			if (one.equals("R2"))
			{
				r.Right();
				r.Right();
			}
			if (one.equals("R'")) {
				r.RightI();
			}
			if (one.equals("L"))
				r.Left();
			if (one.equals("L2")) {
				r.Left();
				r.Left();
			}
			if (one.equals("L'"))
				r.LeftI();
			if (one.equals("F"))
				r.Front();
			if (one.equals("F2")) {
				r.Front();
				r.Front();
			}
			if (one.equals("F'"))
				r.FrontI();
			if (one.equals("B"))
				r.Back();
			if (one.equals("B2"))
			{
				r.Back();
				r.Back();
			}
			if (one.equals("B'"))
				r.BackI();

		}
		r.n = 0;
	}

	public static void	orientirSimulator(String s, StructureSides r)
	{
		int i;
		i = 1;


			if (s.equals("U"))
				r.Up();
			else if (s.equals("U2")) {
				r.Up();
				r.Up();
			}
			else if (s.equals("U'"))
				r.UpI();
			else if (s.equals("D"))
				r.Down();
			else if (s.equals("D2")) {
				r.Down();
				r.Down();
			}
			else if (s.equals("D'"))
				r.DownI();
			else if (s.equals("R"))
				r.Right();
			else if (s.equals("R2"))
			{
				r.Right();
				r.Right();
			}
			else if (s.equals("R'")) {
				r.RightI();
			}
			else if (s.equals("L"))
				r.Left();
			else if (s.equals("L2")) {
				r.Left();
				r.Left();
			}
			else if (s.equals("L'"))
				r.LeftI();
			else if (s.equals("F"))
				r.Front();
			else if (s.equals("F2")) {
				r.Front();
				r.Front();
			}
			else if (s.equals("F'"))
				r.FrontI();
			else if (s.equals("B"))
				r.Back();
			else if (s.equals("B2"))
			{
				r.Back();
				r.Back();
			}
			else if (s.equals("B'"))
				r.BackI();
			else 
			{
				System.out.println("No Command");
				System.exit(0);
			}

			vivLive(r);
		System.out.println();
		System.out.println();

	}


    public static void viv(int ii, char y[][], char w[][], char b[][], char r[][], char g[][], char o[][])
    {
        int i = 0;
        int j;

		System.out.println(ii);
        System.out.println("Yellow"+"\t\t" + "White\t\t"+"Blue\t\t" + "Red\t\t" + "Green\t\t" + "Orange");
        while(i < 3)
        {
	        j = 0;
	        while (j < 3)
		        vivColor(y[i][j++]);
	        System.out.print("\t\t");
	        j = 0;
	        while (j < 3)
		        vivColor(w[i][j++]);
	        System.out.print("\t\t");
	        j = 0;
	        while (j < 3)
		        vivColor(b[i][j++]);
	        System.out.print("\t\t");
	        j = 0;
	        while (j < 3)
		        vivColor(r[i][j++]);
	        System.out.print("\t\t");
	        j = 0;
	        while (j < 3)
		        vivColor(g[i][j++]);
	        System.out.print("\t\t");
	        j = 0;
	        while (j < 3)
		        vivColor(o[i][j++]);
	        System.out.print("\t\t");
	        System.out.println();
			i++;

        }
        System.out.println();
    }

	public static void vivColor(char c)
	{
		if (c == 'R')
			System.out.print(ANSI_RED + '■' + ANSI_RESET);
		if (c == 'B')
			System.out.print(ANSI_BLUE + '■' + ANSI_RESET);
		if (c == 'W')
			System.out.print(ANSI_WHITE + '■' + ANSI_RESET);
		if (c == 'G')
			System.out.print(ANSI_GREEN + '■' + ANSI_RESET);
		if (c == 'Y')
			System.out.print(ANSI_YELLOW + '■' + ANSI_RESET);
		if (c == 'O')
			System.out.print(ANSI_ORANGE + '■' + ANSI_RESET);

	}

	public static String vivColor2(char c)
	{
		if (c == 'R')
			return(ANSI_RED);
		if (c == 'B')
			return(ANSI_BLUE);
		if (c == 'W')
			return(ANSI_WHITE);
		if (c == 'G')
			return(ANSI_GREEN);
		if (c == 'Y')
			return(ANSI_YELLOW);
		if (c == 'O')
			return(ANSI_ORANGE);

		return("ss");
	}

	public static void vivLive(StructureSides r)
	{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		System.out.print("                    ");
		System.out.print(vivColor2(r.yellow[0][0]) + "//// " + ANSI_RESET); System.out.print(vivColor2(r.yellow[0][1]) + "//// " + ANSI_RESET); System.out.print(vivColor2(r.yellow[0][2]) + "////" + ANSI_RESET); System.out.print(vivColor2(r.red[0][2]) + "║" + ANSI_RESET);
		System.out.print("\n                   ");
		System.out.print(vivColor2(r.yellow[1][0]) + "//// " + ANSI_RESET); System.out.print(vivColor2(r.yellow[1][1]) + "//// " + ANSI_RESET); System.out.print(vivColor2(r.yellow[1][2]) + "////" + ANSI_RESET); System.out.print(vivColor2(r.red[0][1]) + "║" + ANSI_RESET); System.out.print(vivColor2(r.red[0][2]) + "║" + ANSI_RESET);
		System.out.print("\n                  ");
		System.out.print(vivColor2(r.yellow[2][0]) + "//// " + ANSI_RESET); System.out.print(vivColor2(r.yellow[2][1]) + "//// " + ANSI_RESET); System.out.print(vivColor2(r.yellow[2][2]) + "////" + ANSI_RESET); System.out.print(vivColor2(r.red[0][0]) + "║" + ANSI_RESET); System.out.print(vivColor2(r.red[0][1]) + "║" + ANSI_RESET); System.out.print(vivColor2(r.red[1][2]) + "║" + ANSI_RESET);
		System.out.print("\n                 ");
		System.out.print(vivColor2(r.blue[0][0]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[0][1]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[0][2]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.red[0][0]) + "║" + ANSI_RESET); System.out.print(vivColor2(r.red[1][1]) + "║" + ANSI_RESET); System.out.print(vivColor2(r.red[1][2]) + "║" + ANSI_RESET);

		System.out.print("\n                 ");
		System.out.print(vivColor2(r.blue[0][0]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[0][1]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[0][2]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.red[1][0]) + "║" + ANSI_RESET); System.out.print(vivColor2(r.red[1][1]) + "║" + ANSI_RESET); System.out.print(vivColor2(r.red[2][2]) + "║" + ANSI_RESET);

		System.out.print("\n                 ");
		System.out.print(vivColor2(r.blue[1][0]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[1][1]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[1][2]) + "|||| " + ANSI_RESET);  System.out.print(vivColor2(r.red[1][0]) + "║" + ANSI_RESET); System.out.print(vivColor2(r.red[2][1]) + "║" + ANSI_RESET); System.out.print(vivColor2(r.red[2][2]) + "║" + ANSI_RESET);

		System.out.print("\n                 ");
		System.out.print(vivColor2(r.blue[1][0]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[1][1]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[1][2]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.red[2][0]) + "║" + ANSI_RESET); System.out.print(vivColor2(r.red[2][1]) + "║" + ANSI_RESET);

		System.out.print("\n                 ");
		System.out.print(vivColor2(r.blue[2][0]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[2][1]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[2][2]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.red[2][0]) + "║" + ANSI_RESET);
		System.out.print("\n                 ");
		System.out.print(vivColor2(r.blue[2][0]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[2][1]) + "|||| " + ANSI_RESET); System.out.print(vivColor2(r.blue[2][2]) + "|||| " + ANSI_RESET);
		System.out.println();
		System.out.println();


	}



}

