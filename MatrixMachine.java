import java.util.*;


public class MatrixMachine {
	boolean exit = false;

	public static void main(String[] args) {

		MatrixMachine calc = new MatrixMachine();
		calc.runMenu();
/*		
		int i;                    // rows
		int j;                    // columns
		
		// Read size of Matrix from user (Must be greater than 0)
		Scanner reader =  new Scanner(System.in);

		i = getRows(reader);
		j = getColumns(reader);
		
		Matrix test = new Matrix(i,j);
		test.fillMatrix(reader);

		i = getRows(reader);
		j = getColumns(reader);
		
		Matrix B = new Matrix(i,j);
		B.fillMatrix(reader);
		
		Matrix C = test.add(B);
		
		test.print();
		System.out.print("\n");
		B.print();
		System.out.print("\n");
		C.print();
		
		reader.close();
*/		
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
	
	private int getChoice() {
		int choice = -1;
		Scanner reader = new Scanner(System.in);
		
		while(choice < 0 || choice > 2)
		{
			try {
				System.out.println("\nEnter your choice: ");
				choice = Integer.parseInt(reader.nextLine());
			} catch(NumberFormatException ex) {
				System.out.println("Invalid selection; please select an integer.");
			}
		}
		return choice;
	}
	
	public void runMenu() {
		printHeader();
		while(!exit) 
		{
			printMenu();
			int choice = getChoice();
			performAction(choice);
		}
	}

	private void printHeader() {
		System.out.println("+--------------------------------------------+");
		System.out.println("|            Welcome to Smit's               |");
		System.out.println("|            Matrix Calculator               |");
		System.out.println("+--------------------------------------------+");
	}
	
	private void printMenu() {
		System.out.println("Please make a selection: ");
		System.out.println("1) Add matricies");
		System.out.println("2) Multiply matricies");
		System.out.println("0) Exit");
	}
	
	private void performAction(int choice) {
		switch(choice)
		{
		case 0:
			exit = true;
			System.out.println("Thank you for using Smit's Matrix Calculator!");
			break;
		case 1:
			System.out.println("MATRICIES MUST BE SAME SIZE TO ADD\n");
			System.out.println("\nFor matrix A");
			int i,j;
			Scanner reader = new Scanner(System.in);
			
			i = getRows(reader);
			j = getColumns(reader);
			Matrix A = new Matrix(i,j);
			A.fillMatrix(reader);
			
			System.out.println("\nFor matrix B");
			
			i = getRows(reader);
			j = getColumns(reader);
			Matrix B = new Matrix(i,j);
			B.fillMatrix(reader);
			
			Matrix C = A.add(B);
			
			C.print();
			break;
		case 2:
			System.out.println("Matricies AB must have dimensions MxN and NxJ");
			System.out.println("in order to multiply(columns of A must equal rows of B)\n");
			break;
		default:
			System.out.println("Choice not found\n");
			break;
		}
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
