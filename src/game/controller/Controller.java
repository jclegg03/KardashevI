package game.controller;

import java.io.Serializable;

import gui.utility.JFrame;

public class Controller implements Serializable
{
	static final long serialVersionUID = 0l;
	private JFrame test;
	
	public Controller()
	{
		this.test = new JFrame(this);
	}
}
