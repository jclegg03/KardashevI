package gui.utility;

import java.awt.Toolkit;

import game.controller.Controller;

public class JFrame extends javax.swing.JFrame
{
	protected Controller app;
	
	public JFrame(Controller app)
	{
		super("Kardashev I");
		this.app = app;
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}
}
