package game.model.biomes;

import java.awt.Color;
import java.io.Serializable;

public abstract class Biome implements Comparable<Biome>, Serializable
{
	protected Color color;
	protected final String NAME;
	protected final int WEIGHT;
	
	public Biome(Color color, String name, int weight)
	{
		this.color = color;
		this.NAME = name;
		this.WEIGHT = weight;
	}
	
	public Color getColor()
	{
		return this.color;
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
	public int compareTo(Biome otherBiome)
	{
		return this.NAME.compareTo(otherBiome.getName());
	}
}
