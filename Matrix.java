import java.util.Scanner;

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
