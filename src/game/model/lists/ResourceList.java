package game.model.lists;

import java.io.Serializable;
import java.util.ArrayList;

import game.model.resources.Resource;

public abstract class ResourceList implements Serializable
{
	protected ArrayList <Resource> ageResources;
	
	public ResourceList()
	{
		this.ageResources = new ArrayList <Resource>();
	}
	
	public ArrayList <Resource> getAgeResources()
	{
		return this.ageResources;
	}
}
