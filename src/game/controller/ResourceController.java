package game.controller;

import java.io.Serializable;

import game.model.empire.Empire;
import game.view.gameView.GameFrame;
import game.view.gameView.ResourcePanel;

/**
 * This handles adding and removing resources from the resource bar as an empire progresses.
 * @author Jay Clegg
 *
 */
public class ResourceController implements Serializable
{
	/**
	 * The controller this reports to.
	 * @author Jay Clegg
	 */
	private Controller app;
	
	/**
	 * The resource panel this controls.
	 * @author Jay Clegg
	 */
	private ResourcePanel resourcePanel;
	
	/**
	 * Builds the resource controller.
	 * @author Jay Clegg
	 * @param app The controller this reports to.
	 */
	public ResourceController(Controller app)
	{
		this.app = app;
	}
	
	/**
	 * Builds the resource controller from a loaded empire.
	 * @author Jay Clegg
	 * @param empire The loaded empire.
	 * @param app The controller this reports to.
	 */
	@WIP
	//Need to use the empire to initialize data.
	// Can be done once this class and other mechanics are finihsed.
	public ResourceController(Empire empire, Controller app)
	{
		this.app = app;
	}
	
	/**
	 * Adds the resource panel data member after it has been initialized.
	 * @author Jay Clegg
	 */
	public void finishSetup()
	{
		this.resourcePanel =  ((GameFrame) app.getFrame()).getContentPane().getResourcePanel();
	}
}
