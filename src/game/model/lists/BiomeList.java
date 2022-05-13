package game.model.lists;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

import game.model.biomes.LocalBiome;
import game.model.biomes.RegionalBiome;
import game.model.biomes.WorldBiome;

/**
 * The lists of every biome used in the game.
 * @author Jay Clegg
 *
 */
public class BiomeList implements Serializable
{
	/**
	 * A list of all the local biomes.
	 * @author Jay Clegg
	 */
	private ArrayList<LocalBiome> localBiomes;
	
	/**
	 * A list of all the regional biomes.
	 * @author Jay Clegg
	 */
	private ArrayList<RegionalBiome> regionalBiomes;
	
	/**
	 * A list of all the world biomes.
	 * @author Jay Clegg
	 */
	private ArrayList<WorldBiome> worldBiomes;
	
	/**
	 * Builds the biomes and adds them to their respective lists.
	 * @author Jay Clegg
	 */
	public BiomeList()
	{
		this.worldBiomes = new ArrayList<WorldBiome>();
		this.regionalBiomes = new ArrayList<RegionalBiome>();
		this.localBiomes = new ArrayList<LocalBiome>();
		
		addBiomes();
	}
	
	/**
	 * Helper method, calls other helpers to build all the biome lists then sort them.
	 * @author Jay Clegg
	 */
	private void addBiomes()
	{
		addWorldBiomes();
		addRegionalBiomes();
		addLocalBiomes();
		
		worldBiomes.sort(null);
		regionalBiomes.sort(null);
		localBiomes.sort(null);
	}
	
	/**
	 * Helper method, builds and adds the local biomes.
	 * @author Jay Clegg
	 */
	private void addLocalBiomes()
	{
		localBiomes.add(new LocalBiome(new Color(10, 10, 107), "Deep Ocean", 100));
		
		localBiomes.add(new LocalBiome(new Color(12, 94, 112), "Shallow Ocean", 100));
		
		localBiomes.add(new LocalBiome(new Color(10, 148, 111), "Reef", 100));
		
		localBiomes.add(new LocalBiome(new Color(133, 106, 25), "Shore", 100));
		
		localBiomes.add(new LocalBiome(new Color(116, 130, 23), "Desert", 99));
		localBiomes.add(new LocalBiome(new Color(39, 0, 232), "Oasis", 1));
		
		localBiomes.add(new LocalBiome(new Color(39, 0, 232), "Water", 33));
		localBiomes.add(new LocalBiome(new Color(97, 153, 14), "Fertile", 33));
		localBiomes.add(new LocalBiome(new Color(116, 130, 23), "Sand", 34));
		
		localBiomes.add(new LocalBiome(new Color(116, 181, 184), "Ice", 90));
		localBiomes.add(new LocalBiome(new Color(10, 10, 107), "Icy Ocean", 10));
		
		localBiomes.add(new LocalBiome(new Color(116, 181, 184), "Small Berg", 5));
		localBiomes.add(new LocalBiome(new Color(10, 10, 107), "Cold Deep Ocean", 95));
		
		localBiomes.add(new LocalBiome(new Color(190, 196, 196), "Glacier", 99));
		localBiomes.add(new LocalBiome(new Color(191, 197, 197), "Diamond", 1));
		
		localBiomes.add(new LocalBiome(new Color(75, 75, 75), "Ore Rich", 90));
		localBiomes.add(new LocalBiome(new Color(76, 76, 76), "Stone", 10));
		
		localBiomes.add(new LocalBiome(new Color(75, 75, 75), "Coal", 20));
		localBiomes.add(new LocalBiome(new Color(76, 76, 76), "Stoney", 80));
		
		localBiomes.add(new LocalBiome(new Color(4, 117, 40), "Grasslands", 95));
		localBiomes.add(new LocalBiome(new Color(41, 123, 230), "Small Lake", 5));
		
		localBiomes.add(new LocalBiome(new Color(4, 117, 40), "Island", 25));
		localBiomes.add(new LocalBiome(new Color(41, 123, 230), "Large Lake", 75));
	}
	
	/**
	 * Helper method, builds and adds all the regional biomes.
	 * @author Jay Clegg
	 */
	private void addRegionalBiomes()
	{
		regionalBiomes.add(new RegionalBiome(new Color(10, 10, 107), "Deep Ocean", 100));
		
		regionalBiomes.add(new RegionalBiome(new Color(12, 94, 112), "Shallow Ocean", 80));
		regionalBiomes.add(new RegionalBiome(new Color(10, 148, 111), "Reef", 10));
		regionalBiomes.add(new RegionalBiome(new Color(133, 106, 25), "Shore", 10));
		
		regionalBiomes.add(new RegionalBiome(new Color(116, 130, 23), "Desert", 99));
		regionalBiomes.add(new RegionalBiome(new Color(39, 0, 232), "Oasis", 1));
		
		regionalBiomes.add(new RegionalBiome(new Color(116, 181, 184), "Iceberg", 75));
		regionalBiomes.add(new RegionalBiome(new Color(10, 10, 107), "Cold Deep Ocean", 25));
		
		regionalBiomes.add(new RegionalBiome(new Color(190, 196, 196), "Glacier", 10));
		regionalBiomes.add(new RegionalBiome(new Color(75, 75, 75), "Ore Rich", 10));
		regionalBiomes.add(new RegionalBiome(new Color(76, 76, 76), "Stoney", 80));
		
		regionalBiomes.add(new RegionalBiome(new Color(4, 117, 40), "Grasslands", 50));
		regionalBiomes.add(new RegionalBiome(new Color(41, 123, 230), "Lake", 50));
	}
	
