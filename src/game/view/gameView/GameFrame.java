package game.view.gameView;

import javax.swing.JPanel;

import game.controller.Controller;
import gui.utility.JFrame;

public class GameFrame extends JFrame
{
	private JPanel contentPane;
	
	public GameFrame(Controller app)
	{
		super(app);
		this.contentPane = new GameContentPane(app, this);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(contentPane);
		
		this.setVisible(true);
	}
}
