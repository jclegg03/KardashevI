package game.view.loadDialog;

import javax.swing.JDialog;

import game.controller.Controller;
import gui.utility.JFrame;

/**
 * The dialog for loading up a save.
 * @author Jay Clegg
 *
 */
public class LoadDialog extends JDialog
{
	/**
	 * The controller this reports to.
	 * @author Jay Clegg
	 */
	private Controller app;
	
	/**
	 * Builds the load dialog to hold the loading options.
	 * @author Jay Clegg
	 * @param app The controller this reports to.
	 * @param parent The parent frame this is pausing.
	 * @param saves The names of all the save files.
	 */
	public LoadDialog(Controller app, JFrame parent, String[] saves)
	{
		super(parent, true);
		this.app = app;
		this.setContentPane(new LoadPanel(app, saves, this));
		
		setupDialog();
	}
	
	/**
	 * Sets up the visible and back end of this dialog.
	 * @author Jay Clegg
	 */
	private void setupDialog()
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 600);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setVisible(true);
	}
}
