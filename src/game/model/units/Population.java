package game.model.units;

import java.io.Serializable;

public class Population implements Serializable
{
	private String name;
	private int size;
	private double growthRate;
	
	public Population(String name, int size, double growthRate)
	{
		this.name = name;
		this.size = size;
		this.growthRate = growthRate;
	}
	
	public Population(String name, int size)
	{
		this.name = name;
		this.size = size;
		this.growthRate = 1.5;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}
	
	public double getGrowthRate()
	{
		return this.growthRate;
	}
	
	public void setGrowthRate(double growthRate)
	{
		this.growthRate = growthRate;
	}
	
	public void grow()
	{
		double population = (double) size;
		population *= growthRate;
		size = (int) (population) + 1;
	}
}
