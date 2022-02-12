package game.view.mainMenu;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import game.controller.Controller;
import gui.utility.JButton;

public class MainContentPane extends JPanel
{
	private Controller app;
	private SpringLayout layout;
	private JPanel buttonPanel;
	private JButton newButton;
	private JButton loadButton;
	private JButton settingsButton;
	private JButton quitButton;
	
	public MainContentPane(Controller app)
	{
		super();
		this.app = app;
		this.layout = new SpringLayout();
		this.buttonPanel = new JPanel();
		
		this.newButton = new JButton("New Game");
		this.loadButton = new JButton("Load Game");
		this.settingsButton = new JButton("Settings");
		this.quitButton = new JButton("Quit");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		setupButtonPanel();
		this.add(buttonPanel);
		this.setFocusable(true);
		this.setBackground(java.awt.Color.BLUE);
	}
	
	private void setupButtonPanel()
	{
		buttonPanel.setLayout(new GridLayout(1, 0, 20, 0));
		buttonPanel.add(newButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(settingsButton);
		buttonPanel.add(quitButton);
		buttonPanel.setOpaque(false);
	}
	
	private void setupLayout()
	{
		this.setLayout(layout);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, Toolkit.getDefaultToolkit().getScreenSize().height / -8, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 20, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, buttonPanel, -20, SpringLayout.EAST, this);
	}
	
	private void setupListeners()
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
				if(key.getKeyChar() == 'q')
				{
					quitButton.doClick();
					return;
				}
				else if(key.getKeyChar() == 'n')
				{
					newButton.doClick();
					return;
				}
				else if(key.getKeyChar() == 'l')
				{
					loadButton.doClick();
					return;
				}
				else if(key.getKeyChar() == 's')
				{
					settingsButton.doClick();
				}
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}
			
		});

		newButton.addActionListener(click -> app.newGame());
		loadButton.addActionListener(click -> app.loadGame());
		settingsButton.addActionListener(click -> app.settings());
		quitButton.addActionListener(click -> app.confirmQuit());
	}
}
