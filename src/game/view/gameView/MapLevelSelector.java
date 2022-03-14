package game.view.gameView;

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
		
	}
	
	@Override
	protected void setupLayout()
	{
		
	}
	
	@Override
	protected void setupListeners()
	{
		
	}
	
	public void update()
	{
		this.setVisible(false);
		this.setVisible(true);
	}
}
