package game.view.gameView;

import game.controller.Controller;
import game.controller.MapController;
import game.controller.SettlementController;
import gui.utility.JFrame;

public class GameFrame extends JFrame
{
	private GameContentPane contentPane;
	
	public GameFrame(Controller app, SettlementController settlementController, MapController mapController)
	{
		super(app);
		this.contentPane = new GameContentPane(app, settlementController, mapController, this);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(contentPane);
		
		this.setVisible(true);
	}
	
	@Override
	public GameContentPane getContentPane()
	{
		return this.contentPane;
	}
}
