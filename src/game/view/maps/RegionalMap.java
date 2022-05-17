package game.view.maps;

import game.controller.MapController;

/**
 * The visible representation of regional maps.
 * @author Jay Clegg
 *
 */
public class RegionalMap extends Map
{
	/**
	 * Counts the amount of times this class has been initialized. Ensures distinct map names.
	 * @author Jay Clegg
	 */
	private static int count;
	
	/**
	 * Builds a regional map.
	 * @param app The controller this reports to.
	 * @author Jay Clegg
	 */
	public RegionalMap(MapController app)
	{
		super(app, 5, 5, MapController.REGIONAL);
		this.name = "Regional Map " + count;
		count++;
	}
}
