package game.view.buildingMenu;

import javax.swing.JDialog;

import game.controller.MapController;
import game.controller.WIP;
import game.view.gameView.GameFrame;
import game.view.maps.Tile;

/**
 * The dialog for building on tiles.
 * @author Jay Clegg
 *
 */
@WIP
//Not sized
public class BuildingMenu extends JDialog
{
	/**
	 * The controller this reports to.
	 * @author Jay Clegg
	 */
	private MapController app;
	
	/**
	 * Makes the building menu.
	 * @author Jay Clegg
	 * @param app The map controller this reports to.
	 * @param parent The frame to which this belongs.
	 * @param tile Used to display this on the location that was clicked.
	 */
	public BuildingMenu(MapController app, GameFrame parent, Tile tile)
	{
		super(parent, "Buildings");
		this.app = app;
		this.setLocationRelativeTo(tile);
		
		setupFrame();
	}
	
	/**
	 * Helper method to build the frame. Sets the size, the look, and operations of this frame.
	 * @author Jay Clegg
	 */
	private void setupFrame()
	{
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(new BuildingMenuPane(app, this));
//		this.setUndecorated(true);
		this.setVisible(true);
	}
}
