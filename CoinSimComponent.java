import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Scanner;
import javax.swing.JComponent;

/*
 * class CoinSimComponent
 * 
 * Runs the coin toss simulation and draws the bar for each case
 */
public class CoinSimComponent extends JComponent {

	CoinTossSimulator CoinTossTest = new CoinTossSimulator();

	public CoinSimComponent() {

		Scanner in = new Scanner(System.in);
		int number = in.nextInt();

		while (number <= 0) {
			System.out.println("ERROR: Number entered must be greater than 0.");
			in.nextLine();
			System.out.print("Enter number of trials: ");
			number = in.nextInt();
		}
		CoinTossTest.run(number);
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		int resizableBottom = (int) (getHeight() * 0.9);
		int resizableLeftSideBar = getWidth();
		int resizableWidth = (int) (getWidth() * 0.05);

		long bar1Fraction = Math.round(100 * CoinTossTest.getTwoHeads() / CoinTossTest.getNumTrials());
		long bar2Fraction = Math.round(100 * CoinTossTest.getHeadTails() / CoinTossTest.getNumTrials());
		long bar3Fraction = Math.round(100 * CoinTossTest.getTwoTails() / CoinTossTest.getNumTrials());

		int bar1Height = (int) (resizableBottom * bar1Fraction / 100 * 0.9);
		int bar2Height = (int) (resizableBottom * bar2Fraction / 100 * 0.9);
		int bar3Height = (int) (resizableBottom * bar3Fraction / 100 * 0.9);

		// Bar (int bottom, int left, int width, int numUnits, double unitsPerPixel, Color color, String label)
		Bar bar1 = new Bar(resizableBottom, resizableLeftSideBar / 4, resizableWidth, bar1Height, 100, Color.RED,
				"Two Heads: " + CoinTossTest.getTwoHeads() + "(" + bar1Fraction + "%)");
		Bar bar2 = new Bar(resizableBottom, resizableLeftSideBar / 2, resizableWidth, bar2Height, 100, Color.GREEN,
				"One Heads One Tails: " + CoinTossTest.getHeadTails() + "(" + bar2Fraction + "%)");
		Bar bar3 = new Bar(resizableBottom, resizableLeftSideBar * 3 / 4, resizableWidth, bar3Height, 100, Color.BLUE,
				"Two Tails: " + CoinTossTest.getTwoTails() + "(" + bar3Fraction + "%)");
		
		bar1.draw(g2);
		bar2.draw(g2);
		bar3.draw(g2);
	}
}