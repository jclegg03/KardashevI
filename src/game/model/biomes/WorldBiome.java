package game.model.biomes;

import java.awt.Color;

/**
 * The model for a world biome.
 * @author Jay Clegg
 *
 */
public class WorldBiome extends Biome
{
	/**
	 * Builds a world biome based off the specified parameters.
	 * @author Jay Clegg
	 * @param color The color this biome has when displayed.
	 * @param name The name of this biome.
	 * @param weight How frequently this biome generates.
	 */
	public WorldBiome(Color color, String name, int weight)
	{
		super(color, name, weight);
	}

	@Override
	public WorldBiome copy()
	{
		return new WorldBiome(this.COLOR, this.NAME, this.WEIGHT);
	}
}
