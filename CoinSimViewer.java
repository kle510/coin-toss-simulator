import javax.swing.JFrame;

public class CoinSimViewer {
	public static void main(String[] args) {

		System.out.print("Enter number of trials: ");

		JFrame frame = new JFrame();

		frame.setSize(800, 500);
		frame.setTitle("Coin Simulator Viewer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CoinSimComponent component = new CoinSimComponent();
		frame.add(component);
		frame.setVisible(true);
	}
}
