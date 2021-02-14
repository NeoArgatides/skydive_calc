package skydive_calc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	    
	    JPanel mainPanel = new JPanel();
	    mainPanel.setSize(screenSize.width, screenSize.height);
	    getContentPane().add(mainPanel);
	    mainPanel.setLayout(new BorderLayout(0, 0));
	    
	    JLabel imageLabel = new JLabel();
	    imageLabel.setVerticalAlignment(SwingConstants.TOP);
	    imageLabel.setIcon(new ImageIcon(new ImageIcon(map).getImage().getScaledInstance(939, mainPanel.getHeight(), Image.SCALE_SMOOTH)));
	    mainPanel.add(imageLabel, BorderLayout.LINE_START);
	    
	    JPanel optionPanel = new JPanel();
	    optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
	    
	}
	
	
}
