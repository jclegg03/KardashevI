package game.model.units;

/**
 * Classes which implement this can be described.
 * @author Jay Clegg
 *
 */
public interface Describable
{
	/**
	 * Gives the description of this object.
	 * @return The description of the object.
	 */
	public String getDescription();
	
	/**
	 * Sets the description of this object.
	 * @param description The description of the object.
	 */
	public void setDescription(String description);
}
