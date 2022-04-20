package game.view.maps;

import game.controller.MapController;

/**
 * The visual representation of the world map.
 * @author Jay Clegg
 *
 */
public class WorldMap extends Map
{
	/**
	 * Builds the world map.
	 * @param app The controller this reports to.
	 * @author Jay Clegg
	 */
	public WorldMap(MapController app)
	{
		super(app, 20, 20, MapController.WORLD);
		this.name = "World Map";
	}
}
