package game.view.maps;

public class WorldMap extends Map
{
	private Tile[][] map;
	
	public WorldMap()
	{
		super(25, 50);
		this.map = super.getMap();
		
		ocean();
		row0();
		row1();
		row2();
		row3();
		row4();
		row5();
		row6();
		test();
	}
	
	private void test()
	{
		for(Tile[] row : map)
		{
			for(Tile tile : row)
			{
				tile.setExplored(true);
				tile.updateExplored();
			}
		}
	}
	
	private void ocean()
	{
		for(Tile[] row : map)
		{
			for(Tile tile : row)
			{
				tile.setColor(Tile.OCEAN);
			}
		}
	}
	
	private void row0()
	{
		//tip of Greenland
		map[0][14].setColor(Tile.COLD);
	}
	
	private void row1()
	{
		//Alaska and Canada
		for(int index = 1; index < 11; index++)
		{
			map[1][index].setColor(Tile.COLD);
		}
		
		//More Greenland
		for(int index = 12; index < 16; index++)
		{
			map[1][index].setColor(Tile.COLD);
		}
		
		//Russian Island
		map[1][20].setColor(Tile.COLD);
	}
	
	private void row2()
	{
		//More Alaska and Canada
		for(int index = 2; index < 10; index++)
		{
			map[2][index].setColor(Tile.COLD);
		}
		
		//Ocean and canada and greenland
		map[2][11].setColor(Tile.COLD);
		map[2][13].setColor(Tile.COLD);
		map[2][14].setColor(Tile.COLD);
		
		//part of north Europe
		for(int index = 21; index < 26; index++)
		{
			map[2][index].setColor(Tile.FERTILE);
		}
		
		//top of russia
		for(int index = 27; index < 48; index++)
		{
			map[2][index].setColor(Tile.COLD);
		}
	}
	
	private void row3()
	{
		//Alaska island
		map[3][0].setColor(Tile.COLD);
		
		//More canada
		for(int index = 4; index < 9; index++)
		{
			map[3][index].setColor(Tile.COLD);
		}
		map[3][13].setColor(Tile.COLD);
		
		//Iceland
		map[3][16].setColor(Tile.FERTILE);
		
		//more europe
		for(int index = 20; index < 24; index++)
		{
			map[3][index].setColor(Tile.FERTILE);
		}
		map[3][24].setColor(Tile.SHORE);
		
		//back to russia
		for(int index = 25; index < 41; index++)
		{
			map[3][index].setColor(Tile.FERTILE);
		}
		for(int index = 41; index < 50; index++)
		{
			map[3][index].setColor(Tile.COLD);
		}
	}
	
	private void row4()
	{
		//canada
		for(int index = 5; index < 7; index++)
		{
			map[4][index].setColor(Tile.COLD);
		}
		map[4][7].setColor(Tile.FERTILE);
		map[4][8].setColor(Tile.DESERT);
		map[4][9].setColor(Tile.FERTILE);
		map[4][10].setColor(Tile.FERTILE);
		map[4][11].setColor(Tile.COLD);
		
		//europe
		for(int index = 18; index < 45; index++)
		{
			map[4][index].setColor(Tile.FERTILE);
		}
		map[4][47].setColor(Tile.FERTILE);
	}
	
	private void row5()
	{
		//USA
		for(int index = 4; index < 8; index++)
		{
			map[5][index].setColor(Tile.DESERT);
		}
		map[5][8].setColor(Tile.FERTILE);
		map[5][9].setColor(Tile.FERTILE);
		map[5][10].setColor(Tile.SHORE);
		map[5][11].setColor(Tile.FERTILE);
		map[5][12].setColor(Tile.FERTILE);
		map[5][13].setColor(Tile.FERTILE);
		
		//Europe
		for(int index = 19; index < 26; index++)
		{
			map[5][index].setColor(Tile.FERTILE);
		}
		map[5][26].setColor(Tile.DESERT);
		for(int index = 27; index < 46; index++)
		{
			map[5][index].setColor(Tile.FERTILE);
		}
	}
	
	private void row6()
	{
		
	}
}
