/* NAME: Kevin Le
 * September 2016 
 */


/**
 * class CoinTossSimulator
 * 
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
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

	/**
	 * Creates a coin toss simulator with no trials done yet.
	 */
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
	 * 
	 * @param numTrials
	 *            number of trials to for simulation; must be >= 0
	 */
	public void run(int numTrials) {

		int heads = 0;
		for (int trialCount = 1; trialCount <= numTrials; trialCount++) {
			for (int flip = 1; flip <= 2; flip++) {

				faceResult = generator.nextInt(2);

				if (faceResult == 0) {
					heads++;
				}

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

	/**
	 * Get number of trials performed since last reset.
	 */
	public int getNumTrials() {
		return totalNumTrials;
	}

	/**
	 * Get number of trials that came up two heads since last reset.
	 */
	public int getTwoHeads() {
		return twoHeads;
	}

	/**
	 * Get number of trials that came up two tails since last reset.
	 */
	public int getTwoTails() {
		return twoTails;
	}

	/**
	 * Get number of trials that came up one head and one tail since last reset.
	 */
	public int getHeadTails() {
		return headsTails;
	}

	/**
	 * Resets the simulation, so that subsequent runs start from 0 trials done.
	 */
	public void reset() {
		totalNumTrials = 0;
		twoHeads = 0;
		twoTails = 0;
		headsTails = 0;
	}

}