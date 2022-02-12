package game.view.mainMenu;

import javax.swing.JDialog;

public class ExitDialog extends JDialog
{
	private ExitContentPane contentPane;
	
	public ExitDialog(MainMenu parent)
	{
		super(parent, true);
		this.contentPane = new ExitContentPane(this);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		
		
		this.setVisible(true);
	}
}
