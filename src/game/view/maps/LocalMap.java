package game.view.maps;

import game.controller.MapController;

public class LocalMap extends Map
{
	private static int count;
	public LocalMap(MapController app)
	{
		super(app, 20, 20, MapController.LOCAL);
		this.name = "Local Map " + count;
		count++;
	}
}
