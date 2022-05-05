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
	private JLabel label;
	private SpringLayout layout;
	private LoadDialog parent;
	
	public LoadPanel(Controller app, String[] saves, LoadDialog parent)
	{
		super();
		this.app = app;
		this.saves = saves;
		this.scrollPane = new JScrollPane();
		this.buttonPanel = new JPanel();
		this.buttons = new JButton[saves.length];
		this.label = new JLabel("Saved Games");
		this.layout = new SpringLayout();
		this.parent = parent;
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupButtons()
	{
		for(int index = 0; index < buttons.length; index++)
		{
			JButton button = new JButton(saves[index].substring(0, saves[index].lastIndexOf(".kdsi")));
			buttons[index] = button;
			button.setName(index + "");
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

		this.add(label);
		this.add(scrollPane);
	}

	@Override
	protected void setupLayout()
	{
		buttonPanel.setLayout(new GridLayout(0, 1, 0, 3));
		this.setLayout(layout);
		
		layout.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.SOUTH, label);
		layout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, label);
		layout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, label, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, this);
	}

	@Override
	protected void setupListeners()
	{
		for(JButton button : buttons)
		{
			button.addActionListener(click -> update(button));
		}
	}

	private void update(JButton button)
	{
		app.setSaveIndex(Integer.parseInt(button.getName()));
		parent.dispose();
	}
}
