package game.model.maps;

import game.model.empire.Empire;

public class LocalMap extends Map
{
	public LocalMap(Empire empire)
	{
		super(20, 20, empire);
	}
}
