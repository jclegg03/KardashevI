package game.view.maps;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import game.controller.MapController;

/**
 * The base class for each visible map level.
 * @author Jay Clegg
 *
 */
public abstract class Map extends JPanel
{
	protected String name;
	protected MapController app;
	protected GridLayout layout;
	protected String level;
	
	/**
	 * Builds the visible map.
	 * @param app The controller this reports to.
	 * @param rows The number of rows of tiles.
	 * @param cols The number of columns of tiles.
	 * @param level The level of this map. (One of the MapController constants)
	 * @author Jay Clegg
	 */
	public Map(MapController app, int rows, int cols, String level)
	{
		this.app = app;
		this.layout = new GridLayout(rows, cols, 1, 1);
		this.level = level;
		
		this.setLayout(layout);
		
		for(int row = 0; row < rows; row++)
		{
			for(int col = 0; col < cols; col++)
			{
				Tile tile = new Tile(app, row, col, level);
				this.add(tile);
			}
		}
		
		this.setBackground(Color.BLACK);
	}
	
	/**
	 * 
	 * @author Jay Clegg
	 * @param row The row of the desired tile.
	 * @param col The column of the desired tile.
	 * @return
	 */
	public Tile getTile(int row, int col)
	{
		for(Component component : this.getComponents())
		{
			if(component.getName().equals("row" + row + "col" + col))
			{
				return (Tile) component;
			}
		}
		
		return null;
	}
	
	public String getLevel()
	{
		return this.level;
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Returns all the tiles in a 2D array.
	 * @author Jay Clegg
	 * @return All the tiles in this map as a 2D array.
	 */
	public Tile[][] getTiles2D()
	{
		Tile[][] tiles = new Tile[layout.getRows()][layout.getColumns()];
		
		for(int row = 0; row < tiles.length; row++)
		{
			for(int col = 0; col < tiles[row].length; col++)
			{
				tiles[row][col] = getTile(row, col);
			}
		}
		
		return tiles;
	}
	
	/**
	 * Returns a 1D array of all tiles in this map.
	 * @author Jay Clegg
	 * @return An array of all the tiles in this map.
	 */
	public Tile[] getTiles()
	{
		Tile[][] tiles = getTiles2D();
		Tile[] linearTiles = new Tile[tiles.length * tiles[0].length];
		int index = 0;
		
		for(Tile[] row : tiles)
		{
			for(Tile tile : row)
			{
				linearTiles[index] = tile;
				index++;
			}
		}
		return linearTiles;
	}
}
