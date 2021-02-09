package skydive_calc;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame
{
	private static final long serialVersionUID = 1L;
	String map = "map.png";
	
	public Window() 
	{
		setupUI();
	}
	
	private void setupUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setSize(screenSize.width, screenSize.height);
	    
	    add(imagePanel);
	}
	
	JPanel imagePanel = new JPanel()
	{
	    public void paintComponent(Graphics g)
	    {
	    	
	    }
	};
}
