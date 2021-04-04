package skydive_calc;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

class MapImage extends JLabel
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