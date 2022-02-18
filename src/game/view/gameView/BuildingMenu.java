package game.view.gameView;

import javax.swing.JDialog;

import game.controller.Controller;

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
		this.setModalityType(null);
		
		this.setVisible(true);
	}
}
