package skydive_calc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	    mainPanel.add(imageLabel, BorderLayout.LINE_START);
	    imageLabel.setIcon(new ImageIcon(new ImageIcon(map).getImage().getScaledInstance(812, 908, Image.SCALE_SMOOTH)));
	    
	    JPanel optionPanel = new JPanel();
	    optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
	    mainPanel.add(optionPanel, BorderLayout.LINE_END);
	    
	    JButton mapBtn = new JButton("Clear Map");
	    optionPanel.add(mapBtn);
	    mapBtn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		map = "src/skydive_calc/map.png";
        		imageLabel.setIcon(new ImageIcon(new ImageIcon(map).getImage().getScaledInstance(812, 908, Image.SCALE_SMOOTH)));
        	}
        });
	    
	    JButton anchorBtn = new JButton("Anchor Map");
	    optionPanel.add(anchorBtn);
	    anchorBtn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		map = "src/skydive_calc/anchor_map.png";
        		imageLabel.setIcon(new ImageIcon(new ImageIcon(map).getImage().getScaledInstance(812, 908, Image.SCALE_SMOOTH)));
        	}
        });
	    
	    JButton solidBtn = new JButton("Solids Map");
	    optionPanel.add(solidBtn);
	    solidBtn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		map = "src/skydive_calc/solid_map.png";
        		imageLabel.setIcon(new ImageIcon(new ImageIcon(map).getImage().getScaledInstance(812, 908, Image.SCALE_SMOOTH)));
        	}
        });
	    
	    JButton shardBtn = new JButton("Shard Map");
	    optionPanel.add(shardBtn);
	    shardBtn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		map = "src/skydive_calc/shard_map.png";
        		imageLabel.setIcon(new ImageIcon(new ImageIcon(map).getImage().getScaledInstance(812, 908, Image.SCALE_SMOOTH)));
        	}
        });
	    
	}
	
	
}
