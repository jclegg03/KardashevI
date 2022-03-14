package game.model.biomes;

import java.awt.Color;
import java.util.ArrayList;

import game.model.units.Building;

public class LocalBiome extends Biome implements Allows
{
	private ArrayList<Building> allowedBuildings;
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
