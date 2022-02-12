package game.view.mainMenu;

import javax.swing.JPanel;

import game.controller.Controller;

public class ExitContentPane extends JPanel
{
	private ExitDialog frame;
	
	public ExitContentPane(Controller app, ExitDialog frame)
	{
		super();
		this.frame = frame;
	}
}
