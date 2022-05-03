package game.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
	 * @param app The game to be saved.
	 */
	public static void saveGame(Controller app)
	{
		try(FileOutputStream saveStream = new FileOutputStream(app.getEmpire().getName() + ".kdsi");
				ObjectOutputStream output = new ObjectOutputStream(saveStream))
		{
			output.writeObject(app);
		}
		catch(IOException saveError)
		{
			
		}
		catch(Exception generalError)
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
		try(FileInputStream loadStream = new FileInputStream(file);
				ObjectInputStream input = new ObjectInputStream(loadStream))
		{
			loaded = (Controller) (input.readObject());
		}
		catch(IOException loadError)
		{
			
		}
		catch(Exception generalError)
		{
			
		}
		return loaded;
	}
	
	public static void saveSettings(Settings settings)
	{
		try(FileOutputStream saveStream = new FileOutputStream("KardashevI.settings");
				ObjectOutputStream output = new ObjectOutputStream(saveStream))
		{
			output.writeObject(settings);
		}
		catch(IOException saveError)
		{
			
		}
		catch(Exception generalError)
		{
			
		}
	}
	
	public static Settings loadSettings()
	{
		Settings loaded = new Settings();
		
		try(FileInputStream loadStream = new FileInputStream("KardashevI.settings");
				ObjectInputStream input = new ObjectInputStream(loadStream))
		{
			loaded = (Settings) input.readObject();
		}
		catch(IOException loadError)
		{
			
		}
		catch(Exception generalError)
		{
			
		}
		
		return loaded;
	}
}
