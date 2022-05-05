package game.view.loadDialog;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import game.controller.Controller;
import gui.utility.JButton;
import gui.utility.MainPanel;

public class LoadPanel extends MainPanel
{
	private Controller app;
	private String[] saves;
	private JScrollPane scrollPane;
	private JPanel buttonPanel;
	private JButton[] buttons;
	private SpringLayout layout;
	
	public LoadPanel(Controller app, String[] saves)
	{
		super();
		this.app = app;
		this.saves = saves;
		this.scrollPane = new JScrollPane();
		this.buttonPanel = new JPanel();
		this.buttons = new JButton[saves.length];
		this.layout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupButtons()
	{
		for(int index = 0; index < buttons.length; index++)
		{
			buttons[index] = new JButton(saves[index].substring(0, saves[index].lastIndexOf(".kdsi")));
		}
	}

	@Override
	protected void setupPanel()
	{
		setupButtons();
		
		for(JButton button : buttons)
		{
			buttonPanel.add(button);
		}
		
		scrollPane.setViewportView(buttonPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		this.add(new JLabel("Saves"));
		this.add(scrollPane);
	}

	@Override
	protected void setupLayout()
	{
		buttonPanel.setLayout(new GridLayout(0, 1, 0, 3));
		this.setLayout(layout);
		
	}

	@Override
	protected void setupListeners()
	{
		// TODO Auto-generated method stub
		
	}
}
