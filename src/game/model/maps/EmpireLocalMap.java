package game.model.maps;

import game.model.biomes.Biome;
import game.model.empire.Empire;

public class EmpireLocalMap extends EmpireMap
{
	private static int count;
	
	public EmpireLocalMap(Empire empire)
	{
		super(20, 20, empire);
		this.name = "Local Map " + count;
	}
}
