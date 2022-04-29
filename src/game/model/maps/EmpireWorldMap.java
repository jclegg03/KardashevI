package game.model.maps;

import java.util.Collection;
import java.util.HashMap;

import game.controller.MapController;
import game.model.biomes.WorldBiome;
import game.model.empire.Empire;

/**
 * The world map in the model.
 * @author Jay Clegg
 *
 */
public class EmpireWorldMap extends EmpireMap
{
	private HashMap<Location, EmpireRegionalMap> regionalMaps;
	
	/**
	 * Builds a world map with the specified empire as the owner.
	 * @param empire The owner of this map.
	 * @author Jay Clegg
	 */
	public EmpireWorldMap(Empire empire)
	{
		super(20, 20, empire, new Location(0, 0, null, null), MapController.WORLD);
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
		
		return regionalMaps.get(selectLocation(row, col));
	}
	
	/**
	 * Helper method used to get the correct location key.
	 * @param row The row of the location.
	 * @param col The column of the location.
	 * @return The location which matches the row and column specified. If none matched, returns null.
	 * @author Jay Clegg
	 */
	private Location selectLocation(int row, int col)
	{
		for(Location location : regionalMaps.keySet())
		{
			if(new Location(row, col, null, null).equals(location))
			{
				return location;
			}
		}
		
		return null;
	}
	
	/**
	 * Adds a regional map to this world map.
	 * @param row The row where this regional map is.
	 * @param col The column where this regional map is.
	 * @param map The regional map which will be added.
	 * @author Jay Clegg
	 */
	public void addMap(int row, int col, EmpireRegionalMap map)
	{
		regionalMaps.put(new Location(row, col, null, null), map);
	}
	
	public Collection<EmpireRegionalMap> getRegionalMaps()
	{
		return regionalMaps.values();
	}
}
