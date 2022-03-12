package game.model.biomes;

import java.awt.Color;

public abstract class Biome
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
}
