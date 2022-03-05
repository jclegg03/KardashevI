package game.model.maps;

import java.io.Serializable;

import game.model.empire.Empire;

public abstract class Map implements Serializable
{
	public static final String LOCAL = "Local";
	public static final String REGIONAL = "Regional";
	public static final String WORLD = "World";
	protected int[][] map;
	protected Empire empire;
	
	public Map(int rows, int cols, Empire empire)
	{
		this.map = new int[rows][cols];
		this.empire = empire;
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
}
