package game.view.mainMenu;

import game.controller.Controller;
import gui.utility.JFrame;

/**
 * The frame for the main menu.
 * @author Jay Clegg
 *
 */
public class MainMenu extends JFrame
{
	private MainContentPane contentPane;
	
	/**
	 * Builds the main menu.
	 * @param app The controller this reports to.
	 * @author Jay Clegg
	 */
	public MainMenu (Controller app)
	{
		super(app);
		this.contentPane = new MainContentPane(app, this);
		
		setupFrame();
	}
	
	/**
	 * Sets up the frame with visible and back end details.
	 * @author Jay Clegg
	 */
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
