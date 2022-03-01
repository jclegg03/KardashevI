package game.view.map;

import java.awt.Color;

import game.controller.Controller;
import gui.utility.JButton;

/**
 * Each map tile is made of one of these.
 * @author Jay Clegg
 *
 */
public class Tile extends JButton
{	
	private Controller app;
	private boolean isExplored;
	
	/**
	 * Builds the tile object.
	 * @author Jay Clegg
	 * @param app The game controller.
	 * @param row Which row this tile is in.
	 * @param col Which column this tile is in.
	 */
	public Tile(Controller app, int row, int col)
	{
		super();
		this.app = app;
		this.isExplored = false;
		this.setName("row " + row + " col " + col);
		this.setBorder(null);
		this.setOpaque(true);
		this.setBackground(Color.BLUE);
		
		this.addActionListener(click -> app.buildBuilding(this));
	}

	/**
	 * Sets this tile to be explored and updates the opaque value.
	 * @author Jay Clegg
	 * @param isExplored Whether or not the tile has been explored.
	 */
	public void setIsExplored(boolean isExplored)
	{
		this.isExplored = isExplored;
		this.setOpaque(! isExplored);
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
}
