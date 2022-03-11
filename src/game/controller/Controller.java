package game.controller;

import java.io.Serializable;

import game.model.empire.Empire;
import game.view.exitDialog.ExitDialog;
import game.view.gameMenu.GameMenu;
import game.view.gameView.GameFrame;
import game.view.mainMenu.MainMenu;
import game.view.newGameDialog.NewGameDialog;
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
	
	/**
	 * Builds the game controller.
	 * @author Jay Clegg
	 */
	public Controller()
	{
		this.frame = new MainMenu(this);
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
	
	/**
	 * Once the user has entered an empire name, this method starts the game and builds the empire.
	 * @author Jay Clegg
	 * @param empireName The name of the empire.
	 * @param dialog The dialog used to interact with the user.
	 */
	@WIP
	public void createEmpire(String empireName, NewGameDialog dialog)
	{
		this.resourceController = new ResourceController(this);
		this.mapController = new MapController(this, null, null, null, null, null, null);
		this.settlementController = new SettlementController(this, null);
		this.toolbarController = new ToolbarController(this);
		
		dialog.dispose();
		frame.dispose();
		frame = new GameFrame(this, settlementController, mapController);
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
		return this.getFrame();
	}
}
