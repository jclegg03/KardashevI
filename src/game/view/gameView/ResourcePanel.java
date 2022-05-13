package game.view.gameView;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.controller.ResourceController;

/**
 * The panel which contains the resources (JLabels).
 * @author Jay Clegg
 *
 */
public class ResourcePanel extends JPanel
{
	/**
	 * The controller this reports to.
	 * @author Jay Clegg
	 */
	private ResourceController app;
	
	/**
	 * Builds the resourcePanel.
	 * @author Jay Clegg
	 * @param app The Controller this reports to.
	 */
	public ResourcePanel(ResourceController app)
	{
		super();
		this.app = app;
		this.setLayout(new GridLayout(1, 0, 10, 0));
		
		addResource("Population", 20, -1);
	}
	
	/**
	 * Updates the visual details of this panel.
	 * @author Jay Clegg
	 */
	private void update()
	{
		this.setVisible(false);
		this.setVisible(true);
	}
	
	/**
	 * Adds a resource of the given name, quantity, and yearly gain to the panel.
	 * @author Jay Clegg
	 * @param name The name of the resource.
	 * @param quantity The amount the player has.
	 * @param increase The amount gained per year.
	 */
	public void addResource(String name, int quantity, int increase)
	{
		JLabel resource = new JLabel("<html>" + name +":<br>" + quantity, JLabel.CENTER);
		if(increase > 0)
		{
			resource.setToolTipText("Yearly gain: +" + increase);
		}
		else if(increase <0)
		{
			resource.setToolTipText("Yearly gain: " + increase);
		}
		
		resource.setHorizontalTextPosition(JLabel.CENTER);
		this.add(resource);
		update();
	}
	
	/**
	 * Gets the label which contains the text.
	 * @author Jay Clegg
	 * @param name The name of the resource
	 * @return The resource. If the resource is not found will return null.
	 */
	public JLabel getResource(String name)
	{
		for(Component component : this.getComponents())
		{
			JLabel label = (JLabel) component;
			if(label.getText().contains(name))
			{
				return label;
			}
		}
		
		return null;
	}
	
	/**
	 * Removes the label with the text provided.
	 * @param name The text to be searched for.
	 * @author Jay Clegg
	 */
	public void removeResource(String name)
	{
		try
		{
			this.remove(getResource(name));
			update();
		}
		catch(NullPointerException noSuchSettlement)
		{
			
		}
	}
	
	/**
	 * Adjusts a resource according to the supplied details.
	 * @author Jay Clegg
	 * @param name This should not change. It is used to find the resource.
	 * @param quantity The new quantity of the resource.
	 * @param increase The new yearly gain of the resource.
	 */
	public void setResource(String name, int quantity, int increase)
	{
		JLabel resource = getResource(name);
		if(resource != null)
		{
			resource.setText("<html>" + name +":<br>" + quantity);
			if(increase > 0)
			{
				resource.setToolTipText("Yearly gain: +" + increase);
			}
			else if(increase <0)
			{
				resource.setToolTipText("Yearly gain: " + increase);
			}
			update();
		}
	}
}