	/**
	 * Helper method, builds and adds all the world biomes.
	 * @author Jay Clegg
	 */
	private void addWorldBiomes()
	{
		worldBiomes.add(new WorldBiome(new Color(10, 10, 107), "Deep Ocean", 65));
		worldBiomes.add(new WorldBiome(new Color(12, 94, 112), "Shallow Ocean", 6));
		worldBiomes.add(new WorldBiome(new Color(116, 130, 23), "Desert", 10));
		worldBiomes.add(new WorldBiome(new Color(99, 127, 150), "Icy Ocean", 1));
		worldBiomes.add(new WorldBiome(new Color(54, 63, 71), "Mountainous", 5));
		worldBiomes.add(new WorldBiome(new Color(75, 153, 105), "Fertile", 13));
	}
	
	/**
	 * Gets the index of the local biome with the specified name recursively.
	 * @author Jay Clegg
	 * @param source The array list of local biomes.
	 * @param name The name of the desired local biome.
	 * @param low The smallest possible index (Usually 0).
	 * @param high The largest possible index (Usually size).
	 * @return The index of the desired local biome.
	 * @throws A null pointer exception if there is no such local biome.
	 */
	private int indexOfLocal(ArrayList<LocalBiome> source, String name, int low, int high)
	{
		try
		{
			int middle = (low + high) / 2;
			if(source.get(middle).getName().equals(name)) return middle;
			else if(source.get(middle).getName().compareTo(name) > 0) return indexOfLocal(source, name, low, middle - 1);
			else return indexOfLocal(source, name, middle + 1, high);
		}
		catch(StackOverflowError stackOverflow)
		{
			throw new NullPointerException("No such local biome.");
		}
	}
	
	/**
	 * Gets the index of the regional biome with the specified name recursively.
	 * @author Jay Clegg
	 * @param source The array list of regional biomes.
	 * @param name The name of the desired regional biome.
	 * @param low The smallest possible index (Usually 0).
	 * @param high The largest possible index (Usually size).
	 * @return The index of the desired regional biome.
	 * @throws A null pointer exception if there is no such regional biome.
	 */
	private int indexOfRegional(ArrayList<RegionalBiome> source, String name, int low, int high)
	{
		try
		{
			int middle = (low + high) / 2;
			if(source.get(middle).getName().equals(name)) return middle;
			else if(source.get(middle).getName().compareTo(name) > 0) return indexOfRegional(source, name, low, middle - 1);
			else return indexOfRegional(source, name, middle + 1, high);
		}
		catch(StackOverflowError stackOverflow)
		{
			throw new NullPointerException("No such regional biome.");
		}
	}
	
	/**
	 * Gets the index of the world biome with the specified name recursively.
	 * @author Jay Clegg
	 * @param source The array list of world biomes.
	 * @param name The name of the desired world biome.
	 * @param low The smallest possible index (Usually 0).
	 * @param high The largest possible index (Usually size).
	 * @return The index of the desired world biome.
	 * @throws A null pointer exception if there is no such world biome.
	 */
	private int indexOfWorld(ArrayList<WorldBiome> source, String name, int low, int high)
	{
		try
		{
			int middle = (low + high) / 2;
			if(source.get(middle).getName().equals(name)) return middle;
			else if(source.get(middle).getName().compareTo(name) > 0) return indexOfWorld(source, name, low, middle - 1);
			else return indexOfWorld(source, name, middle + 1, high);
		}
		catch(StackOverflowError stackOverflow)
		{
			throw new NullPointerException("No such world biome");
		}
	}
	
	/**
	 * Returns the local biome with the specified name.
	 * @author Jay Clegg
	 * @param name The name of the biome.
	 * @return The local biome with that name.
	 */
	public LocalBiome getLocalBiome(String name)
	{
		return localBiomes.get(indexOfLocal(localBiomes, name, 0, localBiomes.size()));
	}
	
	/**
	 * Returns the regional biome with the specified name.
	 * @author Jay Clegg
	 * @param name The name of the biome.
	 * @return The regional biome with that name.
	 */
	public RegionalBiome getRegionalBiome(String name)
	{
		return regionalBiomes.get(indexOfRegional(regionalBiomes, name, 0, regionalBiomes.size()));
	}
	
	/**
	 * Returns the world biome with the specified name.
	 * @author Jay Clegg
	 * @param name The name of the biome.
	 * @return The world biome with that name.
	 */
	public WorldBiome getWorldBiome(String name)
	{
		return worldBiomes.get(indexOfWorld(worldBiomes, name, 0, worldBiomes.size()));
	}
}
