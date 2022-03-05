package game.model.resources;

import java.io.Serializable;

import game.model.units.Describable;

public class Resource implements Serializable, Describable
{
	private int numOwned;
	private int numProduced;
	private String name;
	private String description;	
	
	public Resource(int numOwned, int numProduced, String name)
	{
		this.numOwned = numOwned;
		this.numProduced = numProduced;
		this.name = name;
		this.description = "";
	}
	
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
