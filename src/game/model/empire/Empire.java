package game.model.empire;

import java.io.Serializable;
import java.util.ArrayList;

import game.controller.MapController;
import game.model.maps.EmpireLocalMap;
import game.model.maps.EmpireMap;
import game.model.maps.EmpireRegionalMap;
import game.model.maps.EmpireWorldMap;

/**
 * The model for an empire.
 * @author Jay Clegg
 *
 */
public class Empire implements Serializable
{
	private String name;
	private boolean isMidgame;
	private boolean mapSelectorAdded;
	private ArrayList<EmpireMap> maps;
	private EmpireRegionalMap startingMap;
	
	/**
	 * Builds an empire based on the specified parameters.
	 * @author Jay Clegg
	 * @param name The name of the empire.
	 */
	public Empire(String name)
	{
		this.name = name;
		this.isMidgame = false;
		this.maps = new ArrayList<EmpireMap>();
		this.startingMap = null;
		this.setMapSelectorAdded(false);
	}
	
	public void setStartingMap(EmpireRegionalMap startingMap)
	{
		this.startingMap = startingMap;
	}
	
	public void addMap(EmpireMap map)
	{
		maps.add(map);
	}
	
	public void removeLocalMaps()
	{
		for(EmpireMap map : maps)
		{
			try
			{
				EmpireLocalMap localMap = (EmpireLocalMap) map;
				
				maps.remove(maps.indexOf(localMap));
			}
			catch(ClassCastException invalidCast)
			{
				//Nothing has to be done with these.
			}
		}
	}

	public void checkMidgame()
	{
		for(EmpireLocalMap localMap : startingMap.getLocalMaps())
		{
			int numLocations = startingMap.getCols() * startingMap.getRows() * localMap.getRows() * localMap.getCols();
			int numExplored = 0;
			
			for(int row = 0; row < localMap.getRows(); row ++)
			{
				for(int col = 0; col < localMap.getCols(); col++)
				{
					if(localMap.getState(row, col) == MapController.EXPLORED) numExplored++;
				}
			}
			
			isMidgame = numLocations == numExplored;
		}
	}
	
	public boolean getIsMidgame()
	{
		return isMidgame;
	}
	
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public EmpireRegionalMap getStartingMap()
	{
		return startingMap;
	}
	
	public EmpireWorldMap getWorldMap()
	{
		for(EmpireMap map : maps)
		{
			if(map.getLevel().equals(MapController.WORLD))
			{
				return (EmpireWorldMap) map;
			}
		}
		
		return null;
	}

	/**
	 * @return The mapSelectorAdded.
	 */
	public boolean getMapSelectorAdded()
	{
		return mapSelectorAdded;
	}

	/**
	 * @param mapSelectorAdded The new value of mapSelectorAdded.
	 */
	public void setMapSelectorAdded(boolean mapSelectorAdded)
	{
		this.mapSelectorAdded = mapSelectorAdded;
	}
}
