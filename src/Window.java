import javax.swing.*;

public class Window extends JFrame
{
	public Window(int width, int height)
	{
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
	}
}
