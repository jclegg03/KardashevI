package game.view.gameMenu;

import javax.swing.JDialog;

import game.controller.Controller;
import game.view.gameView.GameFrame;

/**
 * The in game menu's frame.
 * @author Jay Clegg
 *
 */
public class GameMenu extends JDialog
{
	/**
	 * The panel this dialog contains.
	 * @author Jay Clegg
	 */
	private MenuContentPane contentPane;
	
	/**
	 * Builds the frame for the menu.
	 * @author Jay Clegg
	 * @param app The controller this reports to.
	 * @param parent The parent frame of the menu.
	 */
	public GameMenu(Controller app, GameFrame parent)
	{
		super(parent, true);
		this.contentPane = new MenuContentPane(app, this);
		
		setupFrame();
	}
	
	/**
	 * Helper method. Adjusts the visible and functional components of this frame.
	 * @author Jay Clegg
	 */
	private void setupFrame()
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 500);
		this.setLocation((int) (getParent().getBounds().getCenterX() - 150),
				(int) (getParent().getBounds().getCenterY() - 250));
		this.setContentPane(contentPane);
		this.setUndecorated(true);
		
		this.setVisible(true);
	}
}
