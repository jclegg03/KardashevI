package game.view.gameView;

import game.controller.Controller;
import game.controller.MapController;
import game.controller.SettlementController;
import gui.utility.JFrame;

/**
 * The frame for the actual game.
 * @author Jay Clegg
 *
 */
public class GameFrame extends JFrame
{
	private GameContentPane contentPane;
	
	/**
	 * Builds the frame for the game.
	 * @author Jay Clegg
	 * @param app The controller this reports to.
	 * @param settlementController
	 * @param mapController
	 */
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
