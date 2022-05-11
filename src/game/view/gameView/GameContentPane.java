package game.view.gameView;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import game.controller.Controller;
import game.view.gameMenu.GameMenu;
import game.view.maps.Map;
import gui.utility.JButton;
import gui.utility.MainPanel;

/**
 * The content pane for the game.
 * @author Jay Clegg
 *
 */
public class GameContentPane extends MainPanel
{
	private Controller app;
	private GameFrame frame;
	private SpringLayout layout;
	private JPanel mapPanel;
	private Map map;
	private ResourcePanel resourcePanel;
	private SettlementPanel settlementPanel;
	private JPanel toolbarPanel;
	private JButton researchButton;
	private JButton menuButton;
	private MapLevelSelector mapSelector;
	
	/**
	 * Builds the content pane.
	 * @param app The controller this class reports to.
	 * @param frame The frame this class is displayed in.
	 * @author Jay Clegg
	 */
	public GameContentPane(Controller app, GameFrame frame)
	{
		super();
		this.app = app;
		this.frame = frame;
		this.layout = new SpringLayout();
		this.mapPanel = new JPanel();
		this.map = app.getMapController().getCurrentMap();
		this.resourcePanel = new ResourcePanel(app.getResourceController());
		this.settlementPanel = new SettlementPanel(app.getSettlementController());
		this.toolbarPanel = new JPanel();
		this.researchButton = new JButton("Research");
		this.menuButton = new JButton("Menu");
		this.mapSelector = new MapLevelSelector(app.getMapController(), map);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	protected void setupPanel()
	{
		this.setFocusable(true);
		
		setupUtilityPanel();
		mapPanel.add(map);
		mapPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.add(mapPanel);
		this.add(resourcePanel);
		this.add(settlementPanel);
		this.add(toolbarPanel);
	}
	
	private void setupUtilityPanel()
	{
		toolbarPanel.setLayout(new GridLayout(0, 1, 0, 5));
		toolbarPanel.add(researchButton);
		toolbarPanel.add(menuButton);
	}
	
	protected void setupLayout()
	{
		this.setLayout(layout);
		
		layout.putConstraint(SpringLayout.SOUTH, mapPanel, 0, SpringLayout.SOUTH, this);
		
		layout.putConstraint(SpringLayout.NORTH, mapPanel, 0, SpringLayout.SOUTH, resourcePanel);
		layout.putConstraint(SpringLayout.NORTH, resourcePanel, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, resourcePanel, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, resourcePanel, 0, SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.WEST, mapPanel, 0, SpringLayout.EAST, settlementPanel);
		layout.putConstraint(SpringLayout.SOUTH, resourcePanel, 0, SpringLayout.NORTH, settlementPanel);
		layout.putConstraint(SpringLayout.NORTH, settlementPanel, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, settlementPanel, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, settlementPanel, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, settlementPanel, (int) (-9 * Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.EAST, mapPanel, 0, SpringLayout.WEST, toolbarPanel);
		layout.putConstraint(SpringLayout.NORTH, toolbarPanel, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, toolbarPanel, (int) (9 * Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, toolbarPanel, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, toolbarPanel, 0, SpringLayout.EAST, this);
	}
	
	protected void setupListeners()
	{
		this.addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent key)
			{
			}

			@Override
			public void keyPressed(KeyEvent key)
			{
			}

			@Override
			public void keyReleased(KeyEvent key)
			{
				if(key.getKeyChar() == KeyEvent.VK_ESCAPE)
				{
					menuButton.doClick();
				}
			}	
		});
		
		menuButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent click)
			{
				new GameMenu(app, frame);
				app.returnFocus();
			}
		});
	}
	
	public SettlementPanel getSettlementPanel()
	{
		return this.settlementPanel;
	}
	
	public ResourcePanel getResourcePanel()
	{
		return this.resourcePanel;
	}
	
	/**
	 * @return The toolbarPanel.
	 */
	public JPanel getToolbarPanel()
	{
		return toolbarPanel;
	}

	public Map getMap()
	{
		return this.map;
	}
	
	public void setMap(Map map)
	{
		mapPanel.remove(this.map);
		this.map = map;
		mapPanel.add(this.map);
		mapPanel.setVisible(false);
		mapPanel.setVisible(true);
		mapSelector.update(map);
	}
	
	/**
	 * Adds the map selector to the panel.
	 * @author Jay Clegg
	 */
	public void addMapSelector()
	{
		this.add(mapSelector);
		layout.putConstraint(SpringLayout.SOUTH, mapPanel, -110, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.SOUTH, mapSelector, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, mapSelector, 0, SpringLayout.WEST, toolbarPanel);
		layout.putConstraint(SpringLayout.WEST, mapSelector, 0, SpringLayout.EAST, settlementPanel);
		layout.putConstraint(SpringLayout.NORTH, mapSelector, 0, SpringLayout.SOUTH, mapPanel);
		this.setVisible(false);
		this.setVisible(true);
	}
}
