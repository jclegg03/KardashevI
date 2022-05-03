package game.view.saveDialog;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import game.controller.Controller;
import gui.utility.JButton;
import gui.utility.MainPanel;

public class SavePanel extends MainPanel
{
	private Controller app;
	private SaveDialog parent;
	private JTextField nameField;
	private JPanel buttonPanel;
	private JButton confirmButton;
	private JButton cancelButton;
	private SpringLayout layout;
	
	public SavePanel(Controller app, SaveDialog parent)
	{
		super();
		this.app = app;
		this.parent = parent;
		this.nameField = new JTextField();
		this.buttonPanel = new JPanel();
		this.confirmButton = new JButton("Confirm");
		this.cancelButton = new JButton("Cancel");
		this.layout = new SpringLayout();
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 55, SpringLayout.NORTH, this);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	@Override
	protected void setupLayout()
	{
		this.setLayout(layout);
		buttonPanel.setLayout(new GridLayout(1, 0, 10, 0));
		
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 0, SpringLayout.WEST, nameField);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -5, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, buttonPanel, 0, SpringLayout.EAST, nameField);
		layout.putConstraint(SpringLayout.NORTH, nameField, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, nameField, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, nameField, -5, SpringLayout.NORTH, buttonPanel);
		layout.putConstraint(SpringLayout.EAST, nameField, -10, SpringLayout.EAST, this);
	}
	
	@Override
	protected void setupListeners()
	{
		
	}
	
	@Override
	protected void setupPanel()
	{
		this.add(nameField);
		this.add(buttonPanel);
		
		buttonPanel.add(cancelButton);
		buttonPanel.add(confirmButton);
	}
}
