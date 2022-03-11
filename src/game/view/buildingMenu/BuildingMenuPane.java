package game.view.buildingMenu;

import game.controller.MapController;
import game.controller.WIP;
import gui.utility.MainPanel;

/**
 * The content pane for the Building menu.
 * @author Jay Clegg
 *
 */
public class BuildingMenuPane extends MainPanel
{
	private MapController app;
	private BuildingMenu frame;
	
	public BuildingMenuPane(MapController app, BuildingMenu frame)
	{
		super();
		this.app = app;
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
