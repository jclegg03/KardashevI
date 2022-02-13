package game.view.inGameView;

import javax.swing.JPanel;

import game.controller.Controller;
import gui.utility.JFrame;

public class GameFrame extends JFrame
{
	private Controller app;
	private JPanel contentPane;
	
	public GameFrame(Controller app)
	{
		super(app);
		this.contentPane = new GameView(app, this);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(contentPane);
		
		this.setVisible(true);
	}
}
