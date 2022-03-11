package game.controller;

import java.io.Serializable;
import java.util.HashMap;

import game.model.maps.EmpireLocalMap;
import game.model.maps.EmpireMap;
import game.model.maps.EmpireRegionalMap;
import game.model.maps.EmpireWorldMap;
import game.view.buildingMenu.BuildingMenu;
import game.view.exploreMenu.ExploreMenu;
import game.view.gameView.GameFrame;
import game.view.maps.LocalMap;
import game.view.maps.Map;
import game.view.maps.RegionalMap;
import game.view.maps.Tile;
import game.view.maps.WorldMap;

/**
 * This class moves data from the model to the view and vice versa.
 * @author Jay Clegg
 *
 */
public class MapController implements Serializable
{
	public static final int OWNED = 0;
	public static final int CLAIMED = 1;
	public static final int EXPLORED = 2;
	public static final int UNEXPLORED = 3;
	public static final String LOCAL = "Local";
	public static final String REGIONAL = "Regional";
	public static final String WORLD = "World";
	private Controller app;
	private BuildingMenu buildingMenu;
	private ExploreMenu exploreMenu;
	private EmpireWorldMap worldMapModel;
	private WorldMap worldMapView;
	private HashMap<EmpireRegionalMap, RegionalMap> regionalMaps;
	private HashMap<EmpireLocalMap, LocalMap> localMaps;
	private Tile selectedTile;
	
	/**
	 * Builds a MapController with the specified parameters.
	 * @author Jay Clegg
	 * @param app The Controller that owns this class.
	 */
	public MapController(Controller app)
	{
		this.app = app;
		this.regionalMaps = new HashMap<EmpireRegionalMap, RegionalMap>();
		this.localMaps = new HashMap<EmpireLocalMap, LocalMap>();
		
		buildMaps();
	}
	
	private void buildMaps()
	{
		
	}
	
	public void setValue(String level, String id, int row, int col, int newValue)
	{
		
	}
	
	public int getValue(String level, String id, int row, int col)
	{
		int value = 0;
		EmpireMap map = null;
		
		if(level.equals(WORLD))
		{
			map = worldMapModel;
		}
		else
		{
			map = selectMapModel(level, id, row, col);
		}
		
		value = map.getValue(row, col);
		
		return value;
	}
	
	public void updateUI()
	{
		
	}
	
	public void goTo()
	{
		
	}
	
	private EmpireMap selectMapModel(String level, String id, int row, int col)
	{
		if(level.equals(LOCAL))
		{
			for(EmpireLocalMap localMap : localMaps.keySet())
			{
				if(localMap.getId().equals(id))
				{
					return (EmpireMap) localMap;
				}
			}
		}
		else
		{
			for(EmpireRegionalMap regionalMap : regionalMaps.keySet())
			{
				if(regionalMap.getId().equals(id))
				{
					return (EmpireMap) regionalMap; 
				}
			}
		}
		
		return null;
	}
	
	private Map selectMapView(String level, int row, int col)
	{
		Map map = null;
		
		
		
		return map;
	}
	
	/**
	 * Once a tile is clicked, this method gives the option to explore or build on it.
	 * @author Jay Clegg
	 * @param tile
	 */
	public void tileOptions(Tile tile)
	{
		this.selectedTile = tile;
		
		if(tile.getIsExplored())
		{
			buildingMenu();
		}
		else
		{
			exploreMenu();
		}
		app.returnFocus();
	}
	
	/**
	 * Handles the building menu.
	 * @author Jay Clegg
	 */
	private void buildingMenu()
	{
		if(buildingMenu != null)
		{
			buildingMenu.dispose();
		}
		buildingMenu = new BuildingMenu(this, (GameFrame) app.getFrame(), selectedTile);
	}
	
	/**
	 * Handles the explore menu.
	 * @author Jay Clegg
	 */
	private void exploreMenu()
	{
		if(exploreMenu != null)
		{
			exploreMenu.dispose();
		}
		exploreMenu = new ExploreMenu(this, (GameFrame) app.getFrame(), selectedTile);
	}
	
	@WIP
	public void exploreTile()
	{
		selectedTile.setIsExplored(true);
		exploreMenu.dispose();
	}
}
