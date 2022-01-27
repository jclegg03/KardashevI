package game.view.maps;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Map extends JPanel
{
	private Tile[][] map;
	
//	private int length;
	private final int rows;
	private final int cols;
//	private Image background;
	
	public Map(int rows, int cols)
	{
		this.rows = rows;
		this.cols = cols;
		this.setLayout(new GridLayout(rows, cols, 0, 0));
		this.map = new Tile[rows][cols];
		
		for(int row = 0; row < map.length; row++)
		{
			for(int col = 0; col < map[row].length; col++)
			{
				Tile tile = new Tile("*");
				map[row][col] = tile;
				this.add(tile);
			}
		}
	}
	
//	@Override
//	protected void paintComponent(Graphics image)
//	{
//		this.paint(image);
//		image.drawImage(background, 0, 0, null);
//	}
	
	public Tile[][] getMap()
	{
		return this.map;
	}
}