package game.model.biomes;

import java.awt.Color;

public class WorldBiome extends Biome
{
	public WorldBiome(Color color, String name, int weight)
	{
		super(color, name, weight);
	}

	@Override
	public WorldBiome copy()
	{
		return new WorldBiome(this.color, this.NAME, this.WEIGHT);
	}
}
