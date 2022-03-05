package game.model.units;

import game.model.resources.Tech;

public interface Requires
{
	/**
	 * Gives the tech requirement of something.
	 * @return The tech requirement of the object.
	 */
	public Tech getRequirement();
}
