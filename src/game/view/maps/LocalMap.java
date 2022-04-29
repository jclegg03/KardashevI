package game.view.maps;

import game.controller.MapController;

/**
 * The visible local map.
 * @author Jay Clegg
 *
 */
public class LocalMap extends Map
{
	private static int count;
	/**
	 * Builds the visible local map.
	 * @param app
	 * @author Jay Clegg
	 */
	public LocalMap(MapController app)
	{
		super(app, 10, 10, MapController.LOCAL);
		this.name = "Local Map " + count;
		count++;
		
		//Uncomment this to fully explore all local maps.
//		for(Tile tile : this.getTiles())
//		{
//			tile.setIsExplored(true);
//		}
	}
}
