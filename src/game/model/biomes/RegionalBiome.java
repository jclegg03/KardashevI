package game.model.biomes;

import java.awt.Color;

/**
 * The model for regional biomes.
 * @author Jay Clegg
 *
 */
public class RegionalBiome extends Biome
{
	/**
	 * Builds a regional biome based on the parameters.
	 * @author Jay Clegg
	 * @param color The color the biome will have when displayed.
	 * @param name The name of the biome.
	 * @param weight How frequently the biome will generate.
	 */
	public RegionalBiome(Color color, String name, int weight)
	{
		super(color, name, weight);
	}

	@Override
	public RegionalBiome copy()
	{
		return new RegionalBiome(this.COLOR, this.NAME, this.WEIGHT);
	}
}
