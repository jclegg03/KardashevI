package game.view.newGameDialog;

import java.awt.Toolkit;

import game.controller.Controller;
import game.view.mainMenu.MainMenu;

/**
 * The dialog for when a new game is started.
 * @author Jay Clegg
 *
 */
public class NewGameDialog extends javax.swing.JDialog
{
	private NewContentPane contentPane;
	
	/**
	 * Builds the new game dialog.
	 * @param app The controller this reports to.
	 * @param parent The parent frame of this dialog.
	 * @author Jay Clegg
	 */
	public NewGameDialog(Controller app, MainMenu parent)
	{
		super(parent, true);
		this.contentPane = new NewContentPane(app, this);
		
		setupDialog();
	}
	
	/**
	 * Sets the visual and back end components of this dialog.
	 * @author Jay Clegg
	 */
	private void setupDialog()
	{
		this.setLocation((int) (getParent().getBounds().getCenterX() - 250),
				(int) (getParent().getBounds().getCenterY() - 100));
		this.setUndecorated(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 200);
		this.setContentPane(contentPane);
		
		this.setVisible(true);
	}
}
