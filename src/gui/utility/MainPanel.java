package gui.utility;

import javax.swing.JPanel;

import game.controller.Controller;

public abstract class MainPanel extends JPanel
{	
	public MainPanel()
	{
	}
	protected abstract void setupPanel();
	protected abstract void setupLayout();
	protected abstract void setupListeners();
}
