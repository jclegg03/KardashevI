package game.model.empire;

import java.io.Serializable;

/**
 * The model for an empire.
 * @author Jay Clegg
 *
 */
public class Empire implements Serializable
{
	private String name;
	
	/**
	 * Builds an empire based on the specified parameters.
	 * @author Jay Clegg
	 * @param name The name of the empire.
	 */
	public Empire(String name)
	{
		this.name = name;
	}
}
