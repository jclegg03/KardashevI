package game.view.exploreMenu;

import java.awt.GridLayout;

import game.controller.MapController;
import gui.utility.JButton;
import gui.utility.MainPanel;

/**
 * The content pane for the exploring menu.
 * @author Jay Clegg
 *
 */
public class ExploreMenuPane extends MainPanel
{
	private MapController app;
	private JButton exploreButton;
	private JButton cancelButton;
	private ExploreMenu frame;
	
	/**
	 * Builds this content pane.
	 * @author Jay Clegg
	 * @param app The controller this reports to.
	 * @param frame The parent frame of this container.
	 */
	public ExploreMenuPane(MapController app, ExploreMenu frame)
	{
		super();
		this.app = app;
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
