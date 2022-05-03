package game.view.saveDialog;

import javax.swing.JDialog;

import game.controller.Controller;

public class SaveDialog extends JDialog
{
	private Controller app;
	
	public SaveDialog(Controller app)
	{
		super(app.getFrame(), true);
		this.app = app;
		
		setupDialog();
	}
	
	private void setupDialog()
	{
		this.setContentPane(new SavePanel(app, this));
		this.setLocationRelativeTo(null);
//		this.setUndecorated(true);
		this.setVisible(true);
	}
}
