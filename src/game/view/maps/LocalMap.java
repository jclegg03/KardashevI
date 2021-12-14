package game.view.maps;

import java.awt.Color;
import java.awt.Dimension;

public class LocalMap extends Map
{
	private String name;
	
	public LocalMap()
	{
		super(10, 20);
		this.setVisible(true);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}
