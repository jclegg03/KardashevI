package gui.utility;

import java.awt.Toolkit;

import game.controller.Controller;

public class JFrame extends javax.swing.JFrame
{
	private Controller app;
	
	public JFrame(Controller app)
	{
		super("Kardashev I");
		this.app = app;
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setVisible(true);
	}
}
