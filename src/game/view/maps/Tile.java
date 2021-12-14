package game.view.maps;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tile extends JLabel
{
	//Colors
	public static final Color UNEXPLORED = Color.BLACK;
	public static final Color SHORE = new Color(14, 114, 150);
	public static final Color ICE = new Color(150, 173, 212);
	public static final Color OCEAN = new Color(3, 7, 84);
	public static final Color FERTILE = new Color(47, 89, 19);
	public static final Color DESERT = new Color(163, 152, 95);
	
	private Color color;
	private ImageIcon icon;
	private boolean isExplored;
	
	public Tile(String index)
	{
		super(index);
		this.color = UNEXPLORED;
		this.isExplored = false;
		this.setBackground(color);
		
		this.setHorizontalAlignment(CENTER);
		this.setVerticalAlignment(CENTER);
		
		this.setVisible(true);
		this.setOpaque(true);
	}
	
	public void setColor(Color color)
	{
		this.color = color;
		updateExplored();
	}
	
	public Color getColor()
	{
		return this.color;
	}
	
	public void setIcon()
	{
		
	}
	
	public void setExplored(boolean isExplored)
	{
		this.isExplored = isExplored;
	}
	
	public boolean isExplored()
	{
		return this.isExplored;
	}
	
	public void updateExplored()
	{
		if(this.isExplored())
		{
			this.setBackground(color);
		}
		else
		{
			this.setBackground(UNEXPLORED);
		}
	}
}
