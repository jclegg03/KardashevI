package game.view.gameView;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import game.controller.Controller;
import gui.utility.JButton;
import javax.swing.border.BevelBorder;

public class SettlementPanel extends JPanel
{
	private Controller app;
	private JScrollPane settlementListHolder;
	private JPanel settlementList;
	private JLabel title;
	private JButton test;
	
	public SettlementPanel(Controller app)
	{
		super();
		this.app = app;
		this.settlementListHolder = new JScrollPane();
		this.settlementList = new JPanel();
		this.title = new JLabel("Settlements", SwingConstants.CENTER);
		this.test = new JButton("test");
		
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
		settlementList.add(test);
		
		addSettlement("hi");
	}
	
	private void setupListeners()
	{
	}
	
	private void setupLayout()
	{
		this.setLayout(new GridLayout(0, 1));
		
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
		settlement.addActionListener(click -> app.selectSettlement(name));
		settlementList.add(settlement);
		
	}
}
