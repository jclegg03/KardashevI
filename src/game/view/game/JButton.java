package game.view.game;

import java.awt.Font;

public class JButton extends javax.swing.JButton
{
	public static final long serialVersionUID = 20902220508983150l;
	
	public JButton(String text)
	{
		this.setFocusPainted(false);
		this.setText(text);
		this.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
	}
	
	@Override
	public void setFocusable(boolean focusable)
	{
		//does nothing so all buttons are still focusable.
	}
}
