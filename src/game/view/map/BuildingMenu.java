package game.view.map;

import javax.swing.JDialog;

import game.controller.Controller;
import game.view.gameView.GameFrame;

/**
 * The dialog for building on tiles.
 * @author Jay Clegg
 *
 */
public class BuildingMenu extends JDialog
{
	private Controller app;
	
	public BuildingMenu(Controller app, GameFrame parent, Tile tile)
	{
		super(parent, "Buildings");
		this.app = app;
		this.setLocationRelativeTo(tile);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(new BuildingMenuPane(app, this));
//		this.setUndecorated(true);
		this.setVisible(true);
	}
}
