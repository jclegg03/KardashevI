package game.controller;

import java.io.Serializable;

import game.view.mainMenu.MainMenu;

public class Controller implements Serializable
{
	static final long serialVersionUID = 0l;
	private MainMenu test;
	
	public Controller()
	{
		this.test = new MainMenu(this);
	}
}
