package game.view.mainMenu;

import game.controller.Controller;
import gui.utility.JFrame;

public class MainMenu extends JFrame
{
	private ContentPane contentPane;
	
	public MainMenu (Controller app)
	{
		super(app);
		this.contentPane = new ContentPane(this.app);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(contentPane);
		
		this.setVisible(true);
	}
}
