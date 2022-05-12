package game.model.biomes;

import java.awt.Color;
import java.io.Serializable;

/**
 * The parent class for all types of biomes.
 * @author Jay Clegg
 *
 */
public abstract class Biome implements Comparable<Biome>, Serializable
{
	/**
	 * The color of this biome.
	 * @author Jay Clegg
	 */
	protected final Color COLOR;
	
	/**
	 * The name of this biome.
	 * @author Jay Clegg
	 */
	protected final String NAME;
	
	/**
	 * How frequently this biome generates.
	 * @author Jay Clegg
	 */
	protected final int WEIGHT;
	
	/**
	 * Builds a biome with the specified color, name, and weight.
	 * @author Jay Clegg
	 * @param color The color this biome will have when displayed.
	 * @param name The name of this biome.
	 * @param weight How frequently this biome should show up.
	 */
	public Biome(Color color, String name, int weight)
	{
		this.COLOR = color;
		this.NAME = name;
		this.WEIGHT = weight;
	}
	
	@Override
	public int compareTo(Biome otherBiome)
	{
		return this.NAME.compareTo(otherBiome.getName());
	}
	
	/**
	 * Makes a copy of the biome.
	 * @author Jay Clegg
	 * @return The copy of the biome.
	 */
	public abstract Biome copy();
	
	@Override
	public boolean equals(Object biome)
	{
		try
		{
			return ((Biome) (biome)).getName().equals(this.getName());
		}
		catch(Exception error)
		{
			return false;
		}
	}
	
	public Color getColor()
	{
		return this.COLOR;
	}
	
	public String getName()
	{
		return this.NAME;
	}
	
	public int getWeight()
	{
		return this.WEIGHT;
	}
	
	@Override
	public String toString()
	{
		return this.NAME;
	}
}
