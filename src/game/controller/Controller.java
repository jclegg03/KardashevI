package game.controller;

import java.io.Serializable;

import game.view.mainMenu.MainMenu;
import game.view.mainMenu.NewGameMenu;

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
		new NewGameMenu(this, test);
	}
	
	public void loadGame()
	{
		
	}
	
	public void settings()
	{
		
	}
	
	public void quit()
	{
		test.dispose();
	}
	
	public void createEmpire(String empireName)
	{
		this.empireName = empireName;
	}
}
