package game.view.gameView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JTextArea;
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
	private JTextArea mapName;
	
	public MapLevelSelector(MapController app, Map currentMap)
	{
		super();
		this.app = app;
		this.currentMap = currentMap;
		this.layout = new SpringLayout();
		this.zoomOutButton = new JButton();
		this.mapLevel = new JLabel(currentMap.getLevel());
		this.mapName = new JTextArea(currentMap.getName());
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	@Override
	protected void setupPanel()
	{
		this.add(zoomOutButton);
		this.add(mapLevel);
		this.add(mapName);
	}
	
	@Override
	protected void setupLayout()
	{
		this.setLayout(layout);
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
					update();
					app.getController().returnFocus();
				}
			}

			@Override
			public void keyReleased(KeyEvent key)
			{
			}
		});
	}
	
	public void update()
	{
		this.setVisible(false);
		this.setVisible(true);
	}
}
