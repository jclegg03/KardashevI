package game.view.mainMenu;

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
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(contentPane);
		
		this.setVisible(true);
	}
}
