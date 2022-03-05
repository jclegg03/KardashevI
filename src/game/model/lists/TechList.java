package game.model.lists;

import java.util.ArrayList;

import game.model.resources.Tech;

public abstract class TechList
{
	protected ArrayList <Tech> ageTechs;
	protected Tech[] requirements;
	
	public TechList()
	{
		this.ageTechs = new ArrayList <Tech>();
	}
	
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
	
	protected void setupRequirements(int numTechs)
	{
		requirements = new Tech[numTechs];
	}
	
	protected Tech[] copyRequirements()
	{
		Tech[] copy = new Tech[requirements.length];
		for(int index = 0; index < requirements.length; index++)
		{
			copy[index] = requirements[index];
		}
		return copy;
	}
}
