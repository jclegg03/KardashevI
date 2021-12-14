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
		
		map[2][16].setColor(Tile.ICE);
	}
}
