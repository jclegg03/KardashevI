package game.controller;

import java.io.Serializable;

import game.view.mainMenu.ExitDialog;
import game.view.mainMenu.MainMenu;
import game.view.mainMenu.NewGameDialog;

public class Controller implements Serializable
{
	static final long serialVersionUID = 0l;
	private MainMenu test;
	private String empireName;
	
	public Controller()
	{
		this.test = new MainMenu(this);
		this.empireName = "";
	}
	
	public void newGame()
	{
		new NewGameDialog(this, test);
		test.getContentPane().requestFocus();
	}
	
	public void loadGame()
	{
		
	}
	
	public void settings()
	{
		
	}
	
	public void confirmQuit()
	{
		new ExitDialog(this, test);
	}
	
	public void createEmpire(String empireName)
	{
		this.empireName = empireName;
	}
}
