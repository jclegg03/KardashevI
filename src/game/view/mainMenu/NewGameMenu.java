package game.view.mainMenu;

import java.awt.Toolkit;

import game.controller.Controller;

public class NewGameMenu extends javax.swing.JDialog
{
	private Controller app;
	private NewContentPane contentPane;
	
	public NewGameMenu(Controller app, MainMenu parent)
	{
		super(parent, true);
		this.app = app;
		this.contentPane = new NewContentPane(app, this);
		
		setupFrame();
	}
	
	private void setupFrame()
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
