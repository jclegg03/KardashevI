package gui.utility;

import javax.swing.JPanel;

import game.controller.Controller;

/**
 * The base class for most content panes.
 * @author Jay Clegg
 *
 */
public abstract class MainPanel extends JPanel
{
	/**
	 * Builds the main panel.
	 * @author Jay Clegg
	 */
	public MainPanel()
	{
		super();
	}
	
	/**
	 * Sets up the layout of the panel. To be implemented in subclasses.
	 * @author Jay Clegg
	 */
	protected abstract void setupLayout();
	
	/**
	 * Adds listeners to the components in the panel. To be implemented in subclasses.
	 * @author Jay Clegg
	 */
	protected abstract void setupListeners();
	
	/**
	 * Sets up the panel by adding components. To be implemented in subclasses.
	 * @author Jay Clegg
	 */
	protected abstract void setupPanel();
}
