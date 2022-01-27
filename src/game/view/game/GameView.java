package game.view.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import game.model.units.Resource;
import game.view.maps.LocalMap;
import game.view.maps.Map;
import game.view.maps.WorldMap;

public class GameView
{
	private JFrame view;
	private JPanel resources;
	private Toolbar toolbar;
	private MapManager mapController;
	private JPanel settlements;
	private Map map;
	private ImageIcon icon;
	private Resource[] empireResources;
	private String mapLevel;
	
	static final String LOCAL_MAP = "Local Map";
	static final String REGION_MAP = "Regional Map";
	static final String WORLD_MAP = "World Map";
	
	public GameView(Resource[] empireResources)
	{
		this.view = new JFrame("Kardashev I");
		this.resources = new JPanel();
		this.toolbar = new Toolbar(view);
		this.mapLevel = LOCAL_MAP;
		this.mapController = new MapManager(mapLevel);
		this.settlements = new JPanel();
		this.map = new WorldMap();
		this.icon = new ImageIcon("C:/Users/unlim/eclipse-workspace/KardashevI/src/game/view/game icon.png");
		this.empireResources = empireResources;
		this.mapLevel = LOCAL_MAP;
		
		setupToolbars();
		setupMap();
		setupView();
	}
	
	private void setupToolbars()
	{
		setupResources();
		setupSettlements();
	}
	
	private void setupMap()
	{
		
	}
	
	private void setupView()
	{
		view.add(resources, BorderLayout.NORTH);
		view.add(toolbar, BorderLayout.WEST);
		view.add(mapController, BorderLayout.SOUTH);
		view.add(settlements, BorderLayout.EAST);
		view.add(map);
		view.setExtendedState(JFrame.MAXIMIZED_BOTH);
		view.setUndecorated(true);
		view.setIconImage(icon.getImage());
		view.setAlwaysOnTop(true);
		view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		view.setVisible(true);
	}
	
	private void setupResources()
	{
		for(Resource resource : empireResources)
		{
			JLabel material = new JLabel();
			String top = resource.getNumOwned() + "";
			String bottom;
			if(resource.getNumProduced() < 0)
			{
				bottom = "- " + -resource.getNumProduced();
			}
			else
			{
				bottom = "+ " + resource.getNumProduced();
			}
			material.setText("<html>"+ top + "<br>" + bottom + "</html>");
			material.setToolTipText(resource.getDescription());
			material.setHorizontalTextPosition(SwingConstants.RIGHT);
			resources.add(material);
		}
		resources.setBackground(Color.GRAY);
	}
	
	private void setupSettlements()
	{
		JLabel settlement = new JLabel("Settlement");
		
		settlements.add(settlement);
	}
}
