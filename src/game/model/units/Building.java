package game.model.units;

import java.io.Serializable;

import game.model.resources.Resource;
import game.model.resources.Tech;

/**
 * The model for buildings in the game.
 * @author Jay Clegg
 *
 */
public class Building implements Serializable, Describable, Requires
{
	private String name;
	private Job[] employs;
	private Resource[] produces;
	private Resource[] consumes;
	private int size;
	private Building upgradesTo;
	private String description;
	private Tech requirement;
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Tech getRequirement()
	{
		return this.requirement;
	}
}
