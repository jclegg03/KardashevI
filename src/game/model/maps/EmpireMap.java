package game.model.maps;

import java.io.Serializable;
import java.util.ArrayList;

import game.controller.MapController;
import game.model.biomes.Biome;
import game.model.empire.Empire;
import game.model.units.Building;

/**
 * The base class for all maps in the model.
 * @author Jay Clegg
 *
 */
public abstract class EmpireMap implements Serializable
{
	protected String name;
	protected Location[][] map;
	protected Location location;
	protected String level;
	
	/**
	 * Builds a map with the specified amounts of rows and columns, with an empire owning it.
	 * @param rows The number of rows on the map.
	 * @param cols The number of columns on the map.
	 * @param empire The empire that owns this map.
	 * @author Jay Clegg
	 */
	public EmpireMap(int rows, int cols, Location location, String level)
	{
		this.map = new Location[rows][cols];
		this.location = location;
		this.level = level;
	}
	
	public void setState(int row, int col, int value)
	{
		map[row][col].setState(value);
	}
	
	public void assignLocation(Location location)
	{
		map[location.getRow()][location.getCol()] = location;
	}
	
	
	public int getState(int row, int col)
	{
		return map[row][col].getState();
	}
	
	public Biome getBiome(int row, int col)
	{
		return map[row][col].getBiome();
	}
	
	public Building getBuilding(int row, int col)
	{
		return map[row][col].getBuilding();
	}
	
	public Biome[][] getBiomes2D()
	{
		Biome[][] biomes = new Biome[map.length][map[0].length];
		
		for(int row = 0; row < map.length; row++)
		{
			for(int col = 0; col < map[row].length; col++)
			{
				biomes[row][col] = map[row][col].getBiome();
			}
		}
		
		return biomes;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Location getLocation()
	{
		return this.location;
	}
	
	public Location getLocation(int row, int col)
	{
		try
		{
			return map[row][col];
		}
		catch(ArrayIndexOutOfBoundsException badIndex)
		{
			return null;
		}
	}
	
	public int getRows()
	{
		return this.map.length;
	}
	
	public int getCols()
	{
		return this.map[0].length;
	}
	
	public ArrayList<Location> getLocations()
	{
		ArrayList<Location> locations = new ArrayList<Location>();
		
		for(Location[] row : map)
		{
			for(Location location : row)
			{
				locations.add(location);
			}
		}
		
		return locations;
	}
	
	public boolean getIsFullyExplored()
	{
		for(Location[] locations : map)
		{
			for(Location location : locations)
			{
				if(location.getState() == MapController.UNEXPLORED) return false; 
			}
		}
		
		return true;
	}
	
	public String getLevel()
	{
		return level;
	}
	
	public int[][] getStates2D()
	{
		int[][] states = new int[map.length][map[0].length];
		
		for(int row = 0; row < map.length; row++)
		{
			for(int col = 0; col < map[row].length; col++)
			{
				states[row][col] = map[row][col].getState();
			}
		}
		
		return states;
	}
}
