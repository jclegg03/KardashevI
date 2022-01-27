package game.model.units;

import java.io.Serializable;

public class Job implements Serializable
{
	static final long serialVersionUID = 4878178l;
	private String name;
	private String description;
	private Resource[] resourcesProduced;
	private Resource[] resourcesConsumed;
	private int numAvailable;
	private int numEmployed;
	
	public Job(String name, String description, Resource[] resourcesProduced, Resource[] resourcesConsumed,
			int numAvailalbe, int numEmployed)
	{
		this.name = name;
		this.description = description;
		this.resourcesProduced = resourcesProduced;
		this.resourcesConsumed = resourcesConsumed;
		this.numAvailable = numAvailalbe;
		this.numEmployed = numEmployed;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public Resource[] getResourcesProduced()
	{
		return this.resourcesProduced;
	}
	
	public Resource[] getResoucesConsumed()
	{
		return this.resourcesConsumed;
	}
	
	public int getNumAvailable()
	{
		return this.numAvailable;
	}
	
	public int getNumEmployed()
	{
		return this.numEmployed;
	}
	
	public void setResourcesProduced(Resource[] resourcesProduced)
	{
		this.resourcesProduced = resourcesProduced;
	}
	
	public void setResourcesConsumed(Resource[] resourcesConsumed)
	{
		this.resourcesConsumed = resourcesConsumed;
	}
	
	public void setNumAvailable(int numAvailable)
	{
		this.numAvailable = numAvailable;
	}
	
	public void setNumEmployed(int numEmployed)
	{
		this.numEmployed = numEmployed;
	}
	
	public void addAvailalbe(int moreJobs)
	{
		numAvailable += moreJobs;
	}
	
	public void addEmployed(int moreWorkers)
	{
		numEmployed += moreWorkers;
	}
}
