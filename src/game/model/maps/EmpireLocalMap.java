package game.model.maps;

import game.controller.MapController;
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
	public EmpireLocalMap(RegionalBiome parentBiome, Location location)
	{
		super(10, 10, location, MapController.LOCAL);
		this.name = "Local Map " + count;
		this.parentBiome = parentBiome.copy();
		count++;
	}
	
	public RegionalBiome getParentBiome()
	{
		return this.parentBiome;
	}
	
	@Override
	public LocalBiome getBiome(int row, int col)
	{
		return (LocalBiome) map[row][col].getBiome();
	}
}
