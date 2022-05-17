package game.view.saveDialog;

import javax.swing.JDialog;

import game.controller.Controller;

/**
 * The dialog to save a game.
 * @author Jay Clegg
 *
 */
public class SaveDialog extends JDialog
{
	/**
	 * The controller this reports to.
	 * @author Jay Clegg
	 */
	private Controller app;
	
	/**
	 * Builds the save dialog.
	 * @author Jay Clegg
	 * @param app The controller this reports to.
	 */
	public SaveDialog(Controller app)
	{
		super(app.getFrame(), true);
		this.app = app;
		
		setupDialog();
	}
	
	/**
	 * Helper method to set visible and back end aspects of the dialog.
	 * @author Jay Clegg
	 */
	private void setupDialog()
	{
		this.setContentPane(new SavePanel(app, this));
		this.setSize(500, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);
	}
}
