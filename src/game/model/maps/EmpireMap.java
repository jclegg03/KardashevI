package game.model.maps;

import java.io.Serializable;

import game.model.biomes.Biome;
import game.model.empire.Empire;
import game.model.units.Building;

public abstract class EmpireMap implements Serializable
{
	protected String name;
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
}
