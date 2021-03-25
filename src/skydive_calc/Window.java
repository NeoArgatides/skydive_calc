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
        		((mapImage) imageLabel).calcTime();
        	}
        });
	    
	    JButton lineShard = new JButton("Shard Line");
	    optionPanel.add(lineShard);
	    lineShard.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		((mapImage) imageLabel).setStartLine(420, 122);
        		time.setText("Time: " + ((mapImage) imageLabel).calcTime());
        	}
        });
	    
	    imageLabel.addMouseListener(new MouseAdapter() 
	    {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				((mapImage) imageLabel).mouseClicked(e.getX(), e.getY());
				time.setText("Time: " + ((mapImage) imageLabel).calcTime());
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
		
		public String calcTime()
		{
			String time = "";
			
			length = Math.sqrt(Math.pow(Math.abs(endX - startX), 2) + Math.pow(Math.abs(endY - startY), 2));
			return time;
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
	
}
