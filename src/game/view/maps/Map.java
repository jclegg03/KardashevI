package game.view.maps;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import game.controller.MapController;

/**
 * The base class for each map level.
 * @author Jay Clegg
 *
 */
public abstract class Map extends JPanel
{
	protected String id;
	protected MapController app;
	protected GridLayout layout;
	
	public Map(MapController app, int rows, int cols)
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
	}
	
	protected Tile getTile(int row, int col)
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
	
	public void exploreTile(int row, int col)
	{
		try
		{
			getTile(row, col).setIsExplored(true);
		}
		catch(NullPointerException doesNotExist)
		{
			System.out.println("tile doesn't exist");
		}
	}
}
