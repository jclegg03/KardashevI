package game.view.maps;

import java.awt.Color;

import game.controller.MapController;
import gui.utility.JButton;

/**
 * A visual representation of a map tile. A piece on the map's grid.
 * @author Jay Clegg
 *
 */
public class Tile extends JButton
{	
	private MapController app;
	private boolean isExplored;
	private int[] location;
	private String level;
	
	/**
	 * Builds the tile object.
	 * @author Jay Clegg
	 * @param app The game controller.
	 * @param row Which row this tile is in.
	 * @param col Which column this tile is in.
	 */
	public Tile(MapController app, int row, int col, String level)
	{
		super();
		this.app = app;
		this.isExplored = false;
		this.location = new int[2];
		this.level = level;
		location[0] = row;
		location[1] = col;
		this.setName("row" + row + "col" + col);
		this.setBorder(null);
		this.setOpaque(false);
		this.setBackground(Color.BLUE);
		
		this.addActionListener(click -> app.tileOptions(this));
	}

	/**
	 * Sets this tile to be explored and updates the opaque value.
	 * @author Jay Clegg
	 * @param isExplored Whether or not the tile has been explored.
	 */
	public void setIsExplored(boolean isExplored)
	{
		this.isExplored = isExplored;
		this.setOpaque(isExplored);
	}
	
	/**
	 * Gets the value of isExplored.
	 * @author Jay Clegg
	 * @return Whether or not the tile has been explored.
	 */
	public boolean getIsExplored()
	{
		return this.isExplored;
	}
	
	public int[] getMapLocation()
	{
		return this.location;
	}
	
	public String getLevel()
	{
		return this.level;
	}
}
