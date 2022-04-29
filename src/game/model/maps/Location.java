package game.model.maps;

import game.controller.MapController;
import game.model.biomes.Biome;
import game.model.units.Building;

/**
 * A location on an empire map. Used as a key to find the associated lower level map.
 * @author Jay Clegg
 *
 */
public class Location
{
	private int row;
	private int col;
	private int state;
	private Biome biome;
	private Building building;
	
	/**
	 * Builds a location key.
	 * @author Jay Clegg
	 * @param row The row of the key.
	 * @param col The column of the key.
	 */
	public Location(int row, int col)
	{
		this.row = row;
		this.col = col;
		this.state = MapController.UNEXPLORED;
		this.biome = null;
		this.building = null;
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
		return row;
	}

	public int getCol()
	{
		return col;
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
