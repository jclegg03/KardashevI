package game.view.gameView;

import javax.swing.JDialog;

import game.controller.Controller;

public class GameMenu extends JDialog
{
	private Controller app;
	
	public GameMenu(Controller app, GameFrame parent)
	{
		super(parent, true);
		this.app = app;
	}
}
