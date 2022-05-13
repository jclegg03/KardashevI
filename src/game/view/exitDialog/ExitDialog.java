package game.view.exitDialog;

import javax.swing.JDialog;

import game.controller.Controller;
import gui.utility.JFrame;

/**
 * The visible dialog for exiting the game.
 * @author Jay Clegg
 *
 */
public class ExitDialog extends JDialog
{
	/**
	 * The panel this holds.
	 * @author Jay Clegg
	 */
	private ExitContentPane contentPane;
	
	/**
	 * Builds the exit dialog.
	 * @author Jay Clegg
	 * @param app The controller this dialog reports to.
	 * @param parent The parent frame of this dialog.
	 */
	public ExitDialog(Controller app, JFrame parent)
	{
		super(parent, true);
		this.contentPane = new ExitContentPane(app, this);
		
		setupDialog();
	}
	
	/**
	 * Sets the visible and functional aspects of this dialog.
	 * @author Jay Clegg
	 */
	private void setupDialog()
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 200);
		this.setLocation((int) (getParent().getBounds().getCenterX() - 250),
				(int) (getParent().getBounds().getCenterY() - 100));
		this.setUndecorated(true);
		this.setContentPane(contentPane);
		
		this.setVisible(true);
	}
}
