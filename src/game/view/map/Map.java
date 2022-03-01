package game.view.map;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import game.controller.Controller;
import gui.utility.JButton;

/**
 * The base class for each map level.
 * @author Jay Clegg
 *
 */
public class Map extends JPanel
{
	protected Controller app;
	protected GridLayout layout;
	
	public Map(Controller app, int rows, int cols)
	{
		this.app = app;
		this.layout = new GridLayout(rows, cols, 1, 1);
		this.setLayout(layout);
		
		for(int row = 0; row < rows; row++)
		{
			for(int col = 0; col < cols; col++)
			{
				Tile tile = new Tile(app, row, col);
				
				this.add(tile);
			}
		}
		
		this.setBackground(Color.BLACK);
		
		getTile(1, 1).setIsExplored(true);
	}
	
	private Tile getTile(int row, int col)
	{
		for(Component component : this.getComponents())
		{
			if(component.getName().equals("row " + row + " col " + col))
			{
				return (Tile) component;
			}
		}
		
		return null;
	}
	
	public void explore(int row, int col)
	{
		getTile(row, col).setIsExplored(true);
	}
}
