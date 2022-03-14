package game.model.maps;

import java.util.HashMap;

import game.controller.MapController;
import game.model.biomes.RegionalBiome;
import game.model.empire.Empire;

public class EmpireRegionalMap extends EmpireMap
{
	private HashMap<int[], EmpireLocalMap> localMaps;
	
	public EmpireRegionalMap(Empire empire)
	{
		super(5, 5, empire);
		this.id = MapController.REGIONAL;
		this.localMaps = new HashMap<int[], EmpireLocalMap>();
	}

	@Override
	public EmpireLocalMap getMap(int row, int col)
	{
		int[] key = {row, col};
		return localMaps.get(key);
	}

	@Override
	public void addMap(int row, int col, EmpireMap map)
	{
		int[] key = {row, col};
		localMaps.put(key, (EmpireLocalMap) map);
	}
}
