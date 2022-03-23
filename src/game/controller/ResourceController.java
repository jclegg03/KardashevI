package game.controller;

import game.view.gameView.GameFrame;
import game.view.gameView.ResourcePanel;

/**
 * This handles adding and removing resources from the resource bar as an empire progresses.
 * @author Jay Clegg
 *
 */
public class ResourceController
{
	private Controller app;
	private ResourcePanel resourcePanel;
	
	/**
	 * Builds the resource controller.
	 * @author Jay Clegg
	 * @param app
	 */
	public ResourceController(Controller app)
	{
		this.app = app;
	}
	
	/**
	 * Adds the resource panel data member after it has been initialized.
	 * @author Jay Clegg
	 */
	private void addResourcePanel()
	{
		this.resourcePanel =  ((GameFrame) app.getFrame()).getContentPane().getResourcePanel();
	}
}
