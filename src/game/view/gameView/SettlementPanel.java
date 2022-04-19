package game.view.gameView;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import game.controller.SettlementController;
import gui.utility.JButton;
import gui.utility.MainPanel;

/**
 * The panel that holds all a empires settlements.
 * @author Jay Clegg
 *
 */
public class SettlementPanel extends MainPanel
{
	private SettlementController app;
	private SpringLayout layout;
	private SpringLayout settlementLayout;
	private JScrollPane settlementListHolder;
	private JPanel settlementList;
	private JLabel title;
	private int settlementCount;
	
	/**
	 * Builds the settlement panel.
	 * @author Jay Clegg
	 * @param app The controller this reports to.
	 */
	public SettlementPanel(SettlementController app)
	{
		super();
		this.app = app;
		this.layout = new SpringLayout();
		this.settlementLayout = new SpringLayout();
		this.settlementListHolder = new JScrollPane();
		this.settlementList = new JPanel();
		this.title = new JLabel("Settlements", SwingConstants.CENTER);
		this.settlementCount = 0;
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	protected void setupPanel()
	{
		settlementListHolder.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		settlementListHolder.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.add(title);
		this.add(settlementListHolder);
		settlementListHolder.setViewportView(settlementList);
		
	}
	
	protected void setupListeners()
	{
	}
	
	protected void setupLayout()
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
	}
	
	/**
	 * Updates the graphics of this panel.
	 * @author Jay Clegg
	 */
	private void update()
	{
		this.setVisible(false);
		this.setVisible(true);
	}
	
	/**
	 * Adds a settlement with the specified name to the panel.
	 * @author Jay Clegg
	 * @param name The name of the settlement.
	 */
	public void addSettlement(String name)
	{
		JButton settlement = new JButton(name);
		settlement.addActionListener(click -> app.selectSettlement(settlement.getText()));
		settlementList.add(settlement);
		settlementCount += 1;
		update();
	}
	
	public int getSettlementCount()
	{
		return this.settlementCount;
	}
	
	/**
	 * Removes the settlement with the specified name.
	 * @author Jay Clegg
	 * @param name The name of the settlement being removed.
	 * @throws NullPointerExeception If the specified settlement isn't found.
	 */
	public void removeSettlement(String name)
	{
		try
		{
			this.remove(getSettlement(name));
			update();
		}
		catch(NullPointerException nullSettlement)
		{
			throw new NullPointerException("No such settlement");
		}
	}
	
	/**
	 * Sets the name of a settlement.
	 * @author Jay Clegg
	 * @param name The old name of the settlement.
	 * @param newName The new name of the settlement.
	 * @throws NullPointerException If the settlement isn't found.
	 */
	public void setSettlement(String name, String newName)
	{
		JButton settlement = getSettlement(name);
		if(settlement != null)
		{
			settlement.setText(newName);
			update();
		}
		else
		{
			throw new NullPointerException("No such settlement");
		}
	}
	
	public JButton getSettlement(String name)
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
