package game.view.map;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import game.controller.Controller;
import gui.utility.JButton;

/**
 * The base class for each map level.
 * @author Jay Clegg
 *
 */
public class Map extends JPanel
{
	protected Controller app;
	protected GridLayout layout;
	
	public Map(Controller app, int rows, int cols)
	{
		this.app = app;
		this.layout = new GridLayout(rows, cols, 1, 1);
		this.setLayout(layout);
		
		for(int row = 0; row < rows; row++)
		{
			for(int col = 0; col < cols; col++)
			{
				JButton tile = new JButton();
				tile.setOpaque(true);
				tile.setBackground(Color.BLUE);
				this.add(tile);
			}
		}
		
		this.setBackground(Color.BLACK);
	}
	
	
}
