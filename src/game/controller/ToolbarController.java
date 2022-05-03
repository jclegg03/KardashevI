package game.controller;

import java.io.Serializable;

/**
 * Class which handles the button calls from the toolbar.
 * @author Jay Clegg
 *
 */
public class ToolbarController implements Serializable
{
	private Controller app;
	
	/**
	 * Builds the toolbar controller.
	 * @author Jay Clegg
	 * @param app The main controller for this toolbar controller.
	 */
	public ToolbarController(Controller app)
	{
		this.app = app;
	}
}
