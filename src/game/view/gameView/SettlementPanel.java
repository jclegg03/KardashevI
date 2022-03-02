package game.view.gameView;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
	private GridBagLayout listLayout;
	private GridBagConstraints listLayoutConstraints;
	private int settlementCount;
		
	public SettlementPanel(Controller app)
	{
		super();
		this.app = app;
		this.layout = new SpringLayout();
		this.settlementListHolder = new JScrollPane();
		this.settlementList = new JPanel();
		this.title = new JLabel("Settlements", SwingConstants.CENTER);
		this.listLayout = new GridBagLayout();
		this.listLayoutConstraints = new GridBagConstraints();
		this.settlementCount = 0;
		
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
		
		settlementList.setLayout(listLayout);
		listLayoutConstraints.gridx = 0;
		listLayoutConstraints.weightx = 1.0;
		listLayoutConstraints.weighty = 0;
//		listLayoutConstraints.gridheight = 2;
		listLayoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		listLayoutConstraints.anchor = GridBagConstraints.NORTH;
	}
	
	public void addSettlement(String name)
	{
		JButton settlement = new JButton(name);
		settlement.addActionListener(click -> app.selectSettlement(settlement.getText()));
		listLayoutConstraints.gridy = settlementCount;
		settlementList.add(settlement, listLayoutConstraints);
		settlementCount += 1;
		this.setVisible(false);
		this.setVisible(true);
	}
	
	public int getSettlementCount()
	{
		return this.settlementCount;
	}
	
	public void removeSettlement(String name)
	{
		try
		{
			this.remove(getSettlement(name));
		}
		catch(NullPointerException nullSettlement)
		{
			
		}
	}
	
	public void setSettlement(String name, String newName)
	{
		JButton settlement = getSettlement(name);
		if(settlement != null)
		{
			settlement.setText(newName);
		}
	}
	
	private JButton getSettlement(String name)
	{
		for(Component component : this.settlementList.getComponents())
		{
			JButton temp = (JButton) component;
			if(temp.getText().equals(name))
			{
				return temp;
			}
		}
		
		return null;
	}
}
