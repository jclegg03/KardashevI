package game.view.inGameView;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import game.controller.Controller;
import gui.utility.JButton;

public class GameView extends JPanel
{
	private Controller app;
	private GameFrame frame;
	private SpringLayout layout;
	private JPanel utilityPanel;
	private JButton researchButton;
	private JButton menuButton;
	
	public GameView(Controller app, GameFrame frame)
	{
		this.app = app;
		this.frame = frame;
		this.layout = new SpringLayout();
		this.utilityPanel = new JPanel();
		this.researchButton = new JButton("Research");
		this.menuButton = new JButton("Menu");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setFocusable(true);
		
		setupButtonPanel();
		
		this.add(utilityPanel);
	}
	
	private void setupButtonPanel()
	{
		utilityPanel.setLayout(new GridLayout(0, 1, 0, 5));
		utilityPanel.add(researchButton);
		utilityPanel.add(menuButton);
	}
	
	private void setupLayout()
	{
		this.setLayout(layout);
	}
	
	private void setupListeners()
	{
		
	}
}
