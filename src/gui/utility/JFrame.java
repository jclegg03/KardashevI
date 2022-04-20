package gui.utility;

import java.awt.Toolkit;

import game.controller.Controller;

/**
 * The base class for JFrames used in this project.
 * @author Jay Clegg
 *
 */
public abstract class JFrame extends javax.swing.JFrame
{
	protected Controller app;
	
	/**
	 * Builds the JFrame.
	 * @param app The controller the frame reports to.
	 */
	public JFrame(Controller app)
	{
		super("Kardashev I");
		this.app = app;
		
		setupFrame();
	}
	
	/**
	 * Sets the visible and back end of the frame up.
	 * @author Jay Clegg
	 */
	private void setupFrame()
	{
//		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}
}
