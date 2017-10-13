import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClockPane extends JPanel
{
	public DigitalClockPane()
	{
		this.addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent e)
			{
				super.componentResized(e);

				setFont(getFont().deriveFont(getHeight() / 2.0f));
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		String time = getCurrentTimeAsString();

		FontMetrics fm = g.getFontMetrics();
		g.drawString(time, (this.getWidth() - fm.stringWidth(time)) / 2,
		             (fm.getAscent() + (this.getHeight() - (fm.getAscent() + fm.getDescent())) / 2));
	}

	private String getCurrentTimeAsString()
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(date);
	}
}
