package game.view.gameMenu;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import game.controller.Controller;
import game.controller.WIP;
import gui.utility.JButton;
import gui.utility.MainPanel;

/**
 * The container for all the components in the in game menu.
 * @author Jay Clegg
 *
 */
public class MenuContentPane extends MainPanel
{
	/**
	 * The controller this reports to.
	 * @author Jay Clegg
	 */
	private Controller app;
	
	/**
	 * The panel to contain the buttons.
	 * @author Jay Clegg
	 */
	private JPanel buttonPanel;
	
	/**
	 * The dialog that contains the panel
	 * @author Jay Clegg
	 */
	private GameMenu frame;
	
	/**
	 * The layout for this panel.
	 * @author Jay Clegg
	 */
	private SpringLayout layout;
	
	/**
	 * The button to load a game.
	 * @author Jay Clegg
	 */
	private JButton loadButton;
	
	/**
	 * The button to go to the main menu.
	 * @author Jay Clegg
	 */
	private JButton mainMenuButton;
	
	/**
	 * The button to completely exit the game.
	 * @author Jay Clegg
	 */
	private JButton quitButton;
	
	/**
	 * The button to resume the game.
	 * @author Jay Clegg
	 */
	private JButton resumeButton;
	
	/**
	 * The button to save a game.
	 * @author Jay Clegg
	 */
	private JButton saveButton;
	
	/**
	 * The button to open the settings menu.
	 * @author Jay Clegg
	 */
	private JButton settingsButton;
	
	/**
	 * Builds the container and its components.
	 * @author Jay Clegg
	 * @param app The controller this reports to.
	 * @param frame The frame that contains this.
	 */
	public MenuContentPane(Controller app, GameMenu frame)
	{
		super();
		this.app = app;
		this.frame = frame;
		this.layout = new SpringLayout();
		this.buttonPanel = new JPanel(new GridLayout(0, 1, 0, 5));
		this.resumeButton = new JButton("Resume Game");
		this.settingsButton = new JButton("Settings");
		this.saveButton = new JButton("Save Game");
		this.loadButton = new JButton("Load Game");
		this.mainMenuButton = new JButton("Return to Main Menu");
		this.quitButton = new JButton("Exit");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	protected void setupLayout()
	{
		this.setLayout(layout);

		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, buttonPanel, -10, SpringLayout.EAST, this);
	}
	
	protected void setupListeners()
	{
		this.addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent key)
			{
			}

			@Override
			public void keyReleased(KeyEvent key)
			{
				if(key.getKeyChar() == KeyEvent.VK_ESCAPE)
				{
					frame.dispose();
				}
			}

			@Override
			public void keyTyped(KeyEvent key)
			{				
			}
		});
		
		resumeButton.addActionListener(click -> frame.dispose());
		settingsButton.addActionListener(click -> app.settings());
		saveButton.addActionListener(click -> app.saveGame(frame));
		loadButton.addActionListener(click -> app.loadGame(frame));
		mainMenuButton.addActionListener(click -> app.returnToMainMenu(frame));
		quitButton.addActionListener(click -> app.quit(frame));
	}
	
	protected void setupPanel()
	{
		this.setFocusable(true);
		
		buttonPanel.add(resumeButton);
		buttonPanel.add(settingsButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(mainMenuButton);
		buttonPanel.add(quitButton);
		
		this.add(buttonPanel);
	}
}
