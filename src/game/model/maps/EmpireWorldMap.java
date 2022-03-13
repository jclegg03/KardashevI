package game.model.maps;

import game.controller.MapController;
import game.model.biomes.Biome;
import game.model.biomes.WorldBiome;
import game.model.empire.Empire;

public class EmpireWorldMap extends EmpireMap
{
	public EmpireWorldMap(Empire empire)
	{
		super(20, 20, empire);
		this.id = MapController.WORLD;
	}
	
	@Override
	public Biome[][] getBiomes()
	{
		return this.biomes;
	}
	
	@Override
	public WorldBiome getBiome(int row, int col)
	{
		return (WorldBiome) super.getBiome(row, col);
	}
}
