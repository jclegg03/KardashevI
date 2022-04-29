package game.controller;	

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import game.model.biomes.Biome;
import game.model.biomes.LocalBiome;
import game.model.biomes.RegionalBiome;
import game.model.biomes.WorldBiome;
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
	private Map currentMap;
	private RegionalMap previousMap;
	private int currentRow;
	private int currentCol;
	private BiomeList biomes;
	
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
		fullyExplore(worldMapModel);
		currentMap.getTile(0, 0).setOpaque(false);
		selectMapModel(currentMap).setState(0, 0, UNEXPLORED);
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
	 * Builds the world maps
	 * @author Jay Clegg
	 */
	private void buildWorldMap()
	{
		worldMapModel = new EmpireWorldMap(app.getEmpire());
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
				worldMapModel.addMap(row, col, new EmpireRegionalMap(app.getEmpire(), current, new Location(row, col, null, null)));
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
						currentMap.addMap(row, col, new EmpireLocalMap(app.getEmpire(), current, new Location(row, col, null, null)));
						currentMap.setState(row, col, UNEXPLORED);
					}
				}
				
				regionalMaps.put(currentMap, mapView);
			}
			
			exploreRandomLocalMap();
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
	 * Changes the map on the game screen.
	 * @author Jay Clegg
	 */
	public void updateUI()
	{
		((GameContentPane) app.getFrame().getContentPane()).setMap(currentMap);
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
	
	/**
	 * Handles the building menu.
	 * @author Jay Clegg
	 */
	private void buildingMenu()
	{
		buildingMenu = new BuildingMenu(this, (GameFrame) app.getFrame(), selectedTile);
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
			
			if(selectMapModel(currentMap).getIsFullyExplored())
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
	 * When the user changes the name of a map, the change is saved by this.
	 * @author Jay Clegg
	 * @param name The new name of the map.
	 */
	public void updateMapName(String name)
	{
		selectMapModel(currentMap).setName(name);
		
		app.returnFocus();
	}
	
	public Map getCurrentMap()
	{
		return this.currentMap;
	}
	
	public Controller getController()
	{
		return this.app;
	}
	
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
}