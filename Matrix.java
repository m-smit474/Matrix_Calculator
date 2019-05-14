import java.util.Scanner;

/*******************************************************************
 * This class represent a matrix
 * 
 * Uses a 2D array to represent the array which consists of rows and
 * columns which cannot be less than 0
 ******************************************************************/
public class Matrix {
	static Scanner reader = new Scanner(System.in);
	
	private int rows;
	private int columns;
	private int table[][];
	
	Matrix(int r, int c){
		if(r >= 0 && c >= 0)
		{
			rows = r;
			columns = c;
		}
		else
		{
			rows = 0;
			columns = 0;
		}
		
		table = new int[rows][columns];
	}
	
	/****************************************************************
	 * Fills every available position in a matrix
	 * 
	 * Will only allocate an integer to a position
	 ***************************************************************/
	public void fillMatrix() {
		int i;              // row
		int j;              // column
		
		for(i = 0; i < table.length; i++)
		{
			System.out.println("Enter row " + (i+1) + " starting from the left: ");
			for(j = 0; j < table[i].length; j++)
			{
				while(!reader.hasNextInt()) {			// Only accepts integers
					System.out.println("Please enter an integer.");
					reader.next();
				}
				table[i][j] = reader.nextInt();
			}
			
		}
	} 
	
	/****************************************************************
	 * Goes through matrix and prints out every element of the 
	 * matrix in its correct position.
	 * 
	 * Does not change matrix
	 ***************************************************************/
	public void  print() {
		int i, j;
		
		for(i = 0; i < table.length; i++)
		{
			for(j = 0; j < table[i].length; j++)
			{
				System.out.print(table[i][j] + " ");
			}
			System.out.print('\n');
		}
	}
	
	/**************************************************************
	 * Adds the elements of two matrices and fills a new matrix
	 * with the results
	 * 
	 * Returns the new matrix
	 * 
	 * Can only be done if the matrix is the same size as the 
	 * matrix being passed
	 *************************************************************/
	public Matrix add(Matrix other) {
		Matrix result;
		int i,j;
		
		if(rows == other.getRows() && columns == other.getColumns())             // Checks that Matrices are the same size
		{
			// do addition
			result = new Matrix(rows, columns);
			int[][] otherTable = other.getTable();
			
			for(i = 0; i < table.length; i++)
			{
				for(j = 0; j < table[i].length; j++)
				{
					result.table[i][j] = table[i][j] + otherTable[i][j];
				}
			}
			
		}
		else
		{
			System.out.println("Matrices were of different size. Returning null matrix.");
			result = new Matrix(0,0);
		}
		
		return result;
	}
	
	/****************************************************************
	 * Does matrix multiplication to create a new array
	 * 
	 * The matrix must have the same number of columns as the number
	 * of rows in the passed matrix
	 ***************************************************************/
	public Matrix multiply(Matrix other) {
		Matrix result;
		int i,j, index;
		
		if(columns == other.getRows())                  // do multiplication
		{
			result = new Matrix(rows, other.getColumns());
			
			for(i = 0; i < result.table.length; i++)                  // Goes through every spot of new matrix
			{
				for(j = 0; j < result.table[i].length; j++)
				{
					for(index = 0; index < columns; index++)
					{
						result.table[i][j] += table[i][index] * other.table[index][j];        // Assumes Matrix is initialized to 0
					}
				}
			}
		}
		else
		{
			System.out.println(columns + " != " + other.getRows() + ",  " +"so Matrices cannot be multiplied");
			result = new Matrix(1,1);
		}
		
		return result;
	}
	
	/************************************************************************
	* The following three methods are simple getters to be used by the client
	*************************************************************************/ 
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public int[][] getTable() {
		return table;
	}

}
