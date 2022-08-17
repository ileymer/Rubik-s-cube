
import java.util.ArrayList;

public class StructureSides {
	static char yellow[][] = new char [3][3];
	static char blue[][] = new char [3][3];
	static char white[][] = new char [3][3];
	static char green[][] = new char [3][3];
	static char red[][] = new char [3][3];
	static char orange[][] = new char [3][3];
	static int n = 0;
	static int f;
	static ArrayList<String> list = new ArrayList<String>();


	static public void Up()
	{
		char edge[][] = new char[3][3];
		char c;

		memory(0,  -1, edge, orange);
		memory(0,  -1,orange, blue);
		memory(0,  -1, blue, red);
		memory(0,  -1,red, green);
		memory(0, -1,green, edge);
		c = yellow[0][0];
		yellow[0][0] = yellow[2][0];
		yellow[2][0] = yellow[2][2];
		yellow[2][2] = yellow[0][2];
		yellow[0][2] = c;
		c = yellow[0][1];
		yellow[0][1] = yellow[1][0];
		yellow[1][0] = yellow[2][1];
		yellow[2][1] = yellow[1][2];
		yellow[1][2] = c;


		if (f == 1)
		list.add("U");

	}

	static public void UpI()
	{
		char edge[][] = new char[3][3];
		char c;

		memory(0,  -1, edge, red);
		memory(0,  -1, red, blue);
		memory(0,  -1, blue, orange);
		memory(0,  -1, orange, green);
		memory(0,  -1, green, edge);
		c = yellow[0][0];
		yellow[0][0] = yellow[0][2];
		yellow[0][2] = yellow[2][2];
		yellow[2][2] = yellow[2][0];
		yellow[2][0] = c;
		c = yellow[0][1];
		yellow[0][1] = yellow[1][2];
		yellow[1][2] = yellow[2][1];
		yellow[2][1] = yellow[1][0];
		yellow[1][0] = c;


		if (f == 1)
		list.add("U'");

	}


	static public void Down() {
		char edge[][] = new char[3][3];
		char c;

		memory(2,  -1, edge, red);
		memory(2,  -1, red, blue);
		memory(2,  -1, blue, orange);
		memory(2,  -1, orange, green);
		memory(2,  -1, green, edge);
		c = white[0][0];
		white[0][0] = white[2][0];
		white[2][0] = white[2][2];
		white[2][2] = white[0][2];
		white[0][2] = c;
		c = white[0][1];
		white[0][1] = white[1][0];
		white[1][0] = white[2][1];
		white[2][1] = white[1][2];
		white[1][2] = c;


		if (f == 1)
		list.add("D");

	}

	static public void DownI() {
		char edge[][] = new char[3][3];
		char c;

		memory(2, -1, edge, orange);
		memory(2, -1, orange, blue);
		memory(2, -1, blue, red);
		memory(2, -1, red, green);
		memory(2, -1, green, edge);

		c = white[0][0];
		white[0][0] = white[0][2];
		white[0][2] = white[2][2];
		white[2][2] = white[2][0];
		white[2][0] = c;
		c = white[0][1];
		white[0][1] = white[1][2];
		white[1][2] = white[2][1];
		white[2][1] = white[1][0];
		white[1][0] = c;


		if (f == 1)
		list.add("D'");

	}


	static public void Right()
	{
		char edge[][] = new char[3][3];
		char c;

		memory(-1,  2, edge, blue);
		memory(-1,  2,blue, white);
		white[0][2] = green[2][0];
		white[1][2] = green[1][0];
		white[2][2] = green[0][0];
		green[2][0] = yellow[0][2];
		green[1][0] = yellow[1][2];
		green[0][0] = yellow[2][2];
		memory(-1, 2,yellow, edge);
		c = red[0][0];
		red[0][0] = red[2][0];
		red[2][0] = red[2][2];
		red[2][2] = red[0][2];
		red[0][2] = c;
		c = red[0][1];
		red[0][1] = red[1][0];
		red[1][0] = red[2][1];
		red[2][1] = red[1][2];
		red[1][2] = c;


		if (f == 1)
		list.add("R");

	}

	static public void RightI() {
		char edge[][] = new char[3][3];
		char c;

		memory(-1, 2, edge, blue);
		memory(-1, 2, blue, yellow);
		yellow[0][2] = green[2][0];
		yellow[1][2] = green[1][0];
		yellow[2][2] = green[0][0];
		green[2][0] = white[0][2];
		green[1][0] = white[1][2];
		green[0][0] = white[2][2];
		memory(-1, 2,white, edge);
		c = red[0][0];
		red[0][0] = red[0][2];
		red[0][2] = red[2][2];
		red[2][2] = red[2][0];
		red[2][0] = c;
		c = red[0][1];
		red[0][1] = red[1][2];
		red[1][2] = red[2][1];
		red[2][1] = red[1][0];
		red[1][0] = c;


		if (f == 1)
		list.add("R'");

	}


	static public void Left() {
		char edge[][] = new char[3][3];
		char c;

		memory(-1, 0, edge, blue);
		memory(-1,  0,blue, yellow);
		yellow[0][0] = green[2][2];
		yellow[1][0] = green[1][2];
		yellow[2][0] = green[0][2];
		green[0][2] = white[2][0];
		green[1][2] = white[1][0];
		green[2][2] = white[0][0];
		memory(-1, 0, white, edge);
		c = orange[0][0];
		orange[0][0] = orange[2][0];
		orange[2][0] = orange[2][2];
		orange[2][2] = orange[0][2];
		orange[0][2] = c;
		c = orange[0][1];
		orange[0][1] = orange[1][0];
		orange[1][0] = orange[2][1];
		orange[2][1] = orange[1][2];
		orange[1][2] = c;


		if (f == 1)
		list.add("L");

	}

