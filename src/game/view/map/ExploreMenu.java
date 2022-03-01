package game.view.map;

import javax.swing.JDialog;

import game.controller.Controller;
import game.view.gameView.GameFrame;
/**
 * The dialog for exploring a tile.
 * @author Jay Clegg
 *
 */
public class ExploreMenu extends JDialog
{
	private Controller app;
	
	/**
	 * Builds the frame for exploring a tile.
	 * @author Jay Clegg
	 * @param app The controller for the game.
	 * @param parent The window that owns the dialog.
	 */
	public ExploreMenu(Controller app, GameFrame parent)
	{
		super(parent);
		this.app = app;
		
		setupFrame();
	}
	
	public void setupFrame()
	{
//		this.setUndecorated(true);
		this.setVisible(true);
	}
}
