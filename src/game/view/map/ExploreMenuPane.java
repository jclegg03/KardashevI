package game.view.map;

import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

import game.controller.Controller;
import gui.utility.JButton;

/**
 * The content pane for the exploring menu.
 * @author Jay Clegg
 *
 */
public class ExploreMenuPane extends JPanel
{
	private Controller app;
	private JButton exploreButton;
	private JButton cancelButton;
	private ExploreMenu frame;
	
	public ExploreMenuPane(Controller app, ExploreMenu frame)
	{
		this.app = app;
		this.exploreButton = new JButton("Explore");
		this.cancelButton = new JButton("Cancel");
		this.frame = frame;
		
		setupFrame();
		setupLayout();
		setupListeners();
	}
	
	private void setupFrame()
	{
		this.add(exploreButton);
		this.add(cancelButton);
	}
	
	private void setupLayout()
	{
		this.setLayout(new GridLayout(0, 1, 5, 5));
	}
	
	private void setupListeners()
	{
		exploreButton.addActionListener(click -> app.exploreTile());
		cancelButton.addActionListener(click -> frame.dispose());
	}
}
