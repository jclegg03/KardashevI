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
		map[0][14].setColor(Tile.ICE);
	}
	
	private void row1()
	{
		//Alaska and Canada
		for(int index = 1; index < 11; index++)
		{
			map[1][index].setColor(Tile.ICE);
		}
		
		//More Greenland
		for(int index = 12; index < 16; index++)
		{
			map[1][index].setColor(Tile.ICE);
		}
		
		//Russian Island
		map[1][20].setColor(Tile.ICE);
	}
	
	private void row2()
	{
		//More Alaska and Canada
		for(int index = 2; index < 10; index++)
		{
			map[2][index].setColor(Tile.ICE);
		}
		
		//Ocean and canada and greenland
		map[2][11].setColor(Tile.ICE);
		map[2][13].setColor(Tile.ICE);
		map[2][14].setColor(Tile.ICE);
		
		//part of north Europe
		for(int index = 21; index < 26; index++)
		{
			map[2][index].setColor(Tile.FERTILE);
		}
		
		//top of russia
		for(int index = 27; index < 48; index++)
		{
			map[2][index].setColor(Tile.ICE);
		}
	}
	
	private void row3()
	{
		//Alaska island
		map[3][0].setColor(Tile.ICE);
		
		//More canada
		for(int index = 4; index < 9; index++)
		{
			map[3][index].setColor(Tile.ICE);
		}
		map[3][13].setColor(Tile.ICE);
		
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
			map[3][index].setColor(Tile.ICE);
		}
	}
}
