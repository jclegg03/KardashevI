package game.view.gameView;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.controller.Controller;

public class ResourcePanel extends JPanel
{
	private Controller app;
	
	public ResourcePanel(Controller app)
	{
		this.app = app;
	}
	
	public void addResource(String name, int quantity, int increase)
	{
		JLabel label = new JLabel(name + "\n" + quantity);
		label.setToolTipText("Yearly gain: " + increase);
	}
}
