package game.view.map;

import javax.swing.JPanel;

import game.controller.Controller;

/**
 * The content pane for the Building menu.
 * @author Jay Clegg
 *
 */
public class BuildingMenuPane extends JPanel
{
	private Controller app;
	private BuildingMenu frame;
	
	
	public BuildingMenuPane(Controller app, BuildingMenu frame)
	{
		this.app = app;
		this.frame = frame;
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
