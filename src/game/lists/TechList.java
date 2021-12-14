package game.lists;

import java.util.ArrayList;

import game.units.Tech;

public class TechList
{
	protected ArrayList <Tech> ageTech;
	protected Tech[] req;
	
	public TechList()
	{
		this.ageTech = new ArrayList <Tech>();
	}
	
	public boolean isFinished()
	{
		boolean isFinished = false;
		int numTech = ageTech.size();
		int numResearched = 0;
		
		for(Tech tech : ageTech)
		{
			if(tech.getIsResearched())
			{
				numResearched++;
			}
		}
		
		isFinished = numTech == numResearched;
		return isFinished;
	}
	
	protected void req(int numTechs)
	{
		req = new Tech[numTechs];
	}
	
	protected Tech[] copy()
	{
		Tech[] copy = new Tech[req.length];
		for(int index = 0; index < req.length; index++)
		{
			copy[index] = req[index];
		}
		return copy;
	}
}
