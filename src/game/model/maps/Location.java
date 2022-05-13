package game.model.maps;

import java.io.Serializable;

import game.controller.MapController;
import game.model.biomes.Biome;
import game.model.units.Building;

/**
 * A location on an empire map. Used as a key to find the associated lower level map.
 * @author Jay Clegg
 *
 */
public class Location implements Serializable
{
	/**
	 * The row of this location.
	 * @author Jay Clegg
	 */
	private final int ROW;
	
	/**
	 * The column of this location.
	 * @author Jay Clegg
	 */
	private final int COL;
	
	/**
	 * What this empire knows about this location. One of the MapController constants.
	 * @author Jay Clegg
	 */
	private int state;
	
	/**
	 * The biome of this location.
	 * @author Jay Clegg
	 */
	private Biome biome;
	
	/**
	 * The building on this location.
	 * @author Jay Clegg
	 */
	private Building building;
	
	/**
	 * Builds a location key.
	 * @author Jay Clegg
	 * @param row The row of the key.
	 * @param col The column of the key.
	 */
	public Location(int row, int col, Biome biome, Building building)
	{
		this.ROW = row;
		this.COL = col;
		this.state = MapController.UNEXPLORED;
		this.biome = biome;
		this.building = building;
	}
	
	public int getState()
	{
		return state;
	}
	
	public void setState(int state)
	{
		this.state = state;
	}
	
	public void setBiome(Biome biome)
	{
		this.biome = biome;
	}
	
	public Biome getBiome()
	{
		return biome;
	}
	
	public Building getBuilding()
	{
		return building;
	}
	
	public void setBuilding(Building building)
	{
		this.building = building;
	}
	
	public int getRow()
	{
		return ROW;
	}

	public int getCol()
	{
		return COL;
	}

	@Override
	public boolean equals(Object thing)
	{
		try
		{
			Location other = (Location) thing;
			if(this.getRow() == other.getRow() && this.getCol() == other.getCol())
			{
				return true;
			}
			else return false;
		}
		catch(Exception error)
		{
			return false;
		}
	}
}
