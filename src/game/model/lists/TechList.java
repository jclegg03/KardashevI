package game.model.lists;

import java.io.Serializable;
import java.util.ArrayList;

import game.model.resources.Tech;

/**
 * The general class for lists of technologies.
 * @author Jay Clegg
 *
 */
public abstract class TechList implements Serializable
{
	/**
	 * The acutal list of techs.
	 * @author Jay Clegg
	 */
	protected ArrayList <Tech> ageTechs;
	
	/**
	 * A list of requirements for a certain tech.
	 * @author Jay Clegg
	 */
	protected Tech[] requirements;
	
	/**
	 * Builds the list of technologies.
	 * @author Jay Clegg
	 */
	public TechList()
	{
		this.ageTechs = new ArrayList <Tech>();
	}
	
	/**
	 * Copys the requirements to a new list so the reference isn't ever modified.
	 * @author Jay Clegg
	 * @return The copied list of requirements.
	 */
	protected Tech[] copyRequirements()
	{
		Tech[] copy = new Tech[requirements.length];
		for(int index = 0; index < requirements.length; index++)
		{
			copy[index] = requirements[index];
		}
		return copy;
	}
	
	/**
	 * Makes the requirements a new list of techs.
	 * @author Jay Clegg
	 * @param numTechs The size of the list.
	 */
	protected void setupRequirements(int numTechs)
	{
		requirements = new Tech[numTechs];
	}
	
	/**
	 * Checks if every technology has been researched from the list.
	 * @author Jay Clegg
	 * @return true if the list has been completely researched. False otherwise.
	 */
	public boolean isFinished()
	{
		boolean isFinished = false;
		int numTech = ageTechs.size();
		int numResearched = 0;
		
		for(Tech tech : ageTechs)
		{
			if(tech.getIsResearched())
			{
				numResearched++;
			}
		}
		
		isFinished = numTech == numResearched;
		return isFinished;
	}
}
