package game.units;

import java.io.Serializable;

public class Resource implements Serializable, Describable
{
	static final long serialVersionUID = 5937278606306862480l;
	int numOwned;
	int numProduced;
	String name;
	String description;	
	
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
