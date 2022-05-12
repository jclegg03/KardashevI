package game.controller;	

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import game.model.biomes.Biome;
import game.model.biomes.LocalBiome;
import game.model.biomes.RegionalBiome;
import game.model.biomes.WorldBiome;
import game.model.empire.Empire;
import game.model.lists.BiomeList;
import game.model.maps.EmpireLocalMap;
import game.model.maps.EmpireMap;
import game.model.maps.EmpireRegionalMap;
import game.model.maps.EmpireWorldMap;
import game.model.maps.Location;
import game.view.buildingMenu.BuildingMenu;
import game.view.exploreMenu.ExploreMenu;
import game.view.gameView.GameContentPane;
import game.view.gameView.GameFrame;
import game.view.maps.LocalMap;
import game.view.maps.Map;
import game.view.maps.RegionalMap;
import game.view.maps.Tile;
import game.view.maps.WorldMap;

/**
 * Builds and maintains the maps used in the game.
 * @author Jay Clegg
 *
 */
/**
 * @author Jay Clegg
 *
 */
public class MapController implements Serializable
{
	/**
	 * A value to represent an empire's claimed territory.
	 * @author Jay Clegg
	 */
	public static final int CLAIMED = 1;
	
	/**
	 * A value to represent an empire's explored territory.
	 * @author Jay Clegg
	 */
	public static final int EXPLORED = 2;
	
	/**
	 * A value to designate a map as a local map.
	 * @author Jay Clegg
	 */
	public static final String LOCAL = "Local";
	
	/**
	 * A value to represent an empire's owned territory.
	 * @author Jay Clegg
	 */
	public static final int OWNED = 0;
	
	/**
	 * A value to designate a map as a regional map.
	 * @author Jay Clegg
	 */
	public static final String REGIONAL = "Regional";
	
	/**
	 * A value to represent an empire's unexplored territory.
	 * @author Jay Clegg
	 */
	public static final int UNEXPLORED = 3;
	
	/**
	 * A value to designate a map as a world map.
	 * @author Jay Clegg
	 */
	public static final String WORLD = "World";
	
	/**
	 * The controller this reports to.
	 * @author Jay Clegg
	 */
	private Controller app;
	
	/**
	 * The list of all the biomes. Used only to generate a map for the first time.
	 * @author Jay Clegg
	 */
	private BiomeList biomes;
	
	/**
	 * The currently displayed building menu.<br>
	 * This is not initialized by the constructor.
	 * @author Jay Clegg
	 */
	private BuildingMenu buildingMenu;
	
	/**
	 * The column of the current regional map. Used to select the correct local map from the regional map.
	 * @author Jay Clegg
	 */
	private int currentCol;
	
	/**
	 * The currently displayed map.
	 * @author Jay Clegg
	 */
	private Map currentMap;
	
	/**
	 * The row of the current regional map. Used to select the correct local map from the regional map.
	 * @author Jay Clegg
	 */
	private int currentRow;
	
	/**
	 * The currently displayed exploring menu.<br>
	 * This is not initialized by the constructor.
	 * @author Jay Clegg
	 */
	private ExploreMenu exploreMenu;
	
	/**
	 * A hash map with all the local maps in the model as keys and the corresponding local maps in the view as the values.
	 * @author Jay Clegg
	 */
	private HashMap<EmpireLocalMap, LocalMap> localMaps;
	
	/**
	 * The previous regional map. Used when zooming out from a local map to a regional map.
	 * @author Jay Clegg
	 */
	private RegionalMap previousMap;
	
	/**
	 * A hash map with all the regional maps in the model as keys and the corresponding regional maps in the view as the values.
	 * @author Jay Clegg
	 */
	private HashMap<EmpireRegionalMap, RegionalMap> regionalMaps;
	
	/**
	 * The currently selected tile. Used to determine which map to go to.<br>
	 * This is not initialized in the constructor.
	 * @author Jay Clegg
	 */
	private Tile selectedTile;
	
	/**
	 * The world map inside the model.
	 * @author Jay Clegg
	 */
	private EmpireWorldMap worldMapModel;
	
	/**
	 * The world map in the view.
	 * @author Jay Clegg
	 */
	private WorldMap worldMapView;
	
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
		this.biomes = new BiomeList();
		
		buildMaps();
		
