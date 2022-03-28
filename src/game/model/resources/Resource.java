package game.model.resources;

import java.io.Serializable;

import game.model.units.Describable;

/**
 * The model for resources empires own.
 * @author Jay Clegg
 *
 */
public class Resource implements Serializable, Describable
{
	private int numOwned;
	private int numProduced;
	private String name;
	private String description;	
	
	/**
	 * Builds a resource without a description.
	 * @author Jay Clegg
	 * @param numOwned The number of this resource the empire currently owns.
	 * @param numProduced The amount of this resource the empire produces monthly.
	 * @param name The name of the resource.
	 */
	public Resource(int numOwned, int numProduced, String name)
	{
		this.numOwned = numOwned;
		this.numProduced = numProduced;
		this.name = name;
		this.description = "";
	}
	
	/**
	 * Builds a resource with a description.
	 * @author Jay Clegg
	 * @param numOwned The number of this resource the empire owns.
	 * @param numProduced The amount of this resource the empire produces.
	 * @param name The name of this resource.
	 * @param description The description of this resource.
	 */
	public Resource(int numOwned, int numProduced, String name, String description)
	{
		this.numOwned = numOwned;
		this.numProduced = numProduced;
		this.name = name;
		this.description = description;
	}
	
	public int getNumOwned()
	{
		return this.numOwned;
	}
	
	public int getNumProduced()
	{
		return this.numProduced;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setNumOwned(int numOwned)
	{
		this.numOwned = numOwned;
	}
	
	public void setNumProduced(int numProduced)
	{
		this.numProduced = numProduced;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
}
