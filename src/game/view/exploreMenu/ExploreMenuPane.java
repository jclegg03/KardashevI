package game.view.exploreMenu;

import java.awt.GridLayout;

import game.controller.Controller;
import gui.utility.JButton;
import gui.utility.MainPanel;

/**
 * The content pane for the exploring menu.
 * @author Jay Clegg
 *
 */
public class ExploreMenuPane extends MainPanel
{
	private JButton exploreButton;
	private JButton cancelButton;
	private ExploreMenu frame;
	
	public ExploreMenuPane(Controller app, ExploreMenu frame)
	{
		super(app);
		this.exploreButton = new JButton("Explore");
		this.cancelButton = new JButton("Cancel");
		this.frame = frame;
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	protected void setupPanel()
	{
		this.add(exploreButton);
		this.add(cancelButton);
	}
	
	protected void setupLayout()
	{
		this.setLayout(new GridLayout(0, 1, 5, 5));
	}
	
	protected void setupListeners()
	{
		exploreButton.addActionListener(click -> app.exploreTile());
		cancelButton.addActionListener(click -> frame.dispose());
	}
}
