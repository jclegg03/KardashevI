package game.controller;

import game.view.gameView.SettlementPanel;

public class SettlementController
{
	private Controller app;
	private SettlementPanel settlementPanel;
	
	public SettlementController(Controller app, SettlementPanel settlementPanel)
	{
		this.app = app;
		this.settlementPanel = settlementPanel;
	}
	
	public void selectSettlement(String name)
	{
		settlementPanel.addSettlement("hello");
		
		
		app.returnFocus();
	}
	
}
