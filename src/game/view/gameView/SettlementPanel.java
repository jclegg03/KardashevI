package game.view.gameView;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import game.controller.Controller;
import gui.utility.JButton;

public class SettlementPanel extends JPanel
{
	private Controller app;
	private SpringLayout layout;
	private JScrollPane settlementListHolder;
	private JPanel settlementList;
	private JLabel title;
		
	public SettlementPanel(Controller app)
	{
		super();
		this.app = app;
		this.layout = new SpringLayout();
		this.settlementListHolder = new JScrollPane();
		this.settlementList = new JPanel();
		this.title = new JLabel("Settlements", SwingConstants.CENTER);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		settlementListHolder.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		settlementListHolder.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(title);
		this.add(settlementListHolder);
		settlementListHolder.setViewportView(settlementList);
		
		addSettlement("Cave");
	}
	
	private void setupListeners()
	{
	}
	
	private void setupLayout()
	{
		this.setLayout(layout);
		
		layout.putConstraint(SpringLayout.SOUTH, title, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, settlementListHolder, 0, SpringLayout.SOUTH, title);
		layout.putConstraint(SpringLayout.WEST, settlementListHolder, 0, SpringLayout.WEST, title);
		layout.putConstraint(SpringLayout.EAST, settlementListHolder, 0, SpringLayout.EAST, title);
		layout.putConstraint(SpringLayout.NORTH, title, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, title, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, title, 0, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, settlementListHolder, 0, SpringLayout.SOUTH, this);
		
		GridLayout settlementLayout = new GridLayout(0, 1, 0, 2);
		settlementList.setLayout(settlementLayout);
	}
	
	public JScrollPane getSettlementList()
	{
		return this.settlementListHolder;
	}
	
	public void addSettlement(String name)
	{
		JButton settlement = new JButton(name);
		settlement.addActionListener(click -> app.selectSettlement(settlement.getText()));
		settlementList.add(settlement);
	}
	
	public void removeSettlement(String name)
	{
		for(Component component : this.settlementList.getComponents())
		{
			JButton temp = (JButton) component;
			if(temp.getText().equals(name))
			{
				settlementList.remove(component);
			}
		}
	}
}
