package game.model.maps;

import java.io.Serializable;

import game.model.biomes.Biome;
import game.model.empire.Empire;
import game.model.units.Building;

public abstract class EmpireMap implements Serializable
{
	protected String id;
	protected int[][] map;
	protected Biome[][] biomes;
	protected Building[][] buildings;
	protected Empire empire;
	
	public EmpireMap(int rows, int cols, Empire empire)
	{
		this.map = new int[rows][cols];
		this.empire = empire;
		this.biomes = new Biome[rows][cols];
		this.buildings = new Building[rows][cols];
	}
	
	public void explore(int row, int col)
	{
		
	}
	
	public void claim(int row, int col)
	{
		
	}
	
	public void transfer(int row, int col, Empire empire)
	{
		
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
	
	public String getId()
	{
		return this.id;
	}
	
	public Biome[][] getBiomes()
	{
		return this.biomes;
	}
	
	public abstract EmpireMap getMap(int row, int col);
	
	public abstract void addMap(int row, int col, EmpireMap map);
}
