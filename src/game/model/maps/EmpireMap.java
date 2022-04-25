package game.model.maps;

import java.io.Serializable;

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
	protected int[][] map;
	protected Biome[][] biomes;
	protected Building[][] buildings;
	protected Empire empire;
	protected Location location;
	
	/**
	 * Builds a map with the specified amounts of rows and columns, with an empire owning it.
	 * @param rows The number of rows on the map.
	 * @param cols The number of columns on the map.
	 * @param empire The empire that owns this map.
	 * @author Jay Clegg
	 */
	public EmpireMap(int rows, int cols, Empire empire, Location location)
	{
		this.map = new int[rows][cols];
		this.empire = empire;
		this.biomes = new Biome[rows][cols];
		this.buildings = new Building[rows][cols];
		this.location = location;
	}
	
	public void setValue(int row, int col, int value)
	{
		map[row][col] = value;
	}
	
	public Empire getEmpire()
	{
		return this.empire;
	}
	
	public int getValue(int row, int col)
	{
		return map[row][col];
	}
	
	public Biome getBiome(int row, int col)
	{
		return biomes[row][col];
	}
	
	public Building getBuilding(int row, int col)
	{
		return buildings[row][col];
	}
	
	public Biome[][] getBiomes2D()
	{
		return this.biomes;
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
}
