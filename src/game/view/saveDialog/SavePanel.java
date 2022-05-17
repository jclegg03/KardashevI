package game.view.saveDialog;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import game.controller.Controller;
import gui.utility.JButton;
import gui.utility.MainPanel;

/**
 * The panel to hold the components in the save dialog.
 * @author Jay Clegg
 *
 */
public class SavePanel extends MainPanel
{
	/**
	 * The controller this reports to.
	 * @author Jay Clegg
	 */
	private Controller app;
	
	/**
	 * The panel to hold the buttons.
	 * @author Jay Clegg
	 */
	private JPanel buttonPanel;
	
	/**
	 * The button to cancel saving.
	 * @author Jay Clegg
	 */
	private JButton cancelButton;
	
	/**
	 * The button to confirm the save.
	 * @author Jay Clegg
	 */
	private JButton confirmButton;
	
	/**
	 * The text field for users to put details in.
	 * @author Jay Clegg
	 */
	private JTextField detailsField;
	
	/**
	 * The layout for this panel.
	 * @author Jay Clegg
	 */
	private SpringLayout layout;
	
	/**
	 * The save dialog that holds this panel.
	 * @author Jay Clegg
	 */
	private SaveDialog parent;
	
	/**
	 * Builds the save panel.
	 * @author Jay Clegg
	 * @param app The controller this reports to.
	 * @param parent The save dialog that holds this panel.
	 */
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
	
	/**
	 * 
	 * @author Jay Clegg
	 */
	private void confirm()
	{
		app.save(detailsField.getText());
		parent.dispose();
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
}
