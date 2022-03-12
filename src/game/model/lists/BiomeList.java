package game.model.lists;

import java.awt.Color;
import java.util.ArrayList;

import game.model.biomes.LocalBiome;
import game.model.biomes.RegionalBiome;
import game.model.biomes.WorldBiome;

public class BiomeList
{
	private ArrayList<WorldBiome> worldBiomes;
	private ArrayList<RegionalBiome> regionalBiomes;
	private ArrayList<LocalBiome> localBiomes;
	
	public BiomeList()
	{
		this.worldBiomes = new ArrayList<WorldBiome>();
		this.regionalBiomes = new ArrayList<RegionalBiome>();
		this.localBiomes = new ArrayList<LocalBiome>();
		
		addBiomes();
	}
	
	private void addBiomes()
	{
		addWorldBiomes();
		addRegionalBiomes();
		addLocalBiomes();
	}
	
	private void addWorldBiomes()
	{
		worldBiomes.add(new WorldBiome(new Color(10, 10, 107), "Deep Ocean", 65));
		worldBiomes.add(new WorldBiome(new Color(12, 94, 112), "Shallow Ocean", 6));
		worldBiomes.add(new WorldBiome(new Color(116, 130, 23), "Desert", 10));
		worldBiomes.add(new WorldBiome(new Color(99, 127, 150), "Icy Ocean", 1));
		worldBiomes.add(new WorldBiome(new Color(54, 63, 71), "Mountainous", 5));
		worldBiomes.add(new WorldBiome(new Color(75, 153, 105), "Fertile", 13));
	}
	
	private void addRegionalBiomes()
	{
		regionalBiomes.add(new RegionalBiome(new Color(10, 10, 107), "Deep Ocean", 100));
		
		regionalBiomes.add(new RegionalBiome(new Color(12, 94, 112), "Shallow Ocean", 80));
		regionalBiomes.add(new RegionalBiome(new Color(10, 148, 111), "Reef", 10));
		regionalBiomes.add(new RegionalBiome(new Color(133, 106, 25), "Shore", 10));
		
		regionalBiomes.add(new RegionalBiome(new Color(116, 130, 23), "Desert", 100));
		
		regionalBiomes.add(new RegionalBiome(new Color(116, 181, 184), "Icebergs", 75));
		regionalBiomes.add(new RegionalBiome(new Color(10, 10, 107), "Cold Deep Ocean", 25));
		
		regionalBiomes.add(new RegionalBiome(new Color(190, 196, 196), "Glacier", 10));
		regionalBiomes.add(new RegionalBiome(new Color(75, 75, 75), "Ore Rich", 10));
		regionalBiomes.add(new RegionalBiome(new Color(76, 76, 76), "Stony", 80));
		
		regionalBiomes.add(new RegionalBiome(new Color(4, 117, 40), "Grasslands", 50));
		regionalBiomes.add(new RegionalBiome(new Color(41, 123, 230), "Lake", 50));
	}
	
	private void addLocalBiomes()
	{
		
	}
}
