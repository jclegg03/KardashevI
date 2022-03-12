package game.view.maps;

import game.controller.MapController;

public class WorldMap extends Map
{
	public WorldMap(MapController app)
	{
		super(app, 20, 20, MapController.WORLD);
	}
}
