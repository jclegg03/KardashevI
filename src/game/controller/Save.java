package game.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Save
{
	public void save(Controller empire)
	{
		try(FileOutputStream saveStream = new FileOutputStream("empire.kdsI");
				ObjectOutputStream output = new ObjectOutputStream(saveStream))
		{
			output.writeObject(empire);
		}
		catch(Exception error)
		{
			
		}
	}
	
	public Controller load()
	{
		Controller loaded = new Controller();
		try(FileInputStream loadStream = new FileInputStream("empire.kdsI");
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
