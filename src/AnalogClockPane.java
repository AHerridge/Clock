import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Date;

public class AnalogClockPane extends JPanel
{
	private int smallestDimension;

	public AnalogClockPane()
	{
		this.setBackground(Color.BLACK);

		this.addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent e)
			{
				super.componentResized(e);

				smallestDimension = Math.min(getWidth(), getHeight());
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Date date = new Date();

		int centerX = getWidth() / 2, centerY = getHeight() / 2;
		g.setColor(Color.WHITE);
		g.drawOval(centerX - smallestDimension / 2, centerY - smallestDimension / 2, smallestDimension,
		           smallestDimension);

		g.setColor(Color.CYAN);
		drawHand(g, smallestDimension / 2, date.getHours() % 12 * 30);

		g.setColor(Color.YELLOW);
		drawHand(g, smallestDimension / 3, date.getMinutes() * 6);

		g.setColor(Color.RED);
		drawHand(g, smallestDimension / 4, date.getSeconds() * 6);
	}

	private void drawHand(Graphics g, double radius, double angle)
	{
		double convertedAngle = Math.toRadians(angle - 90);

		int centerX = getWidth() / 2, centerY = getHeight() / 2;
		g.drawLine(centerX, centerY, centerX + (int) (Math.cos(convertedAngle) * radius),
		           centerY + (int) (Math.sin(convertedAngle) * radius));
	}
}
