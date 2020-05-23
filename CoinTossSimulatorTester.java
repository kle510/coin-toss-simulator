import java.util.Scanner;

public class CoinTossSimulatorTester {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		CoinTossSimulator CoinTossTest = new CoinTossSimulator();

		String runResponse = "yes";
		int resetTicker = 0;

		while (runResponse.equals("yes")) {

			int number = checkNumber();

			while (number < 0) {
				System.out.println("ERROR: Number entered must be greater than or equal to 0.");
				in.nextLine();
				number = checkNumber();
			}

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

			int CoinTossTrialSum = CoinTossTest.getTwoHeads() + CoinTossTest.getTwoTails()
					+ CoinTossTest.getHeadTails();

			if (CoinTossTrialSum == CoinTossTest.getNumTrials()) {
				System.out.println("Tosses add up correctly? True");
			} else {
				System.out.println("Tosses add up correctly? False");
			}

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

	public static int checkNumber() {
		System.out.print("Enter number of trials: ");
		return in.nextInt();
	}
}
