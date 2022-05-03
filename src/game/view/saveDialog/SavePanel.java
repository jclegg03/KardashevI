package game.view.saveDialog;

import javax.swing.JTextField;

import game.controller.Controller;
import gui.utility.JButton;
import gui.utility.MainPanel;

public class SavePanel extends MainPanel
{
	private Controller app;
	private SaveDialog parent;
	private JTextField nameField;
	private JButton confirmButton;
	private JButton cancelButton;
	
	public SavePanel(Controller app, SaveDialog parent)
	{
		super();
		this.app = app;
		this.parent = parent;
		this.nameField = new JTextField();
		this.confirmButton = new JButton();
		this.cancelButton = new JButton();
	}
	
	@Override
	protected void setupLayout()
	{
		
	}
	
	@Override
	protected void setupListeners()
	{
		
	}
	
	@Override
	protected void setupPanel()
	{
		
	}
}
