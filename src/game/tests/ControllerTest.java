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
	void testRefactor()
	{
		Method [] methods = testedController.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 2, "You need at least two methods in the controller");
		boolean hasSingleParameter = false;
		boolean hasDoubleParameter = false;
		
		for (Method method : methods)
		{
			if (method.getName().equals("interactWithChatbot"))
			{
				if (method.getParameterCount() == 1)
				{
					Type[] types = method.getGenericParameterTypes();
					assertTrue(types[0].getTypeName().equals("java.lang.String"), "The parameter type needs to be: String");
					hasSingleParameter = true;
				}
				else if (method.getParameterCount() == 2)
				{
					hasDoubleParameter = true;
				}
			}
		}

		assertTrue(hasSingleParameter, "You need a single parameter method named interactWithChatbot");
		assertTrue(hasDoubleParameter, "You need a double parameter method named interactWithChatbot");
	}

}
