package game.model.units;

import game.model.resources.Tech;

/**
 * Implementing this means the class requires a certain tech in order to be made.
 * @author Jay Clegg
 *
 */
public interface Requires
{
	/**
	 * Gives the tech requirement of something.
	 * @return The tech requirement of the object.
	 */
	public Tech getRequirement();
}
