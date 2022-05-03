package game.controller;

import java.io.Serializable;

import game.view.gameView.GameContentPane;
import game.view.gameView.SettlementPanel;

/**
 * Adds settlements to the view as an empire expands.
 * @author Jay Clegg
 *
 */
public class SettlementController implements Serializable
{
	private Controller app;
	private SettlementPanel settlementPanel;
	//Need to make a settlement class in the model.
	//private HashMap <Settlement, JButton> settlements;
	
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
	 * @param name
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
