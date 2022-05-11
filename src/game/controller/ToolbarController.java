package game.controller;

import java.io.Serializable;

import javax.swing.JPanel;

import game.view.gameView.GameContentPane;

/**
 * Class which handles the button calls from the toolbar.
 * @author Jay Clegg
 *
 */
public class ToolbarController implements Serializable
{
	/**
	 * The main controller this reports to.
	 * @author Jay Clegg
	 */
	private Controller app;
	
	/**
	 * The toolbar this controls.
	 * @author Jay Clegg
	 */
	private JPanel toolbar;
	
	/**
	 * Builds the toolbar controller.
	 * @author Jay Clegg
	 * @param app The main controller for this toolbar controller.
	 */
	public ToolbarController(Controller app)
	{
		this.app = app;
	}
	
	/**
	 * Finishes adding data members after the GUI has been initialized.
	 * @author Jay Clegg
	 */
	public void finishSetup()
	{
		this.toolbar = ((GameContentPane) (app.getFrame().getContentPane())).getToolbarPanel();
	}
	
	/**
	 * Displays the menu when the menu button is pressed.
	 * @author Jay Clegg
	 */
	@WIP
	//Does nothing.
	public void menu()
	{
		
	}
	
	/**
	 * Displays the research menu.
	 * @author Jay Clegg
	 */
	@WIP
	//Does nothing
	public void research()
	{
		
	}
	
	/**
	 * Displays the cheats menu.
	 * @author Jay Clegg
	 */
	@WIP
	//Does nothing.
	public void cheat()
	{
		
	}
}
