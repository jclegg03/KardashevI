package game.model.maps;

import java.util.Collection;
import java.util.HashMap;

import game.controller.MapController;
import game.model.biomes.WorldBiome;
import game.model.empire.Empire;

public class EmpireWorldMap extends EmpireMap
{
	private HashMap<Location, EmpireRegionalMap> regionalMaps;
	
	public EmpireWorldMap(Empire empire)
	{
		super(20, 20, empire);
		this.regionalMaps = new HashMap<Location, EmpireRegionalMap>();
		this.name = "World Map";
	}
	
	@Override
	public WorldBiome getBiome(int row, int col)
	{
		return (WorldBiome) super.getBiome(row, col);
	}

	public EmpireRegionalMap getMap(int row, int col)
	{
		return regionalMaps.get(getLocation(row, col));
	}
	
	private Location getLocation(int row, int col)
	{
		Location test = new Location(row, col);
		for(Location location : regionalMaps.keySet())
		{
			if(location.equals(test)) return location;
		}
		return null;
	}
	
	public void addMap(int row, int col, EmpireRegionalMap map)
	{
		regionalMaps.put(new Location(row, col), map);
	}
	
	public Collection<EmpireRegionalMap> getRegionalMaps()
	{
		return regionalMaps.values();
	}
}
