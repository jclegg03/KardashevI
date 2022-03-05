package game.controller;

import java.io.Serializable;

import game.view.buildingMenu.BuildingMenu;
import game.view.exploreMenu.ExploreMenu;

public class MapController implements Serializable
{
	private Controller app;
	private BuildingMenu buildingMenu;
	private ExploreMenu exploreMenu;
}
