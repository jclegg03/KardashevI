package game.view.exitDialog;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import game.controller.Controller;
import gui.utility.JButton;
import gui.utility.MainPanel;

public class ExitContentPane extends MainPanel
{
	private ExitDialog frame;
	private SpringLayout layout;
	private JLabel prompt;
	private JPanel buttonPanel;
	private JButton confirmButton;
	private JButton cancelButton;
	
	public ExitContentPane(Controller app, ExitDialog frame)
	{
		super(app);
		this.frame = frame;
		this.layout = new SpringLayout();
		this.prompt = new JLabel("Are you sure you want to quit?", SwingConstants.CENTER);
		this.buttonPanel = new JPanel();
		this.confirmButton = new JButton("Yes");
		this.cancelButton = new JButton("No");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	protected void setupPanel()
	{
		this.setFocusable(true);
		
		setupButtonPanel();
		
		this.add(prompt);
		this.add(buttonPanel);
	}
	
	private void setupButtonPanel()
	{
		buttonPanel.setLayout(new GridLayout(1, 0, 5, 0));
		buttonPanel.add(confirmButton);
		buttonPanel.add(cancelButton);
	}
	
	protected void setupLayout()
	{
		this.setLayout(layout);
		layout.putConstraint(SpringLayout.NORTH, prompt, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, prompt, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, prompt, -90, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, prompt, -10, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 10, SpringLayout.SOUTH, prompt);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 0, SpringLayout.WEST, prompt);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, buttonPanel, 0, SpringLayout.EAST, prompt);
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
				if(key.getKeyChar() == KeyEvent.VK_ENTER)
				{
					confirmButton.doClick();
				}
				else if(key.getKeyChar() == KeyEvent.VK_ESCAPE)
				{
					cancelButton.doClick();
				}
			}

			@Override
			public void keyReleased(KeyEvent key)
			{
			}
		});
		
		confirmButton.addActionListener(click -> app.quit(frame));
		cancelButton.addActionListener(click -> frame.dispose());
	}
}
