package game.model.maps;

import java.util.HashMap;

import game.controller.MapController;
import game.model.biomes.Biome;
import game.model.biomes.WorldBiome;
import game.model.empire.Empire;

public class EmpireWorldMap extends EmpireMap
{
	private HashMap<int[], EmpireRegionalMap> regionalMaps;
	
	public EmpireWorldMap(Empire empire)
	{
		super(20, 20, empire);
		this.id = MapController.WORLD;
	}
	
	@Override
	public WorldBiome getBiome(int row, int col)
	{
		return (WorldBiome) super.getBiome(row, col);
	}

	@Override
	public EmpireRegionalMap getMap(int row, int col)
	{
		int[] key = {row, col};
		return regionalMaps.get(key);
	}

	@Override
	public void addMap(int row, int col, EmpireMap map)
	{
		int[] key = {row, col};
		regionalMaps.put(key, (EmpireRegionalMap) map);
	}
}
