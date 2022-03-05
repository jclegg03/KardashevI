package game.controller;

import java.io.Serializable;
import java.util.HashMap;

import game.view.buildingMenu.BuildingMenu;
import game.view.exploreMenu.ExploreMenu;

public class MapController implements Serializable
{
	private Controller app;
	private BuildingMenu buildingMenu;
	private ExploreMenu exploreMenu;
	private game.model.maps.WorldMap worldMapModel;
	private game.view.maps.WorldMap worldMapView;
	private HashMap<game.model.maps.RegionalMap, game.view.maps.RegionalMap> regionalMaps;
	private HashMap<game.model.maps.LocalMap, game.view.maps.LocalMap> localMaps;
	
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
}
