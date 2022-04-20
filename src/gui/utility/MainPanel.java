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
	protected abstract void setupPanel();
	protected abstract void setupLayout();
	protected abstract void setupListeners();
}
