package game.controller;

import java.io.Serializable;
import java.util.HashMap;

import game.view.buildingMenu.BuildingMenu;
import game.view.exploreMenu.ExploreMenu;

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
	private game.model.maps.WorldMap worldMapModel;
	private game.view.maps.WorldMap worldMapView;
	private HashMap<game.model.maps.RegionalMap, game.view.maps.RegionalMap> regionalMaps;
	private HashMap<game.model.maps.LocalMap, game.view.maps.LocalMap> localMaps;
	
	/**
	 * Builds a MapController with the specified parameters.
	 * @author Jay Clegg
	 * @param app The Controller that owns this class.
	 * @param worldMapModel The WorldMap in the model.
	 * @param worldMapView The WorldMap in the view.
	 * @param regionalMapModels The RegionalMaps in the model.
	 * @param regionalMapViews The RegionalMaps in the view.
	 * @param localMapModels The LocalMaps in the model.
	 * @param localMapViews The LocalMaps in the view.
	 */
	public MapController(Controller app, game.model.maps.WorldMap worldMapModel, game.view.maps.WorldMap worldMapView,
			game.model.maps.RegionalMap[] regionalMapModels, game.view.maps.RegionalMap[] regionalMapViews,
			game.model.maps.LocalMap[] localMapModels, game.view.maps.LocalMap[] localMapViews)
	{
		this.app = app;
		this.worldMapModel = worldMapModel;
		this.worldMapView = worldMapView;
		this.regionalMaps = new HashMap<game.model.maps.RegionalMap, game.view.maps.RegionalMap>();
		this.localMaps = new HashMap<game.model.maps.LocalMap, game.view.maps.LocalMap>();
		
		for(int index = 0; index < regionalMapModels.length; index++)
		{
			regionalMaps.put(regionalMapModels[index], regionalMapViews[index]);
		}
		
		for(int index = 0; index < localMapModels.length; index++)
		{
			localMaps.put(localMapModels[index], localMapViews[index]);
		}
	}
	
	public void setValue(String level, String id, int row, int col, int newValue)
	{
		
	}
	
	public int getValue(String level, String id, int row, int col)
	{
		int value = 0;
		game.model.maps.Map map = null;
		
		if(level.equals(WORLD))
		{
			map = worldMapModel;
		}
		else
		{
			map = selectMapModel(level, row, col);
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
	
	private game.model.maps.Map selectMapModel(String level, String id, int row, int col)
	{
		game.model.maps.Map map = null;
		
		if(level.equals(LOCAL))
		{
			
		}
		
		return map;
	}
	
	private game.view.maps.Map selectMapView(String level, int row, int col)
	{
		game.view.maps.Map map = null;
		
		
		
		return map;
	}
}
