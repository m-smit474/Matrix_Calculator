import java.util.*;


public class MatrixMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i;                    // rows
		int j;                    // columns
		
		// Read size of Matrix from user (Must be greater than 0)
		Scanner reader =  new Scanner(System.in);

		i = getRows(reader);
		j = getColumns(reader);
		
		Matrix test = new Matrix(i,j);
		test.fillMatrix(reader);
		
		reader.close();
	}

	public static int getRows(Scanner reader) {
		int i;
		i = -1;
		while(i <= 0)
		{
			System.out.println("Enter number of rows: ");
			try{
				i = reader.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Invalid number of rows; please enter an integer.");
				reader.next();
			}
		}
		return i;
	}
	
	public static int getColumns(Scanner reader) {
		int j;
		j = -1;
		while(j < 0)
		{
			System.out.println("Enter number of columns: ");
			try{
				j = reader.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Invalid number of columns; please enter an integer.");
				reader.next();
			}
		}
		return j;
	}
}

class Matrix {
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
	
	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
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
					reader.next();
				}
				table[i][j] = reader.nextInt();
			}
			
		}
		
	} 
	
}
