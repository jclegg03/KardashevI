package game.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class IOController
{
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
	
	public static Controller loadGame(String empire)
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
