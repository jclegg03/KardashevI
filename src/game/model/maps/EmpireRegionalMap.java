package game.model.maps;

import java.util.Collection;
import java.util.HashMap;

import game.controller.MapController;
import game.model.biomes.WorldBiome;
import game.model.empire.Empire;

/**
 * The model for regional maps.
 * @author Jay Clegg
 *
 */
public class EmpireRegionalMap extends EmpireMap
{
	private HashMap<Location, EmpireLocalMap> localMaps;
	private WorldBiome parentBiome;
	private static int count;
	
	/**
	 * Builds the regional map.
	 * @author Jay Clegg
	 * @param empire The owner of the map.
	 * @param parentBiome The biome used to generate this maps biomes.
	 */
	public EmpireRegionalMap(WorldBiome parentBiome, Location location)
	{
		super(5, 5, location, MapController.REGIONAL);
		this.localMaps = new HashMap<Location, EmpireLocalMap>();
		this.parentBiome = parentBiome.copy();
		this.name = "Regional Map " + count;
		count++;
	}
	
	public EmpireLocalMap getMap(int row, int col)
	{
		return localMaps.get(selectLocation(row, col));
	}
	
	/**
	 * Finds the correct location key to match the row and column specified.
	 * @author Jay Clegg
	 * @param row The row of the location.
	 * @param col The column of the location.
	 * @return The location which matched. If non match, this returns null.
	 */
	private Location selectLocation(int row, int col)
	{
		for(Location location : localMaps.keySet())
		{
			if(location.equals(new Location(row, col, null, null)))
			{
				return location;
			}
		}
		
		return null;
	}
	
	/**
	 * Adds the local map to the specified location.
	 * @author Jay Clegg
	 * @param row The row where the map is located.
	 * @param col The column where the map is located.
	 * @param map The map to be added.
	 */
	public void addMap(int row, int col, EmpireLocalMap map)
	{
		Location key = new Location(row, col, null, null);
		localMaps.put(key, map);
	}
	
	public WorldBiome getParentBiome()
	{
		return this.parentBiome;
	}
	
	public Collection<EmpireLocalMap> getLocalMaps()
	{
		return localMaps.values();
	}
}
