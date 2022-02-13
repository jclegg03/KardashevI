package game.view.mainMenu;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import game.controller.Controller;
import gui.utility.JButton;

public class ExitContentPane extends JPanel
{
	private ExitDialog frame;
	private SpringLayout layout;
	private JLabel text;
	private JPanel buttonPanel;
	private JButton confirmButton;
	private JButton cancelButton;
	
	public ExitContentPane(Controller app, ExitDialog frame)
	{
		super();
		this.frame = frame;
		this.layout = new SpringLayout();
		this.text = new JLabel("Are you sure you want to quit?");
		this.buttonPanel = new JPanel();
		this.confirmButton = new JButton("Yes");
		this.cancelButton = new JButton("No");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		setupButtonPanel();
		this.add(text);
		this.add(buttonPanel);
	}
	
	private void setupButtonPanel()
	{
		buttonPanel.setLayout(new GridLayout(1, 0, 5, 0));
		buttonPanel.add(confirmButton);
		buttonPanel.add(cancelButton);
	}
	
	private void setupLayout()
	{
		this.setLayout(layout);
	}
	
	private void setupListeners()
	{
		
	}
}
