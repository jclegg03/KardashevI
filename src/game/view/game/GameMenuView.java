package game.view.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.controller.Controller;

public class GameMenuView
{
	private Controller app;
	private JFrame parent;
	private JDialog view;
	private JPanel buttons;
	private JButton returnToGame;
	private JButton exit;
	private JButton settings;
	private JButton save;
	private JButton load;
	
	public GameMenuView(Controller app, JFrame parent)
	{
		this.app = app;
		this.parent = parent;
		this.view = new JDialog(parent, true);
		this.buttons = new JPanel();
		this.returnToGame = new JButton("Return to game");
		this.exit = new JButton("Exit");
		this.settings = new JButton("Settings");
		this.save = new JButton("Save");
		this.load = new JButton("Load");
		
		setupButtons();
		setupView();
	}
	
	private void setupButtons()
	{
		setupReturn();
		setupExit();
		setupSettings();
		setupSave();
		setupLoad();
		
		buttons.add(returnToGame);
		buttons.add(save);
		buttons.add(load);
		buttons.add(settings);
		buttons.add(exit);
		buttons.setBackground(Color.GRAY);
		buttons.setOpaque(true);
		buttons.setLayout(new GridLayout(5, 1, 10, 5));
	}
	
	private void setupView()
	{
		view.setUndecorated(true);
		view.setAlwaysOnTop(true);
		view.setSize(200, 250);
		view.setBackground(buttons.getBackground());
		view.add(new Padding(view.getBackground()), BorderLayout.NORTH);
		view.add(new Padding(view.getBackground()), BorderLayout.SOUTH);
		view.add(new Padding(view.getBackground()), BorderLayout.EAST);
		view.add(new Padding(view.getBackground()), BorderLayout.WEST);
		view.add(buttons, BorderLayout.CENTER);
		view.setLocationRelativeTo(null);
		view.setVisible(true);
	}
	
	private void setupReturn()
	{
		returnToGame.setFocusPainted(false);
		returnToGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				view.dispose();
			}
		});
	}
	
	private void setupExit()
	{
		exit.setFocusPainted(false);
		exit.setMnemonic(KeyEvent.VK_E);
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				parent.dispose();
			}
		});
	}
	
	private void setupSettings()
	{
		settings.setFocusPainted(false);
		settings.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//settings view
			}
		});
	}
	
	private void setupSave()
	{
		save.setFocusPainted(false);
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//save
			}
		});
	}
	
	private void setupLoad()
	{
		load.setFocusPainted(false);
		load.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//load
			}
		});
	}
}
