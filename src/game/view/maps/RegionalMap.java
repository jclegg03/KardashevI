package game.view.maps;

import game.controller.MapController;

public class RegionalMap extends Map
{
	private static int count;
	
	public RegionalMap(MapController app)
	{
		super(app, 5, 5, MapController.REGIONAL);
		this.name = "Regional Map " + count;
		count++;
	}
}
