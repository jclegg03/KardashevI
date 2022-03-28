package game.model.maps;

import game.model.biomes.LocalBiome;
import game.model.biomes.RegionalBiome;
import game.model.empire.Empire;

/**
 * The model for local maps.
 * @author Jay Clegg
 *
 */
public class EmpireLocalMap extends EmpireMap
{
	private static int count;
	private RegionalBiome parentBiome;
	
	/**
	 * Builds the local map.
	 * @author Jay Clegg
	 * @param empire The empire which owns this map.
	 * @param parentBiome The biome used to generate this maps biomes.
	 */
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
