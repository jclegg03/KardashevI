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
	public GameFrame(Controller app)
	{
		super(app);
		this.contentPane = new GameContentPane(app, this);
		
		setupFrame();
	}
	
	/**
	 * Sets up visual and background details of the frame.
	 * @author Jay Clegg
	 */
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
