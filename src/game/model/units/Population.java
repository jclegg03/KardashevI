package game.model.units;

import java.io.Serializable;

/**
 * The model for an empire's population.
 * @author Jay Clegg
 *
 */
public class Population implements Serializable
{
	private String name;
	private int size;
	private double growthRate;
	
	/**
	 * Builds a population model.
	 * @author Jay Clegg
	 * @param name The name of the population.
	 * @param size The starting size of the population.
	 * @param growthRate How fast the population grows.
	 */
	public Population(String name, int size, double growthRate)
	{
		this.name = name;
		this.size = size;
		this.growthRate = growthRate;
	}
	
	/**
	 * Builds a populaiton model with a default growth rate of 1.5.
	 * @author Jay Clegg
	 * @param name The name of the population.
	 * @param size The size of the population.
	 */
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
	
	/**
	 * Multiplies the population by the growth rate to increase the population size.
	 * @author Jay Clegg
	 */
	public void grow()
	{
		double population = (double) size;
		population *= growthRate;
		size = (int) (population) + 1;
	}
}
