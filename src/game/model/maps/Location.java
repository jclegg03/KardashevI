package game.model.maps;

public class Location
{
	private int row;
	private int col;
	
	public Location(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	
	public int getRow()
	{
		return row;
	}

	public int getCol()
	{
		return col;
	}

	@Override
	public boolean equals(Object thing)
	{
		try
		{
			Location other = (Location) thing;
			if(this.getRow() == other.getRow() && this.getCol() == other.getCol())
			{
				return true;
			}
			else return false;
		}
		catch(Exception error)
		{
			return false;
		}
	}
}
