package game.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The class for saving and loading data.
 * @author Jay Clegg
 *
 */
public class IOController
{
	/**
	 * The method to save a game.
	 * @author Jay Clegg
	 * @param empire The game to be saved.
	 */
	public static void saveGame(Controller empire)
	{
		try(FileOutputStream saveStream = new FileOutputStream("empire.kdsi");
				ObjectOutputStream output = new ObjectOutputStream(saveStream))
		{
			output.writeObject(empire);
		}
		catch(Exception error)
		{
			
		}
	}
	
	/**
	 * The method to load a game.
	 * @author Jay Clegg
	 * @param file The file where the save data is stored.
	 * @return The saved empire.
	 */
	public static Controller loadGame(String file)
	{
		Controller loaded = new Controller();
		try(FileInputStream loadStream = new FileInputStream("empire.kdsi");
				ObjectInputStream input = new ObjectInputStream(loadStream))
		{
			loaded = (Controller) (input.readObject());
		}
		catch(Exception error)
		{
			
		}
		return loaded;
	}
}
