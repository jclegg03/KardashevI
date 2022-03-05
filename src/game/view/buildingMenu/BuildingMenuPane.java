package game.view.buildingMenu;

import game.controller.Controller;
import game.controller.WIP;
import gui.utility.MainPanel;

/**
 * The content pane for the Building menu.
 * @author Jay Clegg
 *
 */
public class BuildingMenuPane extends MainPanel
{
	private BuildingMenu frame;
	
	
	public BuildingMenuPane(Controller app, BuildingMenu frame)
	{
		super(app);
		this.frame = frame;
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	@WIP
	protected void setupPanel()
	{
		
	}
	
	@WIP
	protected void setupLayout()
	{
		
	}
	
	@WIP
	protected void setupListeners()
	{
		
	}
}
