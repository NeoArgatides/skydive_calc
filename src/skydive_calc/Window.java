package skydive_calc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Component;

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
	    
	    JLabel imageLabel = new mapImage();
	    imageLabel.setVerticalAlignment(SwingConstants.TOP);
	    mainPanel.add(imageLabel, BorderLayout.LINE_START);
	    imageLabel.setIcon(new ImageIcon(new ImageIcon(map).getImage().getScaledInstance(812, 908, Image.SCALE_SMOOTH)));
	    
	    JPanel menuPanel = new JPanel();
	    menuPanel.setLayout(new GridLayout(1, 2));
	    mainPanel.add(menuPanel, BorderLayout.LINE_END);
	    
	    JPanel infoPanel = new JPanel();
	    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
	    menuPanel.add(infoPanel);
	    
	    JPanel optionPanel = new JPanel();
	    optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.PAGE_AXIS));
	    menuPanel.add(optionPanel);
	    
	    JLabel time = new JLabel("Time: ");
        time.setHorizontalAlignment(SwingConstants.CENTER);
        time.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	    infoPanel.add(time);
	    
	    JTextField timeField = new JTextField(20);
	    timeField.setMaximumSize(new Dimension(Integer.MAX_VALUE, timeField.getPreferredSize().height));
	    timeField.setText("Click a spot on the map");
	    timeField.setHorizontalAlignment(SwingConstants.CENTER);
	    timeField.setEditable(false);
	    infoPanel.add(timeField);
	    
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
	    
	    JButton lineAnchor = new JButton("Anchor Line");
	    optionPanel.add(lineAnchor);
	    lineAnchor.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		((mapImage) imageLabel).setStartLine(359, 603);
        		timeField.setText(calcTime(((mapImage) imageLabel).calcLength()));
        	}
        });
	    
	    JButton lineShard = new JButton("Shard Line");
	    optionPanel.add(lineShard);
	    lineShard.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		((mapImage) imageLabel).setStartLine(420, 122);
        		timeField.setText(calcTime(((mapImage) imageLabel).calcLength()));
        	}
        });
	    
	    imageLabel.addMouseListener(new MouseAdapter() 
	    {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				((mapImage) imageLabel).mouseClicked(e.getX(), e.getY());
				timeField.setText(calcTime(((mapImage) imageLabel).calcLength()));
			}
		});
	    
	}
	
	class mapImage extends JLabel
	{
		private static final long serialVersionUID = 1L;
		
		int startX = 359;
		int startY = 603;
		int endX = 359;
		int endY = 603;
		double length;
		
		@Override
        protected void paintComponent(Graphics g) 
		{
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.drawLine(startX, startY, endX, endY);
            g.dispose();
        }
		
		public void mouseClicked(int x, int y) 
		{
		    endX = x;
		    endY = y;
		    repaint();
		}
		
		public int calcLength()
		{
			return (int) Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
		}
		
		public void setStartLine(int x, int y)
		{
			startX = x;
			startY = y;
			repaint();
		}
		
		public void setEndLine(int x, int y)
		{
			endX = x;
			endY = y;
			repaint();
		}
	}
	
	private String calcTime(int length)
	{	
		int hours = 0;
		int minutes = 0;
		double distance = length;
		int seconds = (int) (distance * 16.5517);
		
		for(; seconds >= 3600; seconds -= 3600)
		{
			hours++;
		}
		
		for(; seconds >= 60; seconds -= 60)
		{
			minutes++;
		}
		
		return hours + " hours " + minutes + " minutes " + seconds + " seconds";
	}
	
}
