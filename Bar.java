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

	public Bar(int bottom, int left, int width, int numUnits, double unitsPerPixel, Color color, String label) {
		barBottom = bottom;
		leftSideBar = left;
		barWidth = width;
		barHeight = numUnits;
		barColor = color;
		barTitle = label;
	}

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