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
	/**
	 * If the empire is a mid game empire.
	 * @author Jay Clegg
	 */
	private boolean isMidgame;
	
	/**
	 * A list of all the maps in the empire. Usually just the world map since that holds everything else.
	 * @author Jay Clegg
	 */
	private ArrayList<EmpireMap> maps;
	
	/**
	 * If the map selector has been added.
	 * @author Jay Clegg
	 */
	private boolean mapSelectorAdded;
	
	/**
	 * The name of the empire.
	 * @author Jay Clegg
	 */
	private String name;
	
	/**
	 * The starting local map.
	 * @author Jay Clegg
	 */
	private EmpireLocalMap origin;
	
	/**
	 * The starting regional map for this empire.
	 * @author Jay Clegg
	 */
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
		this.mapSelectorAdded = false;
		this.maps = new ArrayList<EmpireMap>();
		this.startingMap = null;
		this.origin = null;
	}
	
	public void addMap(EmpireMap map)
	{
		maps.add(map);
	}
	
	/**
	 * Checks if a full region has been explored. Updates the value of midgame accordingly.
	 * @author Jay Clegg
	 */
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
	
	/**
	 * @return The mapSelectorAdded.
	 */
	public boolean getMapSelectorAdded()
	{
		return mapSelectorAdded;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public EmpireLocalMap getOrigin()
	{
		return origin;
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
	 * @param mapSelectorAdded The new value of mapSelectorAdded.
	 */
	public void setMapSelectorAdded(boolean mapSelectorAdded)
	{
		this.mapSelectorAdded = mapSelectorAdded;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public void setOrigin(EmpireLocalMap origin)
	{
		this.origin = origin;
	}

	public void setStartingMap(EmpireRegionalMap startingMap)
	{
		this.startingMap = startingMap;
	}
}