	static public void LeftI() {
		char edge[][] = new char[3][3];
		char c;

		memory(-1, 0, edge, blue);
		memory(-1,  0,blue, white);
		white[0][0] = green[2][2];
		white[1][0] = green[1][2];
		white[2][0] = green[0][2];
		green[0][2] = yellow[2][0];
		green[1][2] = yellow[1][0];
		green[2][2] = yellow[0][0];
		memory(-1, 0, yellow, edge);
		c = orange[0][0];
		orange[0][0] = orange[0][2];
		orange[0][2] = orange[2][2];
		orange[2][2] = orange[2][0];
		orange[2][0] = c;
		c = orange[0][1];
		orange[0][1] = orange[1][2];
		orange[1][2] = orange[2][1];
		orange[2][1] = orange[1][0];
		orange[1][0] = c;


		if (f == 1)
		list.add("L'");


	}


	static public void Front() {
		char edge[] = new char[3];
		char c;

		edge[0] = yellow[2][0];
		edge[1] = yellow[2][1];
		edge[2] = yellow[2][2];
		yellow[2][0] = orange[2][2];
		yellow[2][1] = orange[1][2];
		yellow[2][2] = orange[0][2];
		orange[0][2] = white[0][0];
		orange[1][2] = white[0][1];
		orange[2][2] = white[0][2];
		white[0][0] = red[2][0];
		white[0][1] = red[1][0];
		white[0][2] = red[0][0];
		red[0][0] = edge[0];
		red[1][0] = edge[1];
		red[2][0] = edge[2];

		c = blue[0][0];
		blue[0][0] = blue[2][0];
		blue[2][0] = blue[2][2];
		blue[2][2] = blue[0][2];
		blue[0][2] = c;
		c = blue[0][1];
		blue[0][1] = blue[1][0];
		blue[1][0] = blue[2][1];
		blue[2][1] = blue[1][2];
		blue[1][2] = c;


		if (f == 1)
		list.add("F");

	}

	static public void FrontI() {
		char edge[] = new char[3];
		char c;

		edge[0] = yellow[2][0];
		edge[1] = yellow[2][1];
		edge[2] = yellow[2][2];


		yellow[2][0] = red[0][0];
		yellow[2][1] = red[1][0];
		yellow[2][2] = red[2][0];
		red[0][0] = white[0][2];;
		red[1][0] = white[0][1];;
		red[2][0] = white[0][0];

		white[0][0] = orange[0][2];
		white[0][1] = orange[1][2];
		white[0][2] = orange[2][2];

		orange[2][2] = edge[0];
		orange[1][2] = edge[1];
		orange[0][2] = edge[2];

		c = blue[0][0];
		blue[0][0] = blue[0][2];
		blue[0][2] = blue[2][2];
		blue[2][2] = blue[2][0];
		blue[2][0] = c;
		c = blue[0][1];
		blue[0][1] = blue[1][2];
		blue[1][2] = blue[2][1];
		blue[2][1] = blue[1][0];
		blue[1][0] = c;


		if (f == 1)
		list.add("F'");

	}

	static public void Back() {
		char edge[] = new char[3];
		char c;

		edge[0] = yellow[0][0];
		edge[1] = yellow[0][1];
		edge[2] = yellow[0][2];

		yellow[0][0] = red[0][2];
		yellow[0][1] = red[1][2];
		yellow[0][2] = red[2][2];

		red[0][2] = white[2][2];
		red[1][2] = white[2][1];
		red[2][2] = white[2][0];

		white[2][0] = orange[0][0];
		white[2][1] = orange[1][0];
		white[2][2] = orange[2][0];

		orange[0][0] = edge[2];
		orange[1][0] = edge[1];
		orange[2][0] = edge[0];

		c = green[0][0];
		green[0][0] = green[2][0];
		green[2][0] = green[2][2];
		green[2][2] = green[0][2];
		green[0][2] = c;
		c = green[0][1];
		green[0][1] = green[1][0];
		green[1][0] = green[2][1];
		green[2][1] = green[1][2];
		green[1][2] = c;

		if (f == 1)
		list.add("B");

	}

	static public void BackI() {
		char edge[] = new char[3];
		char c;

		edge[0] = yellow[0][0];
		edge[1] = yellow[0][1];
		edge[2] = yellow[0][2];

		yellow[0][0] = orange[2][0];
		yellow[0][1] = orange[1][0];
		yellow[0][2] = orange[0][0];

		orange[0][0] = white[2][0];
		orange[1][0] = white[2][1];
		orange[2][0] = white[2][2];

		white[2][0] = red[2][2];
		white[2][1] = red[1][2];
		white[2][2] = red[0][2];

		red[0][2] = edge[0];
		red[1][2] = edge[1];
		red[2][2] = edge[2];


		c = green[0][0];
		green[0][0] = green[0][2];
		green[0][2] = green[2][2];
		green[2][2] = green[2][0];
		green[2][0] = c;
		c = green[0][1];
		green[0][1] = green[1][2];
		green[1][2] = green[2][1];
		green[2][1] = green[1][0];
		green[1][0] = c;

		if (f == 1)
		list.add("B'");

	}









	static public void memory(int i, int j, char [][] edgeCopy, char [][] edgeOrig)
	{
		if (i > -1)
		{
			edgeCopy[i][0] = edgeOrig[i][0];
			edgeCopy[i][1] = edgeOrig[i][1];
			edgeCopy[i][2] = edgeOrig[i][2];
		}
		else if (j > -1) {
			edgeCopy[0][j] = edgeOrig[0][j];
			edgeCopy[1][j] = edgeOrig[1][j];
			edgeCopy[2][j] = edgeOrig[2][j];
		}


	}



}
