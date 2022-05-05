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
	private Empire empire;
	private JFrame frame;
	private MapController mapController;
	private ResourceController resourceController;
	private Settings settings;
	private SettlementController settlementController;
	private ToolbarController toolbarController;
	private boolean mapSelectorAdded;
	
	/**
	 * Builds the game controller.
	 * @author Jay Clegg
	 */
	public Controller()
	{
		this.frame = new MainMenu(this);
		this.mapSelectorAdded = false;
		loadGame();
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
	
	public void saveGame(GameMenu menu)
	{
		menu.setVisible(false);
		new SaveDialog(this);
		menu.setVisible(true);
		returnFocus();
	}
	
	public void save(String details)
	{
		IOController.saveGame(this, details);
	}
	
	/**
	 * Creates a load game menu.
	 * @author Jay Clegg
	 */
	public void loadGame(GameMenu menu)
	{
		menu.setVisible(false);
		loadGame();
		menu.dispose();
		returnFocus();
	}
	
	public void loadGame()
	{
		ArrayList<String> fileNames = new ArrayList<String>();
		String path = null;
		
		try
		{
			File folder = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI());
			
			folder = new File(folder.getAbsolutePath().substring(0, folder.getAbsolutePath().indexOf("/")));
			path = folder.getAbsolutePath();
			folder = folder.getAbsoluteFile();
			
			String[] files = folder.list();
			
			for(String file : files)
			{
				if(file.endsWith(".kdsi")) fileNames.add(file);
			}
		} 
		catch (URISyntaxException error)
		{
		}
		
		
		
		returnFocus();
	}
	
	/**
	 * Creates a save game menu.
	 * @author Jay Clegg
	 */
	public void settings()
	{
		
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
	 * Once the user has entered an empire name, this method starts the game and builds the empire.
	 * @author Jay Clegg
	 * @param empireName The name of the empire.
	 * @param dialog The dialog used to interact with the user.
	 */
	@WIP
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
		
		settlementController.finishSetup();
	}
	
	/**
	 * Returns focus to the main contentPane so it can listen for hotkeys. Should be called at the end of each button action.
	 * @author Jay Clegg
	 */
	public void returnFocus()
	{
		frame.getContentPane().requestFocus();
	}
	
	public JFrame getFrame()
	{
		return this.frame;
	}
	
	public Empire getEmpire()
	{
		return this.empire;
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
	
	public void addMapSelector()
	{
		if(! mapSelectorAdded)
		{
			((GameContentPane) (frame.getContentPane())).addMapSelector();
		}
	}
}