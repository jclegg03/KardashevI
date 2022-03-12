package game.model.biomes;

import java.util.ArrayList;

import game.model.units.Building;

public interface Allows
{
	public ArrayList<Building> getAllowedBuildings();
	public void addAllowed(Building building);
}
