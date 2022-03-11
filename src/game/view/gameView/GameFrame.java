package game.view.gameView;

import javax.swing.JPanel;

import game.controller.Controller;
import game.controller.MapController;
import game.controller.SettlementController;
import gui.utility.JFrame;

public class GameFrame extends JFrame
{
	private JPanel contentPane;
	
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
}
