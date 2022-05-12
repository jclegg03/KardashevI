package game.model.biomes;

import java.util.ArrayList;

import game.model.units.Building;

/**
 * Requires a class to have buildings it allows to be build.
 * Buildings can be added with addAllowed. 
 * Buildings can be checked for with isAllowed.
 * @author Jay Clegg
 *
 */
public interface Allows
{
	/**
	 * Adds a building to the list of allowed buildings.
	 * @author Jay Clegg
	 * @param building The building to be added to the list.
	 */
	public void addAllowed(Building building);
	
	public ArrayList<Building> getAllowedBuildings();
	
	/**
	 * Determines if a certain building is allowed.
	 * @author Jay Clegg
	 * @param building The building to be checked for.
	 * @return True if the building is in the list otherwise false.
	 */
	public boolean isAllowed(Building building);
}
