package game.view.buildingMenu;

import javax.swing.JDialog;

import game.controller.MapController;
import game.view.gameView.GameFrame;
import game.view.maps.Tile;

/**
 * The dialog for building on tiles.
 * @author Jay Clegg
 *
 */
public class BuildingMenu extends JDialog
{
	private MapController app;
	
	public BuildingMenu(MapController app, GameFrame parent, Tile tile)
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
