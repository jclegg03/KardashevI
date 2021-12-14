package game.view.game;

import java.awt.Color;

import javax.swing.JLabel;

public class Padding extends JLabel
{
	public static final long serialVersionUID = 22625081946107495l;
	
	public Padding(Color background)
	{
		this.setBackground(background);
		this.setOpaque(true);
		this.setText("he");
		this.setForeground(background);
		this.setVisible(true);
	}
}
