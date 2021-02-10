package skydive_calc;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Window extends JFrame
{
	private static final long serialVersionUID = 1L;
	String map = "src/skydive_calc/map.png";
	
	public Window() 
	{
		setupUI();
	}
	
	private void setupUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setSize(screenSize.width, screenSize.height);
	    
	    int width = (int)Math.round(screenSize.height * (203/227));
	    JLabel imageLabel = new JLabel();
	    imageLabel.setIcon(new ImageIcon(new ImageIcon(map).getImage().getScaledInstance(939, screenSize.height, Image.SCALE_DEFAULT)));
	    add(imageLabel);
	}
}
