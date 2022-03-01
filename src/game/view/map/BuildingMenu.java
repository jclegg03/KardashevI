package game.view.map;

import javax.swing.JDialog;

import game.controller.Controller;
import game.view.gameView.GameFrame;

public class BuildingMenu extends JDialog
{
	private Controller app;
	
	public BuildingMenu(Controller app, GameFrame parent)
	{
		super(parent, "Buildings");
		this.app = app;
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		this.setVisible(true);
	}
}