		//This fully explores the starting map minus one square.
		//The one square has to not be explored so the map selector will appear.
//		fullyExplore(selectMapModel(currentMap));
//		currentMap.getTile(0, 0).setOpaque(false);
//		selectMapModel(currentMap).setState(0, 0, UNEXPLORED);
		
		//This fully explores the starting region minus one square.
		//The one square has to not be explored so the map selector will appear.
//		fullyExplore(selectMapModel(previousMap));
//		currentMap.getTile(0, 0).setOpaque(false);
//		selectMapModel(currentMap).setState(0, 0, UNEXPLORED);
		
		//This fully explores the world minus one square.
		//The one square has to not be explored so the map selector will appear.
//		fullyExplore(worldMapModel);
//		currentMap.getTile(0, 0).setOpaque(false);
//		selectMapModel(currentMap).setState(0, 0, UNEXPLORED);
		
		assignMaps();
	}
	
	/**
	 * Builds a map controller from a loaded empire.
	 * @author Jay Clegg
	 * @param empire The loaded empire.
	 * @param app The controller this reports to.
	 */
	public MapController(Empire empire, Controller app)
	{
		this.app = app;
		this.regionalMaps = new HashMap<EmpireRegionalMap, RegionalMap>();
		this.localMaps = new HashMap<EmpireLocalMap, LocalMap>();
		this.worldMapModel = empire.getWorldMap();
		
		loadMaps();
		
		fullyExplore(worldMapModel);
	}
	
	/**
	 * Gives the empire any maps it needs. Usually because it needs to be saved. Only the world map model is saved since it also
	 *  contains all the regional and local maps.
	 * @author Jay Clegg
	 */
	private void assignMaps()
	{
		app.getEmpire().addMap(worldMapModel);
	}
	
	/**
	 * Handles the building menu.
	 * @author Jay Clegg
	 */
	private void buildingMenu()
	{
		buildingMenu = new BuildingMenu(this, (GameFrame) app.getFrame(), selectedTile);
	}
	
	/**
	 * Builds all the local maps.
	 * @author Jay Clegg
	 */
	private void buildLocalMaps()
	{
		for(EmpireRegionalMap region : worldMapModel.getRegionalMaps())
		{
			for(EmpireLocalMap currentMap : region.getLocalMaps())
			{
				RegionalBiome currentBiome = currentMap.getParentBiome();
				
				LocalMap mapView = new LocalMap(this);
				
				for(int row = 0; row < currentMap.getRows(); row++)
				{
					for(int col = 0; col < currentMap.getCols(); col++)
					{
						LocalBiome current;
						int random = randomNumber();
						
						if(currentBiome.equals(biomes.getRegionalBiome("Deep Ocean")))
						{
							current = biomes.getLocalBiome("Deep Ocean");
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Shallow Ocean")))
						{
							current = biomes.getLocalBiome("Shallow Ocean");
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Reef")))
						{
							current = biomes.getLocalBiome("Reef");
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Shore")))
						{
							current = biomes.getLocalBiome("Shore");
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Desert")))
						{
							if(random < 99)
							{
								current = biomes.getLocalBiome("Desert");
							}
							else
							{
								current = biomes.getLocalBiome("Oasis");
							}
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Oasis")))
						{
							if(random < 33)
							{
								current = biomes.getLocalBiome("Water");
							}
							else if(random < 66)
							{
								current = biomes.getLocalBiome("Fertile");
							}
							else
							{
								current = biomes.getLocalBiome("Sand");
							}
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Iceberg")))
						{
							if(random < 90)
							{
								current = biomes.getLocalBiome("Ice");
							}
							else
							{
								current = biomes.getLocalBiome("Icy Ocean");
							}
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Cold Deep Ocean")))
						{
							if(random < 5)
							{
								current = biomes.getLocalBiome("Small Berg");
							}
							else
							{
								current = biomes.getLocalBiome("Cold Deep Ocean");
							}
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Glacier")))
						{
							if(random < 99)
							{
								current = biomes.getLocalBiome("Glacier");
							}
							else
							{
								current = biomes.getLocalBiome("Diamond");
							}
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Ore Rich")))
						{
							if(random < 10)
							{
								current = biomes.getLocalBiome("Stone");
							}
							else
							{
								current = biomes.getLocalBiome("Ore Rich");
							}
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Stoney")))
						{
							if(random < 20)
							{
								current = biomes.getLocalBiome("Coal");
							}
							else
							{
								current = biomes.getLocalBiome("Stoney");
							}
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Grasslands")))
						{
							if(random < 95)
							{
								current = biomes.getLocalBiome("Grasslands");
							}
							else
							{
								current = biomes.getLocalBiome("Small Lake");
							}
						}
						
						else if(currentBiome.equals(biomes.getRegionalBiome("Lake")))
						{
							if(random < 25)
							{
								current = biomes.getLocalBiome("Island");
							}
							else
							{
								current = biomes.getLocalBiome("Large Lake");
							}
						}
						
						else current = null;
						
						currentMap.assignLocation(new Location(row, col, current.copy(), null));
						mapView.getTile(row, col).setBackground(current.getColor());
						currentMap.setState(row, col, UNEXPLORED);
					}
				}
				localMaps.put(currentMap, mapView);
			}
		}
		
		exploreRandomLocation();
	}
	
	/**
	 * Builds the maps for the game.
	 * @author Jay Clegg
	 */
	private void buildMaps()
	{
		buildWorldMap();
		buildRegionalMaps();
		buildLocalMaps();
	}
	
	/**
	 * Builds all the regional maps.
	 * @author Jay Clegg
	 */
	private void buildRegionalMaps()
	{
			for(EmpireRegionalMap currentMap : worldMapModel.getRegionalMaps())
			{
				RegionalMap mapView = new RegionalMap(this);
				WorldBiome currentBiome = currentMap.getParentBiome();
				
				for(int row = 0; row < currentMap.getRows(); row++)
				{
					for(int col = 0; col < currentMap.getCols(); col++)
					{
						int random = randomNumber();
						RegionalBiome current;
						if(currentBiome.equals(biomes.getWorldBiome("Deep Ocean")))
						{
							current = biomes.getRegionalBiome("Deep Ocean");
						}
						
						else if(currentBiome.equals(biomes.getWorldBiome("Shallow Ocean")))
						{
							if(random < 80) current = biomes.getRegionalBiome("Shallow Ocean");
							else if(random < 90) current = biomes.getRegionalBiome("Reef");
							else current = biomes.getRegionalBiome("Shore");
						}
						
						else if(currentBiome.equals(biomes.getWorldBiome("Desert")))
						{
							if(random < 99) current = biomes.getRegionalBiome("Desert");
							else current = biomes.getRegionalBiome("Oasis");
						}
						
						else if(currentBiome.equals(biomes.getWorldBiome("Icy Ocean")))
						{
							if(random < 75) current = biomes.getRegionalBiome("Iceberg");
							else current = biomes.getRegionalBiome("Cold Deep Ocean");
						}
						
						else if(currentBiome.equals(biomes.getWorldBiome("Mountainous")))
						{
							if(random < 10) current = biomes.getRegionalBiome("Glacier");
							else if(random < 20) current = biomes.getRegionalBiome("Ore Rich");
							else current = biomes.getRegionalBiome("Stoney");
						}
						
						else if(currentBiome.equals(biomes.getWorldBiome("Fertile")))
						{
							if(random < 50) current = biomes.getRegionalBiome("Grasslands");
							else current = biomes.getRegionalBiome("Lake");
						}
						
						else current = null;
						
						currentMap.assignLocation(new Location(row, col, current.copy(), null));
						mapView.getTile(row, col).setBackground(current.getColor());
						currentMap.addMap(row, col, new EmpireLocalMap(current, new Location(row, col, null, null)));
						currentMap.setState(row, col, UNEXPLORED);
					}
				}
				
				regionalMaps.put(currentMap, mapView);
			}
			
			exploreRandomLocalMap();
	}
	
	/**
	 * Builds the world maps
	 * @author Jay Clegg
	 */
	private void buildWorldMap()
	{
		worldMapModel = new EmpireWorldMap();
		worldMapView = new WorldMap(this);
		
		for(int row = 0; row < worldMapModel.getRows(); row++)
		{
			for(int col = 0; col < worldMapModel.getCols(); col++)
			{
				WorldBiome current;
				int number = randomNumber();
				if(number < 50) current = this.biomes.getWorldBiome("Deep Ocean");
				else if(number < 71) current = this.biomes.getWorldBiome("Shallow Ocean");
				else if(number < 81) current = this.biomes.getWorldBiome("Desert");
				else if(number < 82) current = this.biomes.getWorldBiome("Icy Ocean");
				else if(number < 87) current = this.biomes.getWorldBiome("Mountainous");
				else current = this.biomes.getWorldBiome("Fertile");
				
				worldMapModel.assignLocation(new Location(row, col, current.copy(), null));
				
				worldMapView.getTile(row, col).setBackground(current.getColor());
				worldMapModel.addMap(row, col, new EmpireRegionalMap(current, new Location(row, col, null, null)));
				worldMapModel.setState(row, col, UNEXPLORED);
			}
		}
		
//		if(! worldContainsFertile())
//		{
//			biomes[(int) (Math.random() * 20)][(int) (Math.random() * 20)] = this.biomes.getWorldBiome("Fertile").copy();
//		}
		
		exploreRandomRegionalMap();
	}
	
	/**
	 * Checks if a tile can be explored.
	 * @author Jay Clegg
	 */
	private void checkExplore()
	{
		ArrayList<Location> adjecentTiles = new ArrayList<Location>();
		int row = selectedTile.getRow();
		int col = selectedTile.getCol();
		EmpireMap map = selectMapModel(currentMap);
		boolean canExplore = false;
		
		//right
		if(currentMap.getTile(row + 1, col) != null)
		{
			adjecentTiles.add(map.getLocation(row + 1, col));
		}
		
		//left
		if(currentMap.getTile(row - 1, col) != null)
		{
			adjecentTiles.add(map.getLocation(row - 1, col));
		}
		
		//up
		if(currentMap.getTile(row, col - 1) != null)
		{
			adjecentTiles.add(map.getLocation(row, col - 1));
		}
		
		//down
		if(currentMap.getTile(row, col + 1) != null)
		{
			adjecentTiles.add(map.getLocation(row, col + 1));
		}
		
		for(Location adjecent : adjecentTiles)
		{
			if(adjecent.getState() == EXPLORED)
			{
				canExplore = true;
			}
		}
		
		if(! canExplore && ! currentMap.getLevel().equals(WORLD))
		{
			HashMap<String, EmpireMap> adjecentMaps = getAdjecentMaps();
			EmpireMap north = adjecentMaps.get("north");
			EmpireMap south = adjecentMaps.get("south");
			EmpireMap east = adjecentMaps.get("east");
			EmpireMap west = adjecentMaps.get("west");
			int size = currentMap.getTiles2D().length;
			
			if(north != null && row == 0)
			{
				canExplore = north.getState(size - 1, col) == EXPLORED;
			}
			if(south != null && row == size - 1 && ! canExplore)
			{
				canExplore = south.getState(0, col) == EXPLORED;
			}
			if(east != null && col == size - 1 && ! canExplore)
			{
				canExplore = east.getState(row, 0) == EXPLORED;
			}
			if(west != null && col == 0 && ! canExplore)
			{
				canExplore = west.getState(row, size - 1) == EXPLORED;
			}
		}
		
		if(canExplore)
		{
			exploreMenu();
		}
	}
	
	/**
	 * This method can be used to check if there is a fertile biome for exploring.
	 * Not used since the odds of generation without a fertile biome is very low.
	 */
//	private boolean worldContainsFertile()
//	{
//		for(Biome[] row : worldMapModel.getBiomes2D())
//		{
//			for(Biome biome : row)
//			{
//				if(biome.equals((Biome) this.biomes.getWorldBiome("Fertile"))) return true;
//			}
//		}
//		
//		return false;
//	}
	
	/**
	 * Disposes of all displayed menus.
	 * @author Jay Clegg
	 */
	private void clearMenus()
	{
		if(buildingMenu != null)
		{
			buildingMenu.dispose();
		}
		
		if(exploreMenu != null)
		{
			exploreMenu.dispose();
		}
	}
	
	/**
	 * Makes the explore menu.
	 * @author Jay Clegg
	 */
	private void exploreMenu()
	{
		exploreMenu = new ExploreMenu(this, (GameFrame) app.getFrame());
	}
	
	/**
	 * Explores a random local map on the explored regional map.
	 * @author Jay Clegg
	 */
	private void exploreRandomLocalMap()
	{
		ArrayList<int[]> locations = new ArrayList<int[]>();
		RegionalMap regionExplored = null;
		for(Location location : worldMapModel.getLocations())
		{
			if(location.getState() == EXPLORED)
			{
				regionExplored = regionalMaps.get(worldMapModel.getMap(location.getRow(), location.getCol()));
			}
		}
		
		EmpireRegionalMap regionalMap = (EmpireRegionalMap) selectMapModel(regionExplored);
		
		for(int row = 0; row < regionalMap.getBiomes2D().length; row++)
		{
			for(int col = 0; col < regionalMap.getBiomes2D()[0].length; col++)
			{
				if(regionalMap.getBiome(row, col).equals(biomes.getRegionalBiome("Grasslands")))
				{
					int[] location = {row, col};
					locations.add(location);
				}
			}
		}
		
		int random = (int) (Math.random() * locations.size());
		int row = locations.get(random)[0];
		int col = locations.get(random)[1];
		regionExplored.getTile(row, col).setOpaque(true);
		regionalMap.setState(row, col, EXPLORED);
		selectedTile = regionExplored.getTile(row, col);
	}
	
	/**
	 * Explores a random 3 x 3 square of tiles on the explored local map.
	 * @author Jay Clegg
	 */
	private void exploreRandomLocation()
	{
		EmpireRegionalMap region = null;
		for(Location location : worldMapModel.getLocations())
		{
			if(location.getState() == EXPLORED)
			{
				region = worldMapModel.getMap(location.getRow(), location.getCol());
			}
		}
		app.getEmpire().setStartingMap(region);
		
		EmpireLocalMap exploredMap = null;
		
		for(int row = 0; row < region.getRows(); row++)
		{
			for(int col = 0; col < region.getCols(); col++)
			{
				if(region.getState(row, col) == EXPLORED)
				{
					exploredMap = region.getMap(row, col);
				}
			}
		}
		LocalMap mapView = localMaps.get(exploredMap);
		
		int randRow = (int) (Math.random() * (exploredMap.getBiomes2D().length - 2)) + 1;
		int randCol = (int) (Math.random() * (exploredMap.getBiomes2D()[0].length - 2)) + 1;
		
		exploredMap.setState(randRow, randCol, EXPLORED);
		exploredMap.setState(randRow - 1, randCol, EXPLORED);
		exploredMap.setState(randRow + 1, randCol, EXPLORED);
		mapView.getTile(randRow, randCol).setOpaque(true);
		mapView.getTile(randRow + 1, randCol).setOpaque(true);
		mapView.getTile(randRow - 1, randCol).setOpaque(true);
		
		randCol--;
		exploredMap.setState(randRow, randCol, EXPLORED);
		exploredMap.setState(randRow - 1, randCol, EXPLORED);
		exploredMap.setState(randRow + 1, randCol, EXPLORED);
		mapView.getTile(randRow, randCol).setOpaque(true);
		mapView.getTile(randRow + 1, randCol).setOpaque(true);
		mapView.getTile(randRow - 1, randCol).setOpaque(true);
		
		randCol += 2;
		exploredMap.setState(randRow, randCol, EXPLORED);
		exploredMap.setState(randRow - 1, randCol, EXPLORED);
		exploredMap.setState(randRow + 1, randCol, EXPLORED);
		mapView.getTile(randRow, randCol).setOpaque(true);
		mapView.getTile(randRow + 1, randCol).setOpaque(true);
		mapView.getTile(randRow - 1, randCol).setOpaque(true);
		
		previousMap = regionalMaps.get(region);
		currentMap = mapView;
		app.getEmpire().setOrigin(exploredMap);
	}
	
	/**
	 * Explores a random regional map on the world map.
	 * This will only explore a fertile region.
	 * @author Jay Clegg
	 */
	private void exploreRandomRegionalMap()
	{
		ArrayList<int[]> locations = new ArrayList<int[]>();
		
		for(int row = 0; row < worldMapModel.getBiomes2D().length; row++)
		{
			for(int col = 0; col < worldMapModel.getBiomes2D()[row].length; col++)
			{
				if(worldMapModel.getBiome(row, col).equals(this.biomes.getWorldBiome("Fertile")))
				{
					int[] current = new int[2];
					current[0] = row;
					current[1] = col;
					locations.add(current);
				}
			}
		}
		
		int random = (int) (Math.random() * locations.size());
		int row = locations.get(random)[0];
		int col = locations.get(random)[1];
		worldMapView.getTile(row, col).setOpaque(true);	
		setValue(worldMapModel, row, col, EXPLORED);
		currentRow = row;
		currentCol = col;
		selectedTile = worldMapView.getTile(row, col);
	}
	
	/**
	 * Finds the adjacent maps to the current map.
	 * @author Jay Clegg
	 * @return A hash map of string keys (north, south, east, west) and the maps. These maps are the maps adjacent to the current map.
	 */
	private HashMap<String, EmpireMap> getAdjecentMaps()
	{
		EmpireMap current = selectMapModel(currentMap);
		EmpireMap previous = selectMapModel(previousMap);
		HashMap<String, EmpireMap> adjecentMaps = new HashMap<String, EmpireMap>();
		int row = current.getLocation().getRow();
		int col = current.getLocation().getCol();
		
		if(currentMap.getLevel().equals(LOCAL))
		{
			EmpireRegionalMap parent = (EmpireRegionalMap) previous;
			
			if(parent.getMap(row - 1, col) != null) adjecentMaps.put("north", parent.getMap(row - 1, col));
			if(parent.getMap(row + 1, col) != null) adjecentMaps.put("south", parent.getMap(row + 1, col));
			if(parent.getMap(row, col + 1) != null) adjecentMaps.put("east", parent.getMap(row, col + 1));
			if(parent.getMap(row, col - 1) != null) adjecentMaps.put("west", parent.getMap(row, col - 1));
		}
		else
		{	
			if(worldMapModel.getMap(row - 1, col) != null) adjecentMaps.put("north", worldMapModel.getMap(row - 1, col));
			if(worldMapModel.getMap(row + 1, col) != null) adjecentMaps.put("south", worldMapModel.getMap(row + 1, col));
			if(worldMapModel.getMap(row, col + 1) != null) adjecentMaps.put("east", worldMapModel.getMap(row, col + 1));
			if(worldMapModel.getMap(row, col - 1) != null) adjecentMaps.put("west", worldMapModel.getMap(row, col - 1));
		}
		
		return adjecentMaps;
	}
	
	/**
	 * Adjusts the values of the current map so the correct map can be displayed.
	 * Also updates the UI after setting the new map.
	 * @author Jay Clegg
	 * @param level The level the tile is on.
	 * @param row The row the tile is in.
	 * @param col The column the tile is in.
	 */
	private void goTo(String level, int row, int col)
	{
		if(level.equals(REGIONAL))
		{
			previousMap = (RegionalMap) currentMap;
			currentMap = localMaps.get(worldMapModel.getMap(currentRow, currentCol).getMap(row, col));
			updateUI();
		}
		else
		{
			currentMap = regionalMaps.get(worldMapModel.getMap(row, col));
			currentRow = row;
			currentCol = col;
			updateUI();
		}
	}
	
	/**
	 * Loads the local maps.
	 * @author Jay Clegg
	 */
	private void loadLocalMaps()
	{
		int regionRow = 0;
		int regionCol = 0;
		while(worldMapModel.getMap(regionRow, regionCol) != null)
		{
			while(worldMapModel.getMap(regionRow, regionCol) != null)
			{
				EmpireRegionalMap region = worldMapModel.getMap(regionRow, regionCol);
				int mapRow = 0;
				int mapCol = 0;
				
				while(region.getMap(mapRow, mapCol) != null)
				{
					while(region.getMap(mapRow, mapCol) != null)
					{
						EmpireLocalMap map = region.getMap(mapRow, mapCol);
						LocalMap mapView = new LocalMap(this);
						
						mapView.setName(map.getName());
						
						Biome[][] biomes = map.getBiomes2D();
						int[][] states = map.getStates2D();
						Tile[][] tiles = mapView.getTiles2D();
						
						for(int row = 0; row < biomes.length; row++)
						{
							for(int col = 0; col < biomes[row].length; col++)
							{
								tiles[row][col].setBackground(biomes[row][col].getColor());
								tiles[row][col].setOpaque(states[row][col] == EXPLORED);
							}
						}
						
						localMaps.put(map, mapView);
						mapCol++;
					}
					
					mapCol = 0;
					mapRow++;
				}
				regionCol++;
			}
			regionCol = 0;
			regionRow++;
		}
		
		currentMap = localMaps.get(app.getEmpire().getOrigin());
		selectedTile = regionalMaps.get(app.getEmpire().getStartingMap()).getTile(selectMapModel(currentMap).getLocation().getRow(), selectMapModel(currentMap).getLocation().getCol());
	}
	
	/**
	 * Loads all the maps. This is only called from the 2 parameter constructor used for loading.
	 * @author Jay Clegg
	 */
	private void loadMaps()
	{
		loadWorldMap();
		loadRegionalMaps();
		loadLocalMaps();
	}
	
	/**
	 * Loads the regional maps.
	 * @author Jay Clegg
	 */
	private void loadRegionalMaps()
	{
		int mapRow = 0;
		int mapCol = 0;
		
		while(worldMapModel.getMap(mapRow, mapCol) != null)
		{
			while(worldMapModel.getMap(mapRow, mapCol) != null)
			{
				EmpireRegionalMap map = worldMapModel.getMap(mapRow, mapCol);
				RegionalMap mapView = new RegionalMap(this);
				
				mapView.setName(map.getName());
				
				Biome[][] biomes = map.getBiomes2D();
				int[][] states = map.getStates2D();
				Tile[][] tiles = mapView.getTiles2D();
				
				for(int row = 0; row < biomes.length; row++)
				{
					for(int col = 0; col < biomes[row].length; col++)
					{
						tiles[row][col].setBackground(biomes[row][col].getColor());
						tiles[row][col].setOpaque(states[row][col] == EXPLORED);
					}
				}
				
				regionalMaps.put(map, mapView);
				mapCol++;
			}
			
			mapCol = 0;
			mapRow++;
		}
		
		previousMap = regionalMaps.get(app.getEmpire().getStartingMap());
		currentRow = app.getEmpire().getStartingMap().getLocation().getRow();
		currentCol = app.getEmpire().getStartingMap().getLocation().getCol();
	}
	
	/**
	 * Loads the world map.
	 * @author Jay Clegg
	 */
	private void loadWorldMap()
	{
		this.worldMapView = new WorldMap(this);
		
		Biome[][] biomes = worldMapModel.getBiomes2D();
		int[][] states = worldMapModel.getStates2D();
		Tile[][] tiles = worldMapView.getTiles2D();
		
		for(int row = 0; row < biomes.length; row++)
		{
			for(int col = 0; col < biomes[row].length; col++)
			{
				tiles[row][col].setBackground(biomes[row][col].getColor());
				tiles[row][col].setOpaque(states[row][col] == EXPLORED);
			}
		}
	}
	
	/**
	 * Generates a random number from 0 to 99 which is used to randomly generate biomes.
	 * @author Jay Clegg
	 * @return
	 */
	private int randomNumber()
	{
		return (int) (Math.random() * 100);
	}
	
	/**
	 * Allows for the selection of a specific map's model based on the values in the HashMaps.
	 * @author Jay Clegg
	 * @param value The value in the HashMap
	 * @return The key to that value in the HashMap.
	 */
	private EmpireMap selectMapModel(Map value)
	{
		if(value.getLevel().equals(LOCAL))
		{
			for(EmpireRegionalMap region : regionalMaps.keySet())
			{
				for(EmpireLocalMap map : region.getLocalMaps())
				{
					if(localMaps.get(map).equals(value)) return map;
				}
			}
		}
		else if(value.getLevel().equals(REGIONAL))
		{
			for(EmpireRegionalMap regionalMap : worldMapModel.getRegionalMaps())
			{
				if(regionalMaps.get(regionalMap).equals(value)) return regionalMap;
			}
		}
		else if(value.getLevel().equals(WORLD)) return worldMapModel;
		
		return null;
	}
	
	/**
	 * Explores a tile.
	 * @author Jay Clegg
	 */
	public void exploreTile()
	{
		selectedTile.setOpaque(true);
		exploreMenu.dispose();
		
		String level = currentMap.getLevel();
		int row = selectedTile.getRow();
		int col = selectedTile.getCol();
		
		if(level.equals(LOCAL))
		{
			EmpireLocalMap map = (EmpireLocalMap) selectMapModel(currentMap);
			map.setState(row, col, EXPLORED);
			
			if(selectMapModel(currentMap).getIsFullyExplored() && ! app.getEmpire().getMapSelectorAdded())
			{
				app.addMapSelector();
			}
		}
		else if(level.equals(REGIONAL))
		{
			EmpireRegionalMap map = (EmpireRegionalMap) selectMapModel(currentMap);
			map.setState(row, col, EXPLORED);
		}
		else
		{
			worldMapModel.setState(row, col, EXPLORED);
		}
	}
	
	/**
	 * Completely explores the given map and the maps contained in it.
	 * @author Jay Clegg
	 * @param map
	 */
	public void fullyExplore(EmpireMap map)
	{
		if(map.getLevel().equals(LOCAL))
		{
			for(Location location : map.getLocations())
			{
				location.setState(EXPLORED);
				localMaps.get(map).getTile(location.getRow(), location.getCol()).setOpaque(true);
			}
		}
		else if(map.getLevel().equals(REGIONAL))
		{
			for(Location location : map.getLocations())
			{
				location.setState(EXPLORED);
				regionalMaps.get(map).getTile(location.getRow(), location.getCol()).setOpaque(true);
			}
			for(EmpireLocalMap localMap : ((EmpireRegionalMap) (map)).getLocalMaps())
			{
				fullyExplore(localMap);
			}
		}
		else
		{
			for(Location location : map.getLocations())
			{
				location.setState(EXPLORED);
				worldMapView.getTile(location.getRow(), location.getCol()).setOpaque(true);
			}
			for(EmpireRegionalMap region : worldMapModel.getRegionalMaps())
			{
				fullyExplore(region);
			}
		}
	}
	
	public Controller getController()
	{
		return this.app;
	}
	
	public Map getCurrentMap()
	{
		return this.currentMap;
	}
	
	public String getCurrentMapName()
	{
		return selectMapModel(currentMap).getName();
	}
	
	/**
	 * Sets the value of the specified tile to the specified value in the specified map.
	 * @author Jay Clegg
	 * @param map The map in question.
	 * @param row The row where the value is located.
	 * @param col The column where the value is located.
	 * @param newValue The new value for the tile.
	 */
	public void setValue(EmpireMap map, int row, int col, int newValue)
	{
		map.setState(row, col, newValue);
	}
	
	/**
	 * Once a tile is clicked, this method gives the option to explore or build on it.
	 * It also focuses the map view on the selected map if necessary.
	 * @author Jay Clegg
	 * @param tile The tile which was clicked.
	 */
	public void tileOptions(Tile tile)
	{
		this.selectedTile = tile;
		
		EmpireMap map = selectMapModel(currentMap);
		
		clearMenus();
		
		if(currentMap.getLevel().equals(LOCAL))
		{
			if(map.getState(tile.getRow(), tile.getCol()) == EXPLORED)
			{
				buildingMenu();
			}
			else
			{
				checkExplore();
			}
		}
		else
		{
			if(map.getState(tile.getRow(), tile.getCol()) == EXPLORED)
			{
				goTo(currentMap.getLevel(), tile.getRow(), tile.getCol());
			}
			else
			{
				checkExplore();
			}
		}
		
		app.returnFocus();
	}
	
	/**
	 * When the user changes the name of a map, the change is saved by this.
	 * @author Jay Clegg
	 * @param name The new name of the map.
	 */
	public void updateMapName(String name)
	{
		selectMapModel(currentMap).setName(name);
		
		app.returnFocus();
	}
	
	/**
	 * Changes the map on the game screen.
	 * @author Jay Clegg
	 */
	public void updateUI()
	{
		((GameContentPane) app.getFrame().getContentPane()).setMap(currentMap);
	}
	
	/**
	 * Zooms the map out to a higher level. </br>
	 * Local zooms to regional. </br>
	 * Regional zooms to world. </br>
	 * World zooms to nothing!
	 * @author Jay Clegg
	 */
	public void zoomMapOut()
	{
		clearMenus();
		
		if(currentMap.getLevel().equals(LOCAL))
		{
			currentMap = previousMap;
			updateUI();
		}
		else
		{
			boolean canZoom = false;
			
			if(currentMap.getLevel().equals(REGIONAL))
			{
				EmpireRegionalMap currentModel = (EmpireRegionalMap) selectMapModel(currentMap);
				int numMaps = currentModel.getLocalMaps().size();
				int mapsExplored = 0;
				
				for(EmpireLocalMap localMap : currentModel.getLocalMaps())
				{
					if(localMap.getIsFullyExplored()) mapsExplored++;
				}
				
				canZoom = mapsExplored == numMaps;
			}
			
			if(canZoom)
			{
				currentMap = worldMapView;
				updateUI();
			}
		}
		
		app.returnFocus();
	}
}