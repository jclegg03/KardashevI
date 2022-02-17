package game.view.map;

import java.awt.Color;

import game.controller.Controller;
import gui.utility.JButton;

public class Tile extends JButton
{	
	private Controller app;
	public Tile(Controller app, int row, int col)
	{
		super();
		this.app = app;
		this.setName("row " + row + " col " + col);
		this.setBorder(null);
		this.setOpaque(true);
		this.setBackground(Color.BLUE);
		
		this.addActionListener(click -> app.build(this));
	}
	
	public void setExplored(boolean isExplored)
	{
		this.setOpaque(! isExplored);
	}
}
