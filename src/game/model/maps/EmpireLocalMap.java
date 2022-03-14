package game.model.maps;

import game.model.biomes.Biome;
import game.model.empire.Empire;

public class EmpireLocalMap extends EmpireMap
{
	public EmpireLocalMap(Empire empire)
	{
		super(20, 20, empire);
	}
}
