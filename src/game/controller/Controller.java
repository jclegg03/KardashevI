package game.controller;

import java.io.File;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;

import game.model.empire.Empire;
import game.view.exitDialog.ExitDialog;
import game.view.gameMenu.GameMenu;
import game.view.gameView.GameContentPane;
import game.view.gameView.GameFrame;
import game.view.loadDialog.LoadDialog;
import game.view.mainMenu.MainMenu;
import game.view.newGameDialog.NewGameDialog;
import game.view.saveDialog.SaveDialog;
import gui.utility.JFrame;

/**
 * One Controller to rule them all, One Controller to find them,<br>
 * One Controller to bring them all, and in the darkness bind them<br>
 * Inspired by JRR Tolkien
 * @author Jay Clegg
 *
 */
public class Controller implements Serializable
{
	/**
	 * The empire, basically the model.
	 * @author Jay Clegg
	 */
	private Empire empire;
	
	/**
	 * The view.
	 * @author Jay Clegg
	 */
	private JFrame frame;
	
	/**
	 * Used to determine if a game was actually loaded.
	 * @author Jay Clegg
	 */
	private boolean gameLoaded;
	
	/**
	 * A sub controller for the maps.
	 * @author Jay Clegg
	 */
	private MapController mapController;
	
	/**
	 * A sub controller for the resources.
	 * @author Jay Clegg
	 */
	private ResourceController resourceController;
	
	/**
	 * Used to determine which file to load the empire from.
	 * @author Jay Clegg
	 */
	private int saveIndex;
	
	/**
	 * The app's settings.
	 * @author Jay Clegg
	 */
	private Settings settings;
	
	/**
	 * A sub controller for settlements.
	 * @author Jay Clegg
	 */
	private SettlementController settlementController;
	
	/**
	 * A sub controller for the toolbar.
	 * @author Jay Clegg
	 */
	private ToolbarController toolbarController;
	
	/**
	 * Builds the game controller.
	 * @author Jay Clegg
	 */
	public Controller()
	{
		this.frame = new MainMenu(this);
		this.gameLoaded = false;
	}
	
	/**
	 * Calls the finish setup of the sub controllers. Used to initialize the view members they have.
	 * @author Jay Clegg
	 */
	private void finishSetup()
	{
		toolbarController.finishSetup();
		settlementController.finishSetup();
		resourceController.finishSetup();
	}
	
	/**
	 * Adds the map selector to the frame and updates the mapSelectorAdded in the model.
	 * @author Jay Clegg
	 */
	public void addMapSelector()
	{
		((GameContentPane) (frame.getContentPane())).addMapSelector();
		empire.setMapSelectorAdded(true);
		
	}
	
	/**
	 * Once the user has entered an empire name, this method starts the game and builds the empire.
	 * @author Jay Clegg
	 * @param empireName The name of the empire.
	 * @param dialog The dialog used to interact with the user.
	 */
	public void createEmpire(String empireName, NewGameDialog dialog)
	{
		this.empire = new Empire(empireName);
		this.settlementController = new SettlementController(this);
		this.toolbarController = new ToolbarController(this);
		this.mapController = new MapController(this);
		this.resourceController = new ResourceController(this);
		
		dialog.dispose();
		frame.dispose();
		frame = new GameFrame(this);
		
		finishSetup();
	}
	
	public Empire getEmpire()
	{
		return this.empire;
	}
	
	public JFrame getFrame()
	{
		return this.frame;
	}
	
	public MapController getMapController()
	{
		return this.mapController;
	}
	
	public ResourceController getResourceController()
	{
		return this.resourceController;
	}
	
	public SettlementController getSettlementController()
	{
		return this.settlementController;
	}
	
