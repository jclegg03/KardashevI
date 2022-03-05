package game.view.gameMenu;

import javax.swing.JDialog;

import game.controller.Controller;
import game.view.gameView.GameFrame;

public class GameMenu extends JDialog
{
	private MenuContentPane contentPane;
	
	public GameMenu(Controller app, GameFrame parent)
	{
		super(parent, true);
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
