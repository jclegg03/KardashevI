package game.controller;

import java.io.Serializable;

import game.model.resources.lists.CaveAgeTech;
import game.model.units.Resource;

public class Controller implements Serializable
{
	static final long serialVersionUID = 0l;
	private Resource[] empireResources;
//	private Tech[] empireTechnologies;
	
	public Controller()
	{
		this.empireResources = new Resource[5];
		empireResources();
	}
	
	public void start()
	{
		ViewController viewController = new ViewController();
		viewController.displayMainMenu(empireResources);
	}
	
	private void empireResources()
	{
		empireResources[0] = new Resource(5, 10, "sticks");
		empireResources[1] = new Resource(4, 11, "sticks");
		empireResources[2] = new Resource(3, 12, "sticks");
		empireResources[3] = new Resource(2, 13, "sticks");
		empireResources[4] = new Resource(1, -14, "sticks");
	}
}
