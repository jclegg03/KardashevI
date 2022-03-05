package game.view.newGameDialog;

import java.awt.Toolkit;

import game.controller.Controller;
import game.view.mainMenu.MainMenu;

public class NewGameDialog extends javax.swing.JDialog
{
	private NewContentPane contentPane;
	
	public NewGameDialog(Controller app, MainMenu parent)
	{
		super(parent, true);
		this.contentPane = new NewContentPane(app, this);
		
		setupDialog();
	}
	
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
