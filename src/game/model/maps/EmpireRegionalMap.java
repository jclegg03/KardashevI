package game.model.maps;

import game.model.biomes.RegionalBiome;
import game.model.empire.Empire;

public class EmpireRegionalMap extends EmpireMap
{
	public EmpireRegionalMap(Empire empire)
	{
		super(5, 5, empire);
	}

	@Override
	public RegionalBiome[][] getBiomes()
	{
		return (RegionalBiome[][]) this.biomes;
	}
}
