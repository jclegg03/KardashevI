package game.view.mainMenu;

import game.controller.Controller;
import gui.utility.JFrame;

public class MainMenu extends JFrame
{
	private MainContentPane contentPane;
	
	public MainMenu (Controller app)
	{
		super(app);
		this.contentPane = new MainContentPane(app, this);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(contentPane);
		
		this.setVisible(true);
	}
	
	@Override
	public MainContentPane getContentPane()
	{
		return this.contentPane;
	}
}
