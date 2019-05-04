import java.util.Scanner;

public class Matrix {
	
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
	
	public void fillMatrix(Scanner reader) {
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
		
		if(rows == other.getRows() && columns == other.getColumns()) 
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
			System.out.println("Matricies were of different size. Returning null matrix.");
			result = new Matrix(0,0);
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
