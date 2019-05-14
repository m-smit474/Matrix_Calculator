import java.util.*;

public class MatrixMachine {
	static Scanner reader = new Scanner(System.in);                  // Scanner to be used user input throughout the program
	boolean exit = false;

	public static void main(String[] args) {

		MatrixMachine calc = new MatrixMachine();
		calc.runMenu();
		
	}
/**********************************************************************
 * This function reads an integer from the user until a valid integer
 * is read
 * 
 * Once a valid(greater than 0) integer is read it returns that integer
 *********************************************************************/
	private int getRows() {
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
/**********************************************************************
 * This function reads an integer from the user until a valid integer
 * is read
 * 
 * Once a valid(greater than 0) integer is read it returns that integer
 *********************************************************************/
	private int getColumns() {
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
/*********************************************************************
 * This functions reads an integer from the user until a valid integer
 * is read
 * 
 * Once one of the options has been selected, the integer is returned
 ********************************************************************/
	private int getChoice() {
		int choice = -1;
		
		while(choice < 0 || choice > 2)
		{
			try {
				System.out.println("Enter your choice: ");
				choice = reader.nextInt();
			} catch(InputMismatchException ex) {
				System.out.println("Invalid selection; please select an integer.");
				reader.next();
			}
		}
		return choice;
	}
	
/*********************************************************************
 * Runs the menu until the user selects exit
 ********************************************************************/
	public void runMenu() {
		printHeader();
		while(!exit) 
		{
			printMenu();
			int choice = getChoice();
			performAction(choice);
		}
	}

/*********************************************************************
 * Prints a nice header message at the begininning of the program
 ********************************************************************/
	private void printHeader() {
		System.out.println("+--------------------------------------------+");
		System.out.println("|            Welcome to Smit's               |");
		System.out.println("|            Matrix Calculator               |");
		System.out.println("+--------------------------------------------+");
	}

/*********************************************************************
 * Prints the menu options
 ********************************************************************/
	private void printMenu() {
		System.out.println("What would you like to do? ");
		System.out.println("1) Add");
		System.out.println("2) Multiply");
		System.out.println("0) Exit");
	}

/*********************************************************************
 * Takes an integer as a parameter which represents a selection
 * 
 * Based on the recieved integer, an action is performed
 * 
 * case 0 - Exit
 * case 1 - Add
 * case 2 - Multiply
 ********************************************************************/
	private void performAction(int choice) {
		int i,j;
		Matrix A, B, C;
		
		switch(choice)
		{
		case 0:
			exit = true;
			System.out.println("Thank you for using Smit's Matrix Calculator!");
			break;
		case 1:
			System.out.println("*** Matrices must be the SAME SIZE to add ***");
			
			System.out.println("\nFor matrix A");
			
			i = getRows();
			j = getColumns();
			A = new Matrix(i,j);
			A.fillMatrix();
			
			System.out.println("\nFor matrix B");
			
			i = getRows();
			j = getColumns();
			B = new Matrix(i,j);
			B.fillMatrix();
			
			C = A.add(B);
			
			System.out.println("The resulting Matrix is:\n");
			C.print();
			System.out.println();
			break;
		case 2:
			System.out.println("Matrices AB must have dimensions MxN and NxJ to multiply");
			System.out.println("(columns of A must equal rows of B)\n");
			
			System.out.println("\nFor matrix A");
			
			i = getRows();
			j = getColumns();
			A = new Matrix(i,j);
			A.fillMatrix();
			
			System.out.println("\nFor matrix B");
			
			i = getRows();
			j = getColumns();
			B = new Matrix(i,j);
			B.fillMatrix();
			
			C = A.multiply(B);
			
			System.out.println("The resulting Matrix is:\n");
			C.print();
			System.out.println();
			break;
		default:
			System.out.println("Choice not found\n");                                   // Should never occur as choice is error checked
			break;
		}
	}
}
