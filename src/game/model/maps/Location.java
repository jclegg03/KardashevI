package game.model.maps;

/**
 * A location on an empire map. Used as a key to find the associated lower level map.
 * @author Jay Clegg
 *
 */
public class Location
{
	private int row;
	private int col;
	
	/**
	 * Builds a location key.
	 * @author Jay Clegg
	 * @param row The row of the key.
	 * @param col The column of the key.
	 */
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
