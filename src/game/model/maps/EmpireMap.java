package game.model.maps;

import java.io.Serializable;

import game.model.empire.Empire;

public abstract class EmpireMap implements Serializable
{
	protected String id;
	protected int[][] map;
	protected Empire empire;
	
	public EmpireMap(int rows, int cols, Empire empire)
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
	
	public String getId()
	{
		return this.id;
	}
	
	public Empire getEmpire()
	{
		return this.empire;
	}
	
	public int getValue(int row, int col)
	{
		return map[row][col];
	}
}
