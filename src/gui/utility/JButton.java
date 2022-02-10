package gui.utility;

public class JButton extends javax.swing.JButton
{
	public JButton(String text)
	{
		super(text);
		
		configureButton();
	}
	
	public JButton()
	{
		super();
		
		configureButton();
	}
	
	private void configureButton()
	{
		this.setFocusPainted(false);
	}
}
