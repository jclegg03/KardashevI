package game.view.mainMenu;

import javax.swing.JDialog;

import game.controller.Controller;

public class ExitDialog extends JDialog
{
	private ExitContentPane contentPane;
	
	public ExitDialog(Controller app, MainMenu parent)
	{
		super(parent, true);
		this.contentPane = new ExitContentPane(app, this);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 200);
		this.setLocation((int) (getParent().getBounds().getCenterX() - 250),
				(int) (getParent().getBounds().getCenterY() - 100));
		this.setUndecorated(true);
		this.setContentPane(contentPane);
		
		this.setVisible(true);
	}
}
