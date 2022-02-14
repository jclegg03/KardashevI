package game.view.gameView;

import javax.swing.JDialog;

import game.controller.Controller;

public class GameMenu extends JDialog
{
	private Controller app;
	private MenuContentPane contentPane;
	
	public GameMenu(Controller app, GameFrame parent)
	{
		super(parent, true);
		this.app = app;
		this.contentPane = new MenuContentPane(app, this);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 500);
		this.setLocation((int) (getParent().getBounds().getCenterX() - 150),
				(int) (getParent().getBounds().getCenterY() - 250));
		this.setContentPane(contentPane);
		this.setUndecorated(true);
		
		this.setVisible(true);
	}
}
