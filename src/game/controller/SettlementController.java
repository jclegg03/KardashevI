package game.controller;

import java.io.Serializable;

import game.model.empire.Empire;
import game.view.gameView.GameContentPane;
import game.view.gameView.SettlementPanel;

/**
 * Adds settlements to the view as an empire expands.
 * @author Jay Clegg
 *
 */
@WIP
//Need to make a settlement class in the model.
//private HashMap <Settlement, JButton> settlements;
public class SettlementController implements Serializable
{
	/**
	 * The controller this reports to.
	 * @author Jay Clegg
	 */
	private Controller app;
	
	/**
	 * The settlement panel this controls.
	 * @author Jay Clegg
	 */
	private SettlementPanel settlementPanel;
	
	/**
	 * Builds a settlement controller.
	 * @author Jay Clegg
	 * @param app The controller that owns this settlement controller.
	 */
	public SettlementController(Controller app)
	{
		this.app = app;
	}
	
	/**
	 * Builds a settlement controller from a loaded empire.
	 * @author Jay Clegg
	 * @param empire The loaded empire.
	 * @param app The controller this reports to.
	 */
	@WIP
	//need to use the empire to generate data.
	//Can be done once the model and this class are written.
	public SettlementController(Empire empire, Controller app)
	{
		this.app = app;
	}
	
	/**
	 * Adds the settlement panel to this controller after it has been constructed.
	 * @author Jay Clegg
	 */
	public void finishSetup()
	{
		this.settlementPanel = ((GameContentPane) (app.getFrame().getContentPane())).getSettlementPanel();
		
		settlementPanel.addSettlement("Cave");
	}
	
	/**
	 * Selects a settlement when it is clicked.
	 * @author Jay Clegg
	 * @param name The name of the settlement selected.
	 */
	@WIP
	//Needs to display a building menu to show the options for the building.
	public void selectSettlement(String name)
	{
		settlementPanel.addSettlement("hello");
		
		app.returnFocus();
	}
	
	/**
	 * Adds a settlement with the specified name to the panel.
	 * @author Jay Clegg
	 * @param name The name of the settlement.
	 */
	public void addSettlement(String name)
	{
		settlementPanel.addSettlement(name);
	}
}
