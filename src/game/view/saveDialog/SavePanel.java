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
	private JTextField detailsField;
	private JPanel buttonPanel;
	private JButton confirmButton;
	private JButton cancelButton;
	private SpringLayout layout;
	
	public SavePanel(Controller app, SaveDialog parent)
	{
		super();
		this.app = app;
		this.parent = parent;
		this.detailsField = new JTextField();
		this.buttonPanel = new JPanel();
		this.confirmButton = new JButton("Confirm");
		this.cancelButton = new JButton("Cancel");
		this.layout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	@Override
	protected void setupLayout()
	{
		this.setLayout(layout);
		buttonPanel.setLayout(new GridLayout(1, 0, 10, 0));
		
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 55, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 0, SpringLayout.WEST, detailsField);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -5, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, buttonPanel, 0, SpringLayout.EAST, detailsField);
		layout.putConstraint(SpringLayout.NORTH, detailsField, 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, detailsField, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, detailsField, -5, SpringLayout.NORTH, buttonPanel);
		layout.putConstraint(SpringLayout.EAST, detailsField, -10, SpringLayout.EAST, this);
	}
	
	@Override
	protected void setupListeners()
	{
		cancelButton.addActionListener(click -> parent.dispose());
		confirmButton.addActionListener(click -> confirm());
	}
	
	@Override
	protected void setupPanel()
	{
		this.add(detailsField);
		this.add(buttonPanel);
		
		buttonPanel.add(cancelButton);
		buttonPanel.add(confirmButton);
	}
	
	private void confirm()
	{
		app.save(detailsField.getText());
		parent.dispose();
	}
}
