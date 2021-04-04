package skydive_calc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Component;

public class MainWindow extends JFrame
{
	private static final long serialVersionUID = 1L;
	String map = "src/skydive_calc/map.png";
	ImageIcon clearMap;
	ImageIcon anchorMap;
	ImageIcon solidsMap;
	ImageIcon shardMap;
	
	public MainWindow() 
	{
		initMapImages();
		setupUI();
	}
	
	private void initMapImages()
	{
		int width = 812;
		int height = 908;
		int scaleHint = Image.SCALE_SMOOTH;
		clearMap = new ImageIcon(new ImageIcon("src/skydive_calc/map.png").getImage().getScaledInstance(width, height, scaleHint));
		anchorMap = new ImageIcon(new ImageIcon("src/skydive_calc/anchor_map.png").getImage().getScaledInstance(width, height, scaleHint));
		solidsMap = new ImageIcon(new ImageIcon("src/skydive_calc/solid_map.png").getImage().getScaledInstance(width, height, scaleHint));
		shardMap = new ImageIcon(new ImageIcon("src/skydive_calc/shard_map.png").getImage().getScaledInstance(width, height, scaleHint));
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
	    
	    MapImage imageLabel = new MapImage();
	    imageLabel.setVerticalAlignment(SwingConstants.TOP);
	    mainPanel.add(imageLabel, BorderLayout.LINE_START);
	    imageLabel.setIcon(clearMap);
	    
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
        		imageLabel.setIcon(clearMap);
        	}
        });
	    
	    JButton anchorBtn = new JButton("Anchor Map");
	    optionPanel.add(anchorBtn);
	    anchorBtn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		imageLabel.setIcon(anchorMap);
        	}
        });
	    
	    JButton solidBtn = new JButton("Solids Map");
	    optionPanel.add(solidBtn);
	    solidBtn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		imageLabel.setIcon(solidsMap);
        	}
        });
	    
	    JButton shardBtn = new JButton("Shard Map");
	    optionPanel.add(shardBtn);
	    shardBtn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		imageLabel.setIcon(shardMap);
        	}
        });
	    
	    JButton lineAnchor = new JButton("Anchor Line");
	    optionPanel.add(lineAnchor);
	    lineAnchor.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		imageLabel.setStartLine(359, 603);
        		timeField.setText(calcTime(((MapImage) imageLabel).calcLength()));
        	}
        });
	    
	    JButton lineShard = new JButton("Shard Line");
	    optionPanel.add(lineShard);
	    lineShard.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		imageLabel.setStartLine(420, 122);
        		timeField.setText(calcTime(((MapImage) imageLabel).calcLength()));
        	}
        });
	    
	    imageLabel.addMouseListener(new MouseAdapter() 
	    {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				imageLabel.mouseClicked(e.getX(), e.getY());
				timeField.setText(calcTime((imageLabel.calcLength())));
			}
		});
	    
	}
	
	private String calcTime(int pixelLength)
	{	
		double secPerPixel = 16.5517;
		int hours = 0;
		int minutes = 0;
		//double distance = pixelLength;
		int seconds = (int) (pixelLength * secPerPixel);
		
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
