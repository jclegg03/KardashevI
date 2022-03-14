package game.model.maps;

import java.util.HashMap;

import game.controller.MapController;
import game.model.biomes.WorldBiome;
import game.model.empire.Empire;

public class EmpireRegionalMap extends EmpireMap
{
	private HashMap<int[], EmpireLocalMap> localMaps;
	private WorldBiome parentBiome;
	
	public EmpireRegionalMap(Empire empire, WorldBiome parentBiome)
	{
		super(5, 5, empire);
		this.id = MapController.REGIONAL;
		this.localMaps = new HashMap<int[], EmpireLocalMap>();
		this.parentBiome = parentBiome.copy();
	}

	public EmpireLocalMap getMap(int row, int col)
	{
		int[] key = {row, col};
		return localMaps.get(key);
	}

	public void addMap(int row, int col, EmpireMap map)
	{
		int[] key = {row, col};
		localMaps.put(key, (EmpireLocalMap) map);
	}
	
	public WorldBiome getParentBiome()
	{
		return this.parentBiome;
	}
}
