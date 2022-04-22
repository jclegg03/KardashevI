package game.view.exploreMenu;

import java.awt.Point;

import javax.swing.JDialog;

import game.controller.MapController;
import game.view.gameView.GameFrame;
import game.view.maps.Tile;
/**
 * The dialog for exploring a tile.
 * @author Jay Clegg
 *
 */
public class ExploreMenu extends JDialog
{
	private ExploreMenuPane contentPane;
	
	/**
	 * Builds the frame for exploring a tile.
	 * @author Jay Clegg
	 * @param app The controller for the game.
	 * @param parent The window that owns the dialog.
	 */
	public ExploreMenu(MapController app, GameFrame parent)
	{
		super(parent);
		this.contentPane = new ExploreMenuPane(app, this);
		
		Point position = parent.getMousePosition(true);
		position.x -= 100;
		position.y -= 50;
		if(position.y >= parent.getSize().height - 100)
		{
			position.y -= 100;
		}
		this.setLocation(position);
		
		setupFrame();
	}
	
	/**
	 * Helper method. Sets the visible and functional aspects of this dialog.
	 * @author Jay Clegg
	 */
	public void setupFrame()
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(contentPane);
		this.setSize(200, 100);
		this.setUndecorated(true);
		this.setVisible(true);
	}
}
