/**
 * class CoinTossSimulator
 * 
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 * 
 */

import java.util.Random;

public class CoinTossSimulator {

	private int faceResult;
	private int twoHeads;
	private int twoTails;
	private int headsTails;
	private int totalNumTrials;
	private Random generator;

	public CoinTossSimulator() {
		totalNumTrials = 0;
		twoHeads = 0;
		twoTails = 0;
		headsTails = 0;
		generator = new Random();
	}

	/**
	 * Runs the simulation for numTrials more trials. Multiple calls to this
	 * without a reset() between them add these trials to the simulation already
	 * completed.
	 */
	public void run(int numTrials) {

		int heads = 0;
		for (int trialCount = 1; trialCount <= numTrials; trialCount++) {
			for (int flip = 1; flip <= 2; flip++) {
				faceResult = generator.nextInt(2);
				if (faceResult == 0)
					heads++;
			}

			if (heads == 2) {
				twoHeads++;
			} else if (heads == 1) {
				headsTails++;
			} else {
				twoTails++;
			}

			heads = 0;
			totalNumTrials++;
		}
	}

	public int getNumTrials() {
		return totalNumTrials;
	}

	public int getTwoHeads() {
		return twoHeads;
	}

	public int getTwoTails() {
		return twoTails;
	}

	public int getHeadTails() {
		return headsTails;
	}

	public void reset() {
		totalNumTrials = 0;
		twoHeads = 0;
		twoTails = 0;
		headsTails = 0;
	}
}