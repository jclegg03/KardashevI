package game.tests;

/**
 * Testing imports
 */
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Reflection imports
 */
import java.lang.reflect.Method;

import javax.swing.JFrame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import game.controller.Controller;
import game.view.mainMenu.MainContentPane;
import game.view.mainMenu.MainMenu;

/**
 * Tests the frame.
 */
class FrameTest
{
	/**
	 * The controller to generate the test frame.
	 */
	private Controller testedController;
	
	/**
	 * The tested frame.
	 */
	private MainMenu testedFrame;

	/**
	 * Initializes the class variables.
	 * @throws Exception If there is an error.
	 */
	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
		this.testedFrame = new MainMenu(testedController);
	}

	/**
	 * Sets the variables to null after the test.
	 * @throws Exception If there is an error.
	 */
	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
		this.testedFrame = null;
	}

	/**
	 * Tests the frame.
	 * Makes sure it is a JFrame.
	 * Makes sure it has a method.
	 * Makes sure it has the right title.
	 * Makes sure it has the right content pane.
	 */
	@Test
	void testFrame()
	{
		assertTrue(testedFrame instanceof JFrame, "The menu needs to extend JFrame");
		Method [] methods = testedFrame.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 1, "You need 1 method in the menu");
		assertTrue(testedFrame.getTitle().length() > 5, "Your title needs at least 6 letters");
		assertTrue(testedFrame.getTitle().toLowerCase().contains("kardashev i"), "Your title needs to have KardashevI in it");
		assertTrue(testedFrame.getContentPane() instanceof MainContentPane, "Your ChatFrame needs to have a panel inside");
	}

}
