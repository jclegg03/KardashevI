package game.model.biomes;

import java.awt.Color;

public class RegionalBiome extends Biome
{
	public RegionalBiome(Color color, String name, int weight)
	{
		super(color, name, weight);
	}

	@Override
	public RegionalBiome copy()
	{
		return new RegionalBiome(this.color, this.NAME, this.WEIGHT);
	}
}
