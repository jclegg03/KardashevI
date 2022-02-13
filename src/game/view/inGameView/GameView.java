package game.view.inGameView;

import game.controller.Controller;

public class GameView extends javax.swing.JPanel
{
	private Controller app;
	private GameFrame frame;
	
	public GameView(Controller app, GameFrame frame)
	{
		this.app = app;
		this.frame = frame;
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setFocusable(true);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
