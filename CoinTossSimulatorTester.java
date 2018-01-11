/* NAME: Kevin Le
 * September 2016 
 */


import java.util.Scanner;

	/*
	 * class CoinTossSimulatorTester
	 * 
	 * Tests CoinTossSimulator to see if it is working properly
	 * 
	 */

public class CoinTossSimulatorTester {

	static Scanner in = new Scanner(System.in);
	

	public static void main(String[] args) {

		CoinTossSimulator CoinTossTest = new CoinTossSimulator(); // calls CoinTossSimulator

		String runResponse = "yes"; // initializes the simulation run
		int resetTicker = 0; // initializes the reset ticker
		
		/*
		 * when while loop is active, user is prompted for input and then run simulation
		 */
		while (runResponse.equals("yes")) {

			int number = checkNumber();

			/*
			 * while loop repeats error message and prompts for a new number input as long as number is less than 0
			 */
			while (number < 0) {
				System.out.println("ERROR: Number entered must be greater than or equal to 0.");
				in.nextLine();
				number = checkNumber();
			}

			/*
			 * run random simulation from number input and display results
			 */
			
			CoinTossTest.run(number); 
			

			if (number == 0 && resetTicker == 0) {
				System.out.println("After constructor: ");
			} else if (number == 0 && resetTicker >= 0) {
				System.out.println("After reset: ");
			} else {
				System.out.println("After run (" + number + ") ");
			}

			System.out.println("Number of trials: " + CoinTossTest.getNumTrials());
			System.out.println("Two-head Tosses: " + CoinTossTest.getTwoHeads());
			System.out.println("Two-tail Tosses: " + CoinTossTest.getTwoTails());
			System.out.println("One-head one-tail tosses: " + CoinTossTest.getHeadTails());

			
			/*
			 * adds simulation results and compares to total from getNumTrials() method 
			 * if results match, then response is true
			 */
			int CoinTossTrialSum = CoinTossTest.getTwoHeads() + CoinTossTest.getTwoTails()
			+ CoinTossTest.getHeadTails();
	
			if (CoinTossTrialSum == CoinTossTest.getNumTrials()) {
				System.out.println("Tosses add up correctly? True");
			} else {
				System.out.println("Tosses add up correctly? False");
			}

			/*
			 * Prompts user if he wants to run the simulation again. If yes, run the user prompt and simulation again
			 * Prompts user if he wants to reset the simulation. If yes, reset current simulation results and increment the reset ticker 
			 */
			
			System.out.println();
			System.out.println("Run Again? (yes/no)");
			runResponse = in.next();
			System.out.println("Reset? (yes/no)");
			String resetResponse = in.next();
			if (resetResponse.equals("yes")) {

				CoinTossTest.reset();
				resetTicker++;
			}

		}

	}

	/*
	 * checkNumber class
	 * 
	 * Prompts input for number of trials user wants to simulate
	 * 	@return number
	 * 		where number is number of trials user inputs
	 */
	
	public static int checkNumber() {
		System.out.print("Enter number of trials: ");
		return in.nextInt();
	}

}
