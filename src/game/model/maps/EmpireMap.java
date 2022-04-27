package game.model.maps;

import java.io.Serializable;
import java.util.ArrayList;

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
	protected Empire empire;
	protected Location location;
	protected Location[][] map;
	
	/**
	 * Builds a map with the specified amounts of rows and columns, with an empire owning it.
	 * @param rows The number of rows on the map.
	 * @param cols The number of columns on the map.
	 * @param empire The empire that owns this map.
	 * @author Jay Clegg
	 */
	public EmpireMap(int rows, int cols, Empire empire, Location location)
	{
		this.map = new Location[rows][cols];
		this.empire = empire;
		this.location = location;
	}
	
	public void setState(int row, int col, int state)
	{
		map[row][col].setState(state);
	}
	
	public void assignLocation(Location location)
	{
		map[location.getRow()][location.getCol()] = location;
	}
	
	public Empire getEmpire()
	{
		return this.empire;
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
		
		for(int row = 0; row < biomes.length; row++)
		{
			for(int col = 0; col < biomes[row].length; col++)
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
	
	public int getRows()
	{
		return this.map.length;
	}
	
	public int getCols()
	{
		return this.map[0].length;
	}
	
	public Location[][] getLocations2D()
	{
		return map;
	}
	
	public Location[] getLocations()
	{
		Location[] map = new Location[this.map.length * this.map[0].length];
		ArrayList<Location> temp = new ArrayList<Location>();
		
		for(Location[] locations : this.map)
		{
			for(Location location : locations)
			{
				temp.add(location);
			}
		}
		
		for(int index = 0; index < temp.size(); index++)
		{
			map[index] = temp.get(index);
		}
		
		return map;
	}
}
