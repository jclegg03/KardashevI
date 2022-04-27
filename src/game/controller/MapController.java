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
		Biome[][] biomes = worldMapModel.getBiomes2D();
		for(int row = 0; row < biomes.length; row++)
		{
			for(int col = 0; col < biomes[row].length; col++)
			{
				WorldBiome current;
				int number = randomNumber();
				if(number < 50) current = this.biomes.getWorldBiome("Deep Ocean");
				else if(number < 71) current = this.biomes.getWorldBiome("Shallow Ocean");
				else if(number < 81) current = this.biomes.getWorldBiome("Desert");
				else if(number < 82) current = this.biomes.getWorldBiome("Icy Ocean");
				else if(number < 87) current = this.biomes.getWorldBiome("Mountainous");
				else current = this.biomes.getWorldBiome("Fertile");
				
				worldMapView.getTile(row, col).setBackground(current.getColor());
				worldMapModel.addMap(row, col, new EmpireRegionalMap(app.getEmpire(), current, new Location(row, col, current, REGIONAL)));
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
		worldMapView.getTile(row, col).setIsExplored(true);	
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
				Biome[][] mapBiomes = currentMap.getBiomes2D();
				for(int row = 0; row < mapBiomes.length; row++)
				{
					for(int col = 0; col < mapBiomes[row].length; col++)
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
						
						mapView.getTile(row, col).setBackground(current.getColor());
						currentMap.addMap(row, col, new EmpireLocalMap(app.getEmpire(), current, new Location(row, col, current, LOCAL)));
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
		for(Tile tile : worldMapView.getTiles())
		{
			if(tile.getIsExplored())
			{
				regionExplored = regionalMaps.get(worldMapModel.getMap(tile.getMapLocation()[0], tile.getMapLocation()[1]));
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
		regionExplored.getTile(row, col).setIsExplored(true);
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
				Biome[][] localBiomes = currentMap.getBiomes2D();
				LocalMap mapView = new LocalMap(this);
				
				for(int row = 0; row < localBiomes.length; row++)
				{
					for(int col = 0; col < localBiomes[row].length; col++)
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
						
						localBiomes[row][col] = current.copy();
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
		RegionalMap region = null;
		for(Tile tile : worldMapView.getTiles())
		{
			if(tile.getIsExplored())
			{
				region = regionalMaps.get(worldMapModel.getMap(tile.getMapLocation()[0], tile.getMapLocation()[1]));
			}
		}
		EmpireLocalMap exploredMap = null;
		
		for(int row = 0; row < region.getTiles2D().length; row++)
		{
			for(int col = 0; col < region.getTiles2D()[0].length; col++)
			{
				if(region.getTile(row, col).getIsExplored())
				{
					EmpireRegionalMap regionMapModel = (EmpireRegionalMap) selectMapModel(region);
					exploredMap = regionMapModel.getMap(row, col);
				}
			}
		}
		LocalMap mapView = localMaps.get(exploredMap);
		
		int randRow = (int) (Math.random() * (exploredMap.getBiomes2D().length - 2)) + 1;
		int randCol = (int) (Math.random() * (exploredMap.getBiomes2D()[0].length - 2)) + 1;
		
		exploredMap.setState(randRow, randCol, EXPLORED);
		exploredMap.setState(randRow - 1, randCol, EXPLORED);
		exploredMap.setState(randRow + 1, randCol, EXPLORED);
		mapView.getTile(randRow, randCol).setIsExplored(true);
		mapView.getTile(randRow + 1, randCol).setIsExplored(true);
		mapView.getTile(randRow - 1, randCol).setIsExplored(true);
		
		randCol--;
		exploredMap.setState(randRow, randCol, EXPLORED);
		exploredMap.setState(randRow - 1, randCol, EXPLORED);
		exploredMap.setState(randRow + 1, randCol, EXPLORED);
		mapView.getTile(randRow, randCol).setIsExplored(true);
		mapView.getTile(randRow + 1, randCol).setIsExplored(true);
		mapView.getTile(randRow - 1, randCol).setIsExplored(true);
		
		randCol += 2;
		exploredMap.setState(randRow, randCol, EXPLORED);
		exploredMap.setState(randRow - 1, randCol, EXPLORED);
		exploredMap.setState(randRow + 1, randCol, EXPLORED);
		mapView.getTile(randRow, randCol).setIsExplored(true);
		mapView.getTile(randRow + 1, randCol).setIsExplored(true);
		mapView.getTile(randRow - 1, randCol).setIsExplored(true);
		
		previousMap = region;
		currentMap = mapView;
		
		//Displays entire first map. Except 1 tile.
//		for(Tile tile : currentMap.getTiles())
//		{
//			tile.setIsExplored(true);
//		}
//		
//		currentMap.getTile(randRow, randCol).setIsExplored(false);
		
		mapView.getTile(randRow, randCol).setIsExplored(false);
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
		
		clearMenus();
		
		if(currentMap.getLevel().equals(LOCAL))
		{
			if(tile.getIsExplored())
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
			if(selectedTile.getIsExplored())
			{
				goTo(currentMap.getLevel(), tile.getMapLocation()[0], tile.getMapLocation()[1]);
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
		ArrayList<Tile> adjecentTiles = new ArrayList<Tile>();
		int[] location = selectedTile.getMapLocation();
		boolean canExplore = false;
		
		//right
		if(currentMap.getTile(location[0] + 1, location[1]) != null)
		{
			adjecentTiles.add(currentMap.getTile(location[0] + 1, location[1]));
		}
		
		//left
		if(currentMap.getTile(location[0] - 1, location[1]) != null)
		{
			adjecentTiles.add(currentMap.getTile(location[0] - 1, location[1]));
		}
		
		//up
		if(currentMap.getTile(location[0], location[1] - 1) != null)
		{
			adjecentTiles.add(currentMap.getTile(location[0], location[1] - 1));
		}
		
		//down
		if(currentMap.getTile(location[0], location[1] + 1) != null)
		{
			adjecentTiles.add(currentMap.getTile(location[0], location[1] + 1));
		}
		
		for(Tile adjecent : adjecentTiles)
		{
			if(adjecent.getIsExplored())
			{
				canExplore = true;
			}
		}
		
		if(! canExplore && ! currentMap.getLevel().equals(WORLD))
		{
			HashMap<String, Map> adjecentMaps = getAdjecentMaps();
			Map north = adjecentMaps.get("north");
			Map south = adjecentMaps.get("south");
			Map east = adjecentMaps.get("east");
			Map west = adjecentMaps.get("west");
			int size = currentMap.getTiles2D().length;
			
			if(north != null && location[0] == 0)
			{
				canExplore = north.getTile(size - 1, location[1]).getIsExplored();
			}
			if(south != null && location[0] == size - 1 && ! canExplore)
			{
				canExplore = south.getTile(0, location[1]).getIsExplored();
			}
			if(east != null && location[1] == size - 1 && ! canExplore)
			{
				canExplore = east.getTile(location[0], 0).getIsExplored();
			}
			if(west != null && location[1] == 0 && ! canExplore)
			{
				canExplore = west.getTile(location[0], size - 1).getIsExplored();
			}
		}
		
		if(canExplore)
		{
			exploreMenu();
		}
	}
	
	private HashMap<String, Map> getAdjecentMaps()
	{
		EmpireMap current = selectMapModel(currentMap);
		EmpireMap previous = selectMapModel(previousMap);
		HashMap<String, Map> adjecentMaps = new HashMap<String, Map>();
		int row = current.getLocation().getRow();
		int col = current.getLocation().getCol();
		
		if(currentMap.getLevel().equals(LOCAL))
		{
			EmpireRegionalMap parent = (EmpireRegionalMap) previous;
			
			if(parent.getMap(row - 1, col) != null) adjecentMaps.put("north", localMaps.get(parent.getMap(row - 1, col)));
			if(parent.getMap(row + 1, col) != null) adjecentMaps.put("south", localMaps.get(parent.getMap(row + 1, col)));
			if(parent.getMap(row, col + 1) != null) adjecentMaps.put("east", localMaps.get(parent.getMap(row, col + 1)));
			if(parent.getMap(row, col - 1) != null) adjecentMaps.put("west", localMaps.get(parent.getMap(row, col - 1)));
		}
		else
		{	
			if(worldMapModel.getMap(row - 1, col) != null) adjecentMaps.put("north", regionalMaps.get(worldMapModel.getMap(row - 1, col)));
			if(worldMapModel.getMap(row + 1, col) != null) adjecentMaps.put("south", regionalMaps.get(worldMapModel.getMap(row + 1, col)));
			if(worldMapModel.getMap(row, col + 1) != null) adjecentMaps.put("east", regionalMaps.get(worldMapModel.getMap(row, col + 1)));
			if(worldMapModel.getMap(row, col - 1) != null) adjecentMaps.put("west", regionalMaps.get(worldMapModel.getMap(row, col - 1)));
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
					if(localMaps.get(localMap).getIsFullyExplored()) mapsExplored++;
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
		selectedTile.setIsExplored(true);
		exploreMenu.dispose();
		
		String level = currentMap.getLevel();
		int[] location = selectedTile.getMapLocation();
		
		if(level.equals(LOCAL))
		{
			EmpireLocalMap map = (EmpireLocalMap) selectMapModel(currentMap);
			map.setState(location[0], location[1], EXPLORED);
			
			if(currentMap.getIsFullyExplored())
			{
				app.addMapSelector();
			}
		}
		else if(level.equals(REGIONAL))
		{
			EmpireRegionalMap map = (EmpireRegionalMap) selectMapModel(currentMap);
			map.setState(location[0], location[1], EXPLORED);
		}
		else
		{
			worldMapModel.setState(location[0], location[1], EXPLORED);
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
}