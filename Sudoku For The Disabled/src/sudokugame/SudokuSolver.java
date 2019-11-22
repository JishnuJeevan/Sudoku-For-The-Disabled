package sudokugame;

// This class is used to solve the sudoku.
// When the user clicks the check button in the game, it will take all the contents of the sudoku grid and will check if it is correct.

// First we will insert a few random numbers into random cells. 
// Then we will call this class to solve the sudoku.
// We will then remove a few cells, and present that to user as the sudoku for them to solve.
// We will save the solution in an sqlite file and use that to check how the user did.

// I have take this code from this repository - https://github.com/murat-aka/Sudoku/blob/master/src/sudoku/Sudoku.java

public class SudokuSolver 
{
	private static boolean make=false;
	private static int[][] matrix=new int[9][9];
	
	// Solving function
	public static boolean startSolving(int [][] userGrid)
    {
		//int[][] matrix = parseProblem(args); sending the character matrix
    	matrix = userGrid;	// Takes the user grid
    	writeMatrix(matrix);
    	if (solve(0,0,matrix))    // solves in place
    	{
    		make=true;
    		Main.extractSolution(matrix);
    		writeMatrix(matrix);
    	}
        else
        {
        	 make=false;
        	//System.out.println("NONE");
        }
    	return make;
    }

    // To solve a cell
    static boolean solve(int i, int j, int[][] cells)
    {
        if (i == 9) {	i = 0;	if (++j == 9)	return true;	}
       if (cells[i][j] != 0)  // skip filled cells
            return solve(i+1,j,cells);

        for (int val = 1; val <= 9; ++val)
        {
            if (legal(i,j,val,cells)) 
            {
                cells[i][j] = val;
                if (solve(i+1,j,cells))
                    return true;
            }
        }
        cells[i][j] = 0; // reset on backtrack
        return false;
    }

    //Checks if entered number is legal
    static boolean legal(int i, int j, int val, int[][] cells) 
    {
        for (int k = 0; k < 9; ++k)  // row
            if (val == cells[k][j])
                return false;

        for (int k = 0; k < 9; ++k) // col
            if (val == cells[i][k])
                return false;

        int boxRowOffset = (i / 3)*3;
        int boxColOffset = (j / 3)*3;
        for (int k = 0; k < 3; ++k) // box
            for (int m = 0; m < 3; ++m)
                if (val == cells[boxRowOffset+k][boxColOffset+m])
                    return false;

        return true; // no violations, so it's legal
    }

    // Converts string to integer
    static int[][] parseProblem(String[] args)
    {
        int[][] problem = new int[9][9]; // default 0 vals
        for (int n = 0; n < args.length; ++n) {
            int i = Integer.parseInt(args[n].substring(0,1));
            int j = Integer.parseInt(args[n].substring(1,2));
            int val = Integer.parseInt(args[n].substring(2,3));
            problem[i][j] = val;
        }
        return problem;
    }

    //Prints the matrix
    static void writeMatrix(int[][] solution)
    {
        for (int i = 0; i < 9; ++i) 
        {
            if (i % 3 == 0)
                System.out.println(" -----------------------");
            for (int j = 0; j < 9; ++j)
            {
                if (j % 3 == 0) System.out.print("| ");
                System.out.print(solution[i][j] == 0
                                 ? " "
                                 : Integer.toString(solution[i][j]));

                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

}

