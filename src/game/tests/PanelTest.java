package game.tests;


/**
 * Testing imports
 */
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Component;
/**
 * Reflection imports
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.controller.Controller;
import game.view.mainMenu.MainContentPane;
import game.view.mainMenu.MainMenu;

/**
 * Tests the panel.
 */
class PanelTest
{
	/**
	 * The controller used to make the test panel.
	 */
	private Controller testedController;
	
	/**
	 * The panel to be tested.
	 */
	private MainContentPane testedPanel;

	/**
	 * Initializes the class variables.
	 * @throws Exception If there is an error.
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
		this.testedPanel = new MainContentPane(testedController, new MainMenu(testedController));
	}
	
	/**
	 * Sets the variables to null after the test.
	 * @throws Exception If there is an error.
	 */
	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
		this.testedPanel = null;
	}

	/**
	 * Tests the methods in the panel.
	 * Makes sure there are at least 4 methods.
	 * Makes sure all methods are protected.
	 * Makes sure there is a setupPanel, setupLayout, and setupListeners methods.
	 */
	@Test
	void testPanelMethods()
	{
		Method [] methods = testedPanel.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 4, "You need at least 4 methods in the controller");
		boolean hasSetupPanel = false;
		boolean hasSetupListeners = false;
		boolean hasSetupLayout = false;
		
		for (Method method : methods)
		{
			if (method.getName().equals("setupPanel"))
			{
				hasSetupPanel = true;
				assertTrue(Modifier.isProtected(method.getModifiers()), "The setupPanel method must be protected");
			}
			else if (method.getName().equals("setupListeners"))
			{
				hasSetupListeners = true;
				assertTrue(Modifier.isProtected(method.getModifiers()), "The setupListeners method must be protected");
			}
			else if (method.getName().equals("setupLayout"))
			{
				hasSetupLayout = true;
				assertTrue(Modifier.isProtected(method.getModifiers()), "The setupLayout method must be protected");
			}
		}
		assertTrue(hasSetupPanel, "You need a method named setupPanel");
		assertTrue(hasSetupListeners, "You need a method named setupListeners");
		assertTrue(hasSetupLayout, "You need a method named setupLayout");
	}

}
