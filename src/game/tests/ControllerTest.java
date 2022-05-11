package game.tests;

/**
 * Testing imports
 */
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Reflection imports
 */
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.controller.Controller;

class ControllerTest
{
	private Controller testedController;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
	}

	@Test
	void testController()
	{
		Method [] methods = testedController.getClass().getDeclaredMethods();
		boolean hasSave = false;
		boolean hasLoad = false;
		assertTrue(methods.length >= 2, "You need at least two methods in the controller");
		
		for (Method method : methods)
		{
			if(method.getName().equals("save")) hasSave = true;
			else if(method.getName().toLowerCase().contains("load")) hasLoad = true;
		}
		
		assertTrue(hasSave, "You need a save method.");
		assertTrue(hasLoad, "You need a load method.");
		
		testedController.loadGame();
		
		assertTrue(testedController.getEmpire() != null, "The load method must set the empire variable.");
	}

}
