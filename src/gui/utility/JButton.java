package gui.utility;

import java.awt.Dimension;

/**
 * Pretty much just a JButton except the focus painted is false by default. (Windows was acting weird)
 * @author Jay Clegg
 *
 */
public class JButton extends javax.swing.JButton
{
	/**
	 * Builds a JButton with text.
	 * @param text The text on the button.
	 * @author Jay Clegg
	 */
	public JButton(String text)
	{
		super(text);
		
		configureButton();
	}
	
	/**
	 * Builds a basic button.
	 * @author Jay Clegg
	 */
	public JButton()
	{
		super();
		
		configureButton();
	}
	
	/**
	 * Any configurations I think the button should have.
	 * @author Jay Clegg
	 */
	private void configureButton()
	{
		this.setFocusPainted(false);
	}
}
