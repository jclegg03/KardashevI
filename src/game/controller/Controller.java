package game.controller;

import java.io.Serializable;

import game.view.gameMenu.GameMenu;
import game.view.gameView.GameFrame;
import game.view.mainMenu.ExitDialog;
import game.view.mainMenu.MainMenu;
import game.view.mainMenu.NewGameDialog;
import gui.utility.JFrame;

public class Controller implements Serializable
{
	static final long serialVersionUID = 0l;
	private JFrame test;
	private String empireName;
	
	public Controller()
	{
		this.test = new MainMenu(this);
		this.empireName = "";
	}
	
	public void newGame()
	{
		new NewGameDialog(this, (MainMenu) test);
		test.getContentPane().requestFocus();
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
		test.dispose();
	}
	
	/**
	 * Quits the game from in a game.
	 * @param menu The in game menu.
	 */
	public void quit(GameMenu menu)
	{
		menu.setVisible(false);
		new ExitDialog(this, test);
		if(test.isActive())
		{
			menu.setVisible(true);
		}
		else
		{
			menu.dispose();
		}
	}
	
	public void returnToMainMenu(GameMenu menu)
	{
		menu.dispose();
		test.dispose();
		test = new MainMenu(this);
	}
	
	public void selectSettlement(String name)
	{
		
		
		
		returnFocus();
	}
	
	public void createEmpire(String empireName, NewGameDialog frame)
	{
		this.empireName = empireName;
		
		frame.dispose();
		test.dispose();
		test = new GameFrame(this);
	}
	
	/**
	 * Returns focus to the main contentPane so it can listen for hotkeys. Should be called at the end of each button listneer.
	 */
	private void returnFocus()
	{
		test.getContentPane().requestFocus();
	}
}
