package game.model.units;

import java.io.Serializable;

import game.controller.WIP;
import game.model.resources.Resource;
import game.model.resources.Tech;

/**
 * The model for buildings in the game.
 * @author Jay Clegg
 *
 */
@WIP
//no constructor yet.
public class Building implements Serializable, Describable, Requires
{
	/**
	 * A list of resourses this consumer. Determined by the jobs.
	 * @author Jay Clegg
	 */
	private Resource[] consumes;
	
	/**
	 * A description of this building.
	 * @author Jay Clegg
	 */
	private String description;
	
	/**
	 * A list of jobs this employs.
	 * @author Jay Clegg
	 */
	private Job[] employs;
	
	/**
	 * The name of this building.
	 * @author Jay Clegg
	 */
	private String name;
	
	/**
	 * A list of resources this produces. Determined by the jobs.
	 * @author Jay Clegg
	 */
	private Resource[] produces;
	
	/**
	 * The tech requirement if any for this building.
	 * @author Jay Clegg
	 */
	private Tech requirement;
	
	/**
	 * The amount of tiles this building takes up.
	 * @author Jay Clegg
	 */
	private int size;
	
	/**
	 * What this can be upgraded to, if anything.
	 * @author Jay Clegg
	 */
	private Building upgradesTo;
	
	public String getDescription()
	{
		return this.description;
	}
	
	public Tech getRequirement()
	{
		return this.requirement;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
}
