package game.view.buildingMenu;

import game.controller.MapController;
import game.controller.WIP;
import gui.utility.MainPanel;

/**
 * The content pane for the Building menu.
 * @author Jay Clegg
 *
 */
@WIP
//Empty for now.
public class BuildingMenuPane extends MainPanel
{
	/**
	 * The controller this reportrs to.
	 * @author Jay Clegg
	 */
	private MapController app;
	
	/**
	 * The parent dialog of this.
	 * @author Jay Clegg
	 */
	private BuildingMenu frame;
	
	/**
	 * Makes the holder for the contents of the building menu.
	 * @author Jay Clegg
	 * @param app The controller this reports to.
	 * @param frame The frame which holds this.
	 */
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
	//empty
	protected void setupPanel()
	{
		
	}
	
	@WIP
	//empty
	protected void setupLayout()
	{
		
	}
	
	@WIP
	//empty
	protected void setupListeners()
	{
		
	}
}
