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
	private Controller app;
	private GameMenu frame;
	private SpringLayout layout;
	private JPanel buttonPanel;
	private JButton resumeButton;
	private JButton settingsButton;
	private JButton saveButton;
	private JButton loadButton;
	private JButton mainMenuButton;
	private JButton quitButton;
	
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
	
	protected void setupLayout()
	{
		this.setLayout(layout);

		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, buttonPanel, -10, SpringLayout.EAST, this);
	}
	
	@WIP
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
					frame.dispose();
				}
			}
		});
		
		resumeButton.addActionListener(click -> frame.dispose());
		//settings
		//save
		//load
		mainMenuButton.addActionListener(click -> app.returnToMainMenu(frame));
		quitButton.addActionListener(click -> app.quit(frame));
	}
}
