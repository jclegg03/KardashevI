package game.controller;

import game.view.gameView.GameContentPane;
import game.view.gameView.SettlementPanel;

public class SettlementController
{
	private Controller app;
	private SettlementPanel settlementPanel;
	
	public SettlementController(Controller app)
	{
		this.app = app;
	}
	
	public void finishSetup()
	{
		this.settlementPanel = ((GameContentPane) (app.getFrame().getContentPane())).getSettlementPanel();
		
		settlementPanel.addSettlement("Cave");
	}
	
	public void selectSettlement(String name)
	{
		settlementPanel.addSettlement("hello");
		
		app.returnFocus();
	}
	
	public void addSettlement(String name)
	{
		settlementPanel.addSettlement(name);
	}
}
