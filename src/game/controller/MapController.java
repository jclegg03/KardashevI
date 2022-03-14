package game.controller;	

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import game.model.biomes.Biome;
import game.model.biomes.RegionalBiome;
import game.model.biomes.WorldBiome;
import game.model.lists.BiomeList;
import game.model.maps.EmpireLocalMap;
import game.model.maps.EmpireMap;
import game.model.maps.EmpireRegionalMap;
import game.model.maps.EmpireWorldMap;
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
	private Map currentMap;
	private int currentRow, currentCol;
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
		currentMap = worldMapView;
	}
	
	private void buildMaps()
	{
		buildWorldMap();
		buildRegionalMaps();
		buildLocalMaps();
	}
	
	private void buildWorldMap()
	{
		worldMapModel = new EmpireWorldMap(app.getEmpire());
		worldMapView = new WorldMap(this);
		Biome[][] biomes = worldMapModel.getBiomes();
		for(int row = 0; row < biomes.length; row++)
		{
			for(int col = 0; col < biomes[row].length; col++)
			{
				WorldBiome current;
				int number = randomNumber();
				if(number < 65) current = this.biomes.getWorldBiome("Deep Ocean");
				else if(number < 71) current = this.biomes.getWorldBiome("Shallow Ocean");
				else if(number < 81) current = this.biomes.getWorldBiome("Desert");
				else if(number < 82) current = this.biomes.getWorldBiome("Icy Ocean");
				else if(number < 87) current = this.biomes.getWorldBiome("Mountainous");
				else current = this.biomes.getWorldBiome("Fertile");
				
				biomes[row][col] = current.copy();
				
				worldMapView.getTile(row, col).setBackground(current.getColor());
				worldMapModel.addMap(row, col, new EmpireRegionalMap(app.getEmpire(), current));
			}
		}
		
		if(! worldContainsFertile())
		{
			biomes[(int) (Math.random() * 20)][(int) (Math.random() * 20)] = this.biomes.getWorldBiome("Fertile").copy();
		}
		
		exploreRandomWorld();
	}
	
	private boolean worldContainsFertile()
	{
		for(Biome[] row : worldMapModel.getBiomes())
		{
			for(Biome biome : row)
			{
				if(biome.equals((Biome) this.biomes.getWorldBiome("Fertile"))) return true;
			}
		}
		
		return false;
	}
	
	private void exploreRandomWorld()
	{
		ArrayList<int[]> locations = new ArrayList<int[]>();
		
		for(int row = 0; row < worldMapModel.getBiomes().length; row++)
		{
			for(int col = 0; col < worldMapModel.getBiomes()[row].length; col++)
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
		currentRow = row;
		currentCol = col;
	}
	
	private void buildRegionalMaps()
	{
			for(EmpireRegionalMap currentMap : worldMapModel.getRegionalMaps())
			{
				RegionalMap mapView = new RegionalMap(this);
				WorldBiome currentBiome = currentMap.getParentBiome();
				Biome[][] mapBiomes = currentMap.getBiomes();
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
						else
						{
							if(random < 50) current = biomes.getRegionalBiome("Grasslands");
							else current = biomes.getRegionalBiome("Lake");
						}
						
						mapBiomes[row][col] = current.copy();
						mapView.getTile(row, col).setBackground(current.getColor());
					}
				}
				
				regionalMaps.put(currentMap, mapView);
			}
	}
	
	private void buildLocalMaps()
	{
		
	}
	
	private int randomNumber()
	{
		return (int) (Math.random() * 100);
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
		((GameContentPane) app.getFrame().getContentPane()).setMap(currentMap);
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
	
	/**
	 * Once a tile is clicked, this method gives the option to explore or build on it.
	 * @author Jay Clegg
	 * @param tile
	 */
	public void tileOptions(Tile tile)
	{
		this.selectedTile = tile;
		
		if(currentMap.getLevel().equals(LOCAL))
		{
			if(tile.getIsExplored())
			{
				buildingMenu();
			}
			else
			{
				exploreMenu();
			}
		}
		else
		{
			goTo(currentMap.getLevel(), tile.getMapLocation()[0], tile.getMapLocation()[1]);
		}
		
		app.returnFocus();
	}
	
	private void goTo(String level, int row, int col)
	{
		if(level.equals(REGIONAL))
		{
			localMaps.get(worldMapModel.getMap(currentRow, currentCol).getMap(row, col));
			updateUI();
		}
		else
		{
			currentMap = regionalMaps.get(worldMapModel.getMap(row, col));
			updateUI();
		}
		
		currentRow = row;
		currentCol = col;
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
	
	public Map getCurrentMap()
	{
		return this.currentMap;
	}
}
