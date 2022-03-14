package game.model.maps;

import game.model.biomes.Biome;
import game.model.empire.Empire;

public class EmpireLocalMap extends EmpireMap
{
	public EmpireLocalMap(Empire empire)
	{
		super(20, 20, empire);
	}
	
	@Override @Deprecated
	public EmpireMap getMap(int row, int col)
	{
		return null;
	}

	@Override @Deprecated
	public void addMap(int row, int col, EmpireMap map)
	{
	}
}
