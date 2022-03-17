package game.model.maps;

import game.model.biomes.LocalBiome;
import game.model.biomes.RegionalBiome;
import game.model.empire.Empire;

public class EmpireLocalMap extends EmpireMap
{
	private static int count;
	private RegionalBiome parentBiome;
	
	public EmpireLocalMap(Empire empire, RegionalBiome parentBiome)
	{
		super(10, 10, empire);
		this.name = "Local Map " + count;
		this.parentBiome = parentBiome.copy();
	}
	
	public RegionalBiome getParentBiome()
	{
		return this.parentBiome;
	}
	
	@Override
	public LocalBiome getBiome(int row, int col)
	{
		return (LocalBiome) biomes[row][col];
	}
}
