package game.view.mainMenu;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import game.controller.Controller;

public class ContentPane extends JPanel
{
	private Controller app;
	private SpringLayout layout;
	
	public ContentPane(Controller app)
	{
		super();
		this.app = app;
		this.layout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
