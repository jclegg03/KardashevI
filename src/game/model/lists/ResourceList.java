package game.model.lists;

import java.io.Serializable;
import java.util.ArrayList;

import game.model.resources.Resource;

/**
 * The general structure for a list of resources.
 * @author Jay Clegg
 *
 */
public abstract class ResourceList implements Serializable
{
	/**
	 * A list of resources.
	 * @author Jay Clegg
	 */
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
