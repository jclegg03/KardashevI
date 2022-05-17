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
	/**
	 * The controller this reports to.
	 * @author Jay Clegg
	 */
	private MapController app;
	
	/**
	 * The column this button is in.
	 * @author Jay Clegg
	 */
	private int col;
	
	/**
	 * The map level this tile is on. (Not what it links to)
	 * @author Jay Clegg
	 */
	private String level;
	
	/**
	 * The row the button is located in.
	 * @author Jay Clegg
	 */
	private int row;
	
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
		this.level = level;
		this.row = row;
		this.col = col;
		this.setName("row" + row + "col" + col);
		this.setBorder(null);
		this.setOpaque(false);
		this.setBackground(Color.BLUE);
		
		this.addActionListener(click -> app.tileOptions(this));
	}
	
	public int getCol()
	{
		return col;
	}
	
	public String getLevel()
	{
		return this.level;
	}
	
	public int getRow()
	{
		return row;
	}
}
