import java.awt.*;
import java.util.Calendar;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println(
				Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE));

		Window window = new Window(480, 280);
		window.setLayout(new BorderLayout());
		AnalogClockPane pane = new AnalogClockPane();
		window.add(pane);
		window.setVisible(true);

		try
		{
			while (true)
			{
				window.repaint();
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
