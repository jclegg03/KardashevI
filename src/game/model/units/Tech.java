package game.model.units;

import java.io.Serializable;

/**
 * The structure for technologies.
 * @author Jay Clegg on 11/17/2021
 *
 */
public class Tech implements Serializable, Describable
{
	static final long serialVersionUID = 1415930728l;
	private String name;
	private String description;
	private int cost;
	private Tech[] requirements;
	private boolean isResearched;
	
	/**
	 * Builds a technology with a name, cost and prerequisites.
	 * @param name The name of the technology.
	 * @param cost How many research points it costs.
	 * @param numRequirements How many previous technologies it requires.
	 */
	public Tech(String name, int cost, Tech[] requirements)
	{
		this.name = name;
		this.cost = cost;
		this.requirements = requirements;
		this.isResearched = false;
	}
	
	/**
	 * Builds a technology with a name and cost. (No prerequisites)
	 * @param name The name of the technology.
	 * @param cost The cost of the technology.
	 */
	public Tech(String name, int cost)
	{
		this.name = name;
		this.cost = cost;
		this.requirements = new Tech[0];
		this.isResearched = false;
	}

	/**
	 * Builds a researched technology with a name, cost, and prerequisites.
	 * @param name The name of the technology.
	 * @param cost The cost of the technology.
	 * @param requirements The requirements of the technology.
	 * @param isResearched If the technology has been researched. (Usually true)
	 */
	public Tech(String name, int cost, Tech[] requirements, boolean isResearched)
	{
		this.name = name;
		this.cost = cost;
		this.requirements = requirements;
		this.isResearched = isResearched;
	}
	
	/**
	 * Builds a base researched technology with a name and cost.
	 * @param name The name of the technology.
	 * @param cost The cost of the technology.
	 * @param isResearched If the technology has been researched. (Usually true)
	 */
	public Tech(String name, int cost, boolean isResearched)
	{
		this.name = name;
		this.cost = cost;
		this.requirements = new Tech[0];
		this.isResearched = isResearched;
	}
	
	/**
	 * Gives the technology's name.
	 * @return The technology's name.
	 */
	public String getName()
	{
		return this.name;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public int getCost()
	{
		return this.cost;
	}
	
	/**
	 * Gives an array of the required technologies for a given technology.
	 * @return The requirements for the technology.
	 */
	public Tech[] getRequirements()
	{
		return this.requirements;
	}
	
	/**
	 * If the technology has been researched.
	 * @return true if the technology is researched, false if not.
	 */
	public boolean getIsResearched()
	{
		return this.isResearched;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	/**
	 * Sets the cost of the technology.
	 * @param cost The new cost of the technology.
	 */
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	
	/**
	 * Sets the technology to researched or not.
	 * @param isResearched If the technology is researched or not.
	 */
	public void setIsResearched(boolean isResearched)
	{
		this.isResearched = isResearched;
	}
	
	//Has documentation by Oracle.
	@Override
	public String toString()
	{
		String details = "";
		
		details += "Name: " + this.getName();
		details += "\nCost: " + this.getCost();
		for(Tech tech : requirements)
		{
			details += "\nRequirement: " + tech.getName();
		}
		
		if(this.isResearched)
		{
			details += "\nThis technology has been researched.";
		}
		
		return details;
	}
}
