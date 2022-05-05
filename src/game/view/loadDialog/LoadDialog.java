package game.view.loadDialog;

import javax.swing.JDialog;

import game.controller.Controller;
import gui.utility.JFrame;

public class LoadDialog extends JDialog
{
	private Controller app;
	
	public LoadDialog(Controller app, JFrame parent, String[] saves)
	{
		super(parent, true);
		this.app = app;
		this.setContentPane(new LoadPanel(app, saves));
		
		setupDialog();
	}
	
	private void setupDialog()
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 600);
//		this.setUndecorated(true);
		this.setVisible(true);
	}
}
