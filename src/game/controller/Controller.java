package game.controller;

import java.io.Serializable;

import game.view.buildingMenu.BuildingMenu;
import game.view.gameMenu.GameMenu;
import game.view.gameView.GameFrame;
import game.view.mainMenu.ExitDialog;
import game.view.mainMenu.MainMenu;
import game.view.mainMenu.NewGameDialog;
import game.view.map.Tile;
import gui.utility.JFrame;

/**
 * The main controller for the game.
 * @author Jay Clegg
 *
 */
public class Controller implements Serializable
{
	static final long serialVersionUID = 0l;
	private JFrame frame;
	private String empireName;
	private BuildingMenu buildingMenu;
	
	/**
	 * Builds the game controller.
	 * @author Jay Clegg
	 */
	public Controller()
	{
		this.frame = new MainMenu(this);
		this.empireName = "";
	}
	
	/**
	 * Begins the new game.
	 * @author Jay Clegg
	 */
	public void newGame()
	{
		new NewGameDialog(this, (MainMenu) frame);
		frame.getContentPane().requestFocus();
	}
	
	public void loadGame()
	{
		
	}
	
	public void settings()
	{
		
	}
	
	/**
	 * Quits the game.
	 * @param dialog The exit dialog.
	 */
	public void quit(ExitDialog dialog)
	{
		dialog.dispose();
		frame.dispose();
	}
	
	/**
	 * Quits the game from in a game.
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
	
	public void selectSettlement(String name)
	{
		
		
		
		returnFocus();
	}
	
	/**
	 * Once a tile is clicked, this method gives the option to explore or build on it.
	 * @author Jay Clegg
	 * @param tile
	 */
	public void buildBuilding(Tile tile)
	{
		if(tile.getIsExplored())
		{
			if(buildingMenu != null)
			{
				buildingMenu.setVisible(false);
				buildingMenu.dispose();
			}
			buildingMenu = new BuildingMenu(this, (GameFrame) frame);
		}
		else
		{
			
		}
		returnFocus();
	}
	
	/**
	 * Once the user has entered an empire name, this method starts the game and builds the empire.
	 * @author Jay Clegg
	 * @param empireName The name of the empire.
	 * @param dialog The dialog used to interact with the user.
	 */
	public void createEmpire(String empireName, NewGameDialog dialog)
	{
		this.empireName = empireName;
		
		dialog.dispose();
		frame.dispose();
		frame = new GameFrame(this);
	}
	
	/**
	 * Returns focus to the main contentPane so it can listen for hotkeys. Should be called at the end of each button action.
	 */
	private void returnFocus()
	{
		frame.getContentPane().requestFocus();
	}
}