	/**
	 * Actually loads a game.
	 * @author Jay Clegg
	 */
	public void loadGame()
	{
		ArrayList<String> fileNames = new ArrayList<String>();
		String path = null;
		
		try
		{
			File folder = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
//			System.out.println(folder.getAbsolutePath());
			String pathway = "";
			
			try
			{
				pathway = folder.getAbsolutePath().substring(0, folder.getAbsolutePath().indexOf("/"));
			}
			catch(StringIndexOutOfBoundsException notFound)
			{
				pathway = folder.getAbsolutePath().substring(0, folder.getAbsolutePath().indexOf("\\"));
			}
			
			folder = new File(pathway);
			path = folder.getAbsolutePath();
			folder = folder.getAbsoluteFile();
			
			String[] files = folder.list();
			
			for(String file : files)
			{
				if(file.endsWith(".kdsi")) fileNames.add(file);
			}
		} 
		catch(URISyntaxException error)
		{
		}
		
		String[] saves = new String[fileNames.size()];
		
		for(int index = 0; index < saves.length; index++)
		{
			saves[index] = fileNames.get(index);
		}
		
		new LoadDialog(this, frame, saves);
		
		this.empire = IOController.loadGame(path + "/" + saves[saveIndex]);
		
		if(empire != null)
		{
			this.mapController = new MapController(empire, this);
			this.settlementController = new SettlementController(empire, this);
			this.toolbarController = new ToolbarController(this);
			this.resourceController = new ResourceController(empire, this);
			
			frame.dispose();
			frame = new GameFrame(this);
			
			finishSetup();
			
			if(empire.getMapSelectorAdded())
			{
				addMapSelector();
			}
			
			gameLoaded = true;
		}
		
		returnFocus();
	}
	
	/**
	 * Creates a load game menu.
	 * @author Jay Clegg
	 */
	public void loadGame(GameMenu menu)
	{
		menu.setVisible(false);
		loadGame();
		if(gameLoaded) menu.dispose();
		else menu.setVisible(true);
		returnFocus();
	}
	
	/**
	 * Begins the new game.
	 * @author Jay Clegg
	 */
	public void newGame()
	{
		new NewGameDialog(this, (MainMenu) frame);
		returnFocus();
	}
	
	/**
	 * Quits the game and disposes of the exit dialog and frame.
	 * @param dialog The exit dialog.
	 * @author Jay Clegg
	 */
	public void quit(ExitDialog dialog)
	{
		dialog.dispose();
		frame.dispose();
	}
	
	/**
	 * Makes an exit dialog from in a game.
	 * @param menu The in game menu.
	 * @author Jay Clegg
	 */
	public void quit(GameMenu menu)
	{
		menu.setVisible(false);
		new ExitDialog(this, frame);
		if(frame.isActive())
		{
			menu.setVisible(true);
		}
		else
		{
			menu.dispose();
		}
	}
	
	/**
	 * Returns focus to the main contentPane so it can listen for hotkeys. Should be called at the end of each button action.
	 * @author Jay Clegg
	 */
	public void returnFocus()
	{
		frame.getContentPane().requestFocus();
	}
	
	/**
	 * Returns to the main menu from the game.
	 * @author Jay Clegg
	 * @param menu The in game menu.
	 */
	public void returnToMainMenu(GameMenu menu)
	{
		menu.dispose();
		frame.dispose();
		frame = new MainMenu(this);
	}
	
	/**
	 * Saves a game.
	 * @author Jay Clegg
	 * @param details
	 */
	public void save(String details)
	{
		IOController.saveGame(this, details);
	}
	
	/**
	 * Makes a save dialog.
	 * @author Jay Clegg
	 * @param menu The game menu.
	 */
	public void saveGame(GameMenu menu)
	{
		menu.setVisible(false);
		new SaveDialog(this);
		menu.setVisible(true);
		returnFocus();
	}
	
	public void setSaveIndex(int saveIndex)
	{
		this.saveIndex = saveIndex;
	}
	
	/**
	 * Creates a settings game menu.
	 * @author Jay Clegg
	 */
	@WIP
	//Does nothing.
	public void settings()
	{
		
	}
}