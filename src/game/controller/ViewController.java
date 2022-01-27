package game.controller;

import game.model.units.Resource;
import game.view.game.GameView;
import game.view.menu.MainMenuView;

public class ViewController
{
	public void displayMainMenu(Resource[] empireResources)
	{
//		MainMenuView menuView = new MainMenuView();
		GameView gameView = new GameView(empireResources);
	}
}
