package game.model.resources;

import java.io.Serializable;

import game.model.units.Describable;

/**
 * The structure for technologies.
 * @author Jay Clegg on 11/17/2021
 *
 */
public class Tech implements Serializable, Describable
{
	/**
	 * The amount of research this tech takes.
	 * @author Jay Clegg
	 */
	private int cost;
	
	/**
	 * A description of this technology.
	 * @author Jay Clegg
	 */
	private String description;
	
	/**
	 * If this tech has been researched.
	 * @author Jay Clegg
	 */
	private boolean isResearched;
	
	/**
	 * The name of this technology.
	 * @author Jay Clegg
	 */
	private String name;
	
	/**
	 * Any requirements this tech has.
	 * @author Jay Clegg
	 */
	private Tech[] requirements;
	
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
	 * Determines if a tech can be researched.
	 * @author Jay Clegg
	 * @return if the tech can be researched.
	 */
	public boolean canBeResearched()
	{
		if(requirements.length == 0)
		{
			return true;
		}
		else
		{
			for(Tech tech : requirements)
			{
				if(! tech.getIsResearched())
				{
					return false;
				}
			}
			return true;
		}
	}
	
	public int getCost()
	{
		return this.cost;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	/**
	 * If the technology has been researched.
	 * @return true if the technology is researched, false if not.
	 */
	public boolean getIsResearched()
	{
		return this.isResearched;
	}
	
	/**
	 * Gives the technology's name.
	 * @return The technology's name.
	 */
	public String getName()
	{
		return this.name;
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
	 * Sets the cost of the technology.
	 * @param cost The new cost of the technology.
	 */
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	/**
	 * Sets the technology to researched or not.
	 * @param isResearched If the technology is researched or not.
	 */
	public void setIsResearched(boolean isResearched)
	{
		this.isResearched = isResearched;
	}
	
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
