/* NAME: Kevin Le
 * September 2016
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

public class Bar {

	private int leftSideBar;
	private int barBottom;
	private int barWidth;
	private int barHeight;
	private Color barColor;
	private String barTitle;

	/**
	 * Creates a labeled bar. 
	 * 
	 * @param bottom
	 *            location of the bottom of the label
	 * @param left
	 *            location of the left side of the bar
	 * @param width
	 *            width of the bar
	 * @param numUnits
	 *            height of the bar in application units
	 * @param unitsPerPixel
	 *            how many application units per pixel for height
	 * @param color
	 *            the color of the bar
	 * @param label
	 *            the label at the bottom of the bar
	 */
	
	public Bar(int bottom, int left, int width, int numUnits, double unitsPerPixel, Color color, String label) {

		barBottom = bottom;
		leftSideBar = left;
		barWidth = width;
		barHeight = numUnits;
		barColor = color;
		barTitle = label;

	}

	/*
	 * Draws and sets the specified positioning and sizing of the bar. 
	 * Fills the bar with specified color.
	 * Creates and sets the specified positioning of the bar label. 
	 */
	public void draw(Graphics2D g2) {


		Rectangle rectangle = new Rectangle(leftSideBar - barWidth / 2, barBottom - barHeight, barWidth, barHeight);
		g2.setColor(barColor);
		g2.draw(rectangle);
		g2.fill(rectangle);


		Font font = g2.getFont();
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D labelBounds = font.getStringBounds(barTitle, context);
		int widthOfLabel = (int) labelBounds.getWidth();
		int heightOfLabel = (int) labelBounds.getHeight();
		g2.setColor(Color.BLACK);
		g2.drawString(barTitle, leftSideBar - widthOfLabel / 2, barBottom + heightOfLabel);

	}
}