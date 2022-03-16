package game.view.gameView;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import game.controller.MapController;
import game.view.maps.Map;
import gui.utility.JButton;
import gui.utility.MainPanel;

public class MapLevelSelector extends MainPanel
{
	private MapController app;
	private Map currentMap;
	private SpringLayout layout;
	private JButton zoomOutButton;
	private JLabel mapLevel;
	private JTextField mapName;
	
	public MapLevelSelector(MapController app, Map currentMap)
	{
		super();
		this.app = app;
		this.currentMap = currentMap;
		this.layout = new SpringLayout();
		this.zoomOutButton = new JButton();
		this.mapLevel = new JLabel(currentMap.getLevel());
		this.mapName = new JTextField(currentMap.getName());
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	@Override
	protected void setupPanel()
	{
		mapLevel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		mapName.setFont(mapLevel.getFont());
		
		this.add(zoomOutButton);
		this.add(mapLevel);
		this.add(mapName);
	}
	
	@Override
	protected void setupLayout()
	{
		this.setLayout(layout);
		layout.putConstraint(SpringLayout.NORTH, mapName, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, mapName, 5, SpringLayout.EAST, mapLevel);
		layout.putConstraint(SpringLayout.SOUTH, mapName, -5, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, mapName, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, mapLevel, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, mapLevel, 5, SpringLayout.EAST, zoomOutButton);
		layout.putConstraint(SpringLayout.SOUTH, mapLevel, -5, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, mapLevel, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, zoomOutButton, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, zoomOutButton, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, zoomOutButton, -5, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, zoomOutButton, 105, SpringLayout.WEST, this);
	}
	
	@Override
	protected void setupListeners()
	{
		zoomOutButton.addActionListener(click -> app.zoomOut());
		
		mapName.addKeyListener(new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent key)
			{
			}

			@Override
			public void keyPressed(KeyEvent key)
			{
				if(key.getKeyChar() == KeyEvent.VK_ENTER)
				{
					currentMap.setName(mapName.getText());
					app.updateMapName(mapName.getText());
					update(currentMap);
					app.getController().returnFocus();
				}
			}

			@Override
			public void keyReleased(KeyEvent key)
			{
			}
		});
	}
	
	public void update(Map map)
	{
		this.currentMap = map;
		mapName.setText(map.getName());
		mapLevel.setText(map.getLevel());
		this.setVisible(false);
		this.setVisible(true);
	}
}
