package game.model.units;

import java.io.Serializable;

import game.model.resources.Resource;

/**
 * The model for jobs in an empire.
 * @author Jay Clegg
 *
 */
public class Job implements Serializable, Describable
{
	/**
	 * A description of this job.
	 * @author Jay Clegg
	 */
	private String description;
	
	/**
	 * The name of this job.
	 * @author Jay Clegg
	 */
	private String name;
	
	/**
	 * The amount of this job availalbe.
	 * @author Jay Clegg
	 */
	private int numAvailable;
	
	/**
	 * The amount of people currently working this job.
	 * @author Jay Clegg
	 */
	private int numEmployed;
	
	/**
	 * The resources consumed by this job.
	 * @author Jay Clegg
	 */
	private Resource[] resourcesConsumed;
	
	/**
	 * The resources produced by this job.
	 * @author Jay Clegg
	 */
	private Resource[] resourcesProduced;
	
	/**
	 * Builds a job.
	 * @author Jay Clegg
	 * @param name The name of the job.
	 * @param description The job's description.
	 * @param resourcesProduced The resources it produces.
	 * @param resourcesConsumed The resources it consumes.
	 * @param numAvailalbe The number of available jobs.
	 * @param numEmployed The number of people employed by this job.
	 */
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
	
	/**
	 * Adds the specified amount of jobs.
	 * @author Jay Clegg
	 * @param moreJobs
	 */
	public void addAvailalbe(int moreJobs)
	{
		numAvailable += moreJobs;
	}
	
	/**
	 * Adds the specified amount of employees.
	 * @author Jay Clegg
	 * @param moreWorkers
	 */
	public void addEmployed(int moreWorkers)
	{
		numEmployed += moreWorkers;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getNumAvailable()
	{
		return this.numAvailable;
	}
	
	public int getNumEmployed()
	{
		return this.numEmployed;
	}
	
	public Resource[] getResoucesConsumed()
	{
		return this.resourcesConsumed;
	}
	
	public Resource[] getResourcesProduced()
	{
		return this.resourcesProduced;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setNumAvailable(int numAvailable)
	{
		this.numAvailable = numAvailable;
	}
	
	public void setNumEmployed(int numEmployed)
	{
		this.numEmployed = numEmployed;
	}
	
	public void setResourcesConsumed(Resource[] resourcesConsumed)
	{
		this.resourcesConsumed = resourcesConsumed;
	}
	
	public void setResourcesProduced(Resource[] resourcesProduced)
	{
		this.resourcesProduced = resourcesProduced;
	}
}
