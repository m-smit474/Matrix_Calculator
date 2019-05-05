import java.util.*;

public class MatrixMachine {
	static Scanner reader = new Scanner(System.in);                  // Scanner to be used user input throughout the program
	boolean exit = false;

	public static void main(String[] args) {

		MatrixMachine calc = new MatrixMachine();
		calc.runMenu();
		
	}

	public static int getRows() {
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
	
	public static int getColumns() {
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
		System.out.println("What would you like to do? ");
		System.out.println("1) Add");
		System.out.println("2) Multiply");
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
			System.out.println("*** Matrices must be the SAME SIZE to add ***");
			System.out.println("\nFor matrix A");
			int i,j;
			
			i = getRows();
			j = getColumns();
			Matrix A = new Matrix(i,j);
			A.fillMatrix();
			
			System.out.println("\nFor matrix B");
			
			i = getRows();
			j = getColumns();
			Matrix B = new Matrix(i,j);
			B.fillMatrix();
			
			Matrix C = A.add(B);
			
			C.print();
			break;
		case 2:
			System.out.println("Matrices AB must have dimensions MxN and NxJ");
			System.out.println("in order to multiply(columns of A must equal rows of B)\n");
			break;
		default:
			System.out.println("Choice not found\n");                                   // Should never occur as choice is error checked
			break;
		}
	}
}
