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

class FrameTest
{
	private Controller testedController;
	private MainMenu testedFrame;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Controller();
		this.testedFrame = new MainMenu(testedController);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
		this.testedFrame = null;
	}

	@Test
	void testChatFrame()
	{
		assertTrue(testedFrame instanceof JFrame, "ChatFrame needs to extend JFrame");
		Method [] methods = testedFrame.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 1, "You need 1 method in the ChatFrame");
		assertTrue(testedFrame.getTitle().length() > 5, "Your title needs at least 6 letters");
		assertTrue(testedFrame.getTitle().toLowerCase().contains("kardashev i"), "Your title needs to have KardashevI in it");
		assertTrue(testedFrame.getContentPane() instanceof MainContentPane, "Your ChatFrame needs to have a ChatPanel inside");
	}

}
