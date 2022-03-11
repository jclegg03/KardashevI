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
import game.controller.MapController;
import game.controller.SettlementController;
import game.view.gameMenu.GameMenu;
import game.view.maps.LocalMap;
import game.view.maps.Map;
import gui.utility.JButton;
import gui.utility.MainPanel;

public class GameContentPane extends MainPanel
{
	private Controller app;
	private GameFrame frame;
	private SpringLayout layout;
	private Map map;
	private ResourcePanel resourcePanel;
	private SettlementPanel settlementPanel;
	private JPanel utilityPanel;
	private JButton researchButton;
	private JButton menuButton;
	
	public GameContentPane(Controller app, SettlementController settlementController,
			MapController mapController, GameFrame frame)
	{
		super();
		this.app = app;
		this.frame = frame;
		this.layout = new SpringLayout();
		this.map = new LocalMap(mapController);
		layout.putConstraint(SpringLayout.SOUTH, map, 0, SpringLayout.SOUTH, this);
		this.resourcePanel = new ResourcePanel(app);
		layout.putConstraint(SpringLayout.NORTH, map, 0, SpringLayout.SOUTH, resourcePanel);
		layout.putConstraint(SpringLayout.NORTH, resourcePanel, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, resourcePanel, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, resourcePanel, 0, SpringLayout.EAST, this);
		this.settlementPanel = new SettlementPanel(settlementController);
		layout.putConstraint(SpringLayout.WEST, map, 0, SpringLayout.EAST, settlementPanel);
		layout.putConstraint(SpringLayout.SOUTH, resourcePanel, 0, SpringLayout.NORTH, settlementPanel);
		layout.putConstraint(SpringLayout.NORTH, settlementPanel, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, settlementPanel, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, settlementPanel, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, settlementPanel, (int) (-9 * Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), SpringLayout.EAST, this);
		this.utilityPanel = new JPanel();
		layout.putConstraint(SpringLayout.EAST, map, 0, SpringLayout.WEST, utilityPanel);
		layout.putConstraint(SpringLayout.NORTH, utilityPanel, 50, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, utilityPanel, (int) (9 * Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 10), SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, utilityPanel, 0, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, utilityPanel, 0, SpringLayout.EAST, this);
		this.researchButton = new JButton("Research");
		this.menuButton = new JButton("Menu");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	protected void setupPanel()
	{
		this.setFocusable(true);
		
		setupUtilityPanel();
		
		this.add(map);
		this.add(resourcePanel);
		this.add(settlementPanel);
		this.add(utilityPanel);
	}
	
	private void setupUtilityPanel()
	{
		utilityPanel.setLayout(new GridLayout(0, 1, 0, 5));
		utilityPanel.add(researchButton);
		utilityPanel.add(menuButton);
	}
	
	protected void setupLayout()
	{
		this.setLayout(layout);
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
				frame.getContentPane().requestFocus();
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
	
	public Map getMap()
	{
		return this.map;
	}
}
