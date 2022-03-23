package game.model.biomes;

import java.awt.Color;
import java.util.ArrayList;

import game.model.units.Building;

/**
 * The model for local biomes.
 * 
 * @author Jay Clegg
 *
 */
public class LocalBiome extends Biome implements Allows
{
	private ArrayList<Building> allowedBuildings;
	
	/**
	 * Builds a local biome with the specified perameters.
	 * @author Jay Clegg
	 * @param color The color of the biome on the display.
	 * @param name The name of the biome.
	 * @param weight How frequently the biome generates.
	 */
	public LocalBiome(Color color, String name, int weight)
	{
		super(color, name, weight);
		this.allowedBuildings = new ArrayList<Building>();
	}
	
	@Override
	public ArrayList<Building> getAllowedBuildings()
	{
		return this.allowedBuildings;
	}
	
	@Override
	public void addAllowed(Building building)
	{
		allowedBuildings.add(building);
	}
	
	@Override
	public boolean isAllowed(Building building)
	{
		for(Building allowed : allowedBuildings)
		{
			if(allowed.equals(building)) return true;
		}
		
		return false;
	}

	@Override
	public Biome copy()
	{
		return new LocalBiome(this.color, this.NAME, this.WEIGHT);
	}
}
