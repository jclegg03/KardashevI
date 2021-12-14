package game.view.game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Toolbar extends JPanel
{
	protected JFrame parent;
	protected JButton research;
	protected JButton leaders;
	protected JButton menu;
	
	public Toolbar(JFrame parent)
	{
		this.parent = parent;
		this.research = new JButton("Research");
		this.leaders = new JButton("Leaders");
		this.menu = new JButton("Menu");

		setupToolbar();
	}
	
	private void setupToolbar()
	{
		setupClickListeners();
		
		this.setLayout(new GridLayout(0, 1, 10, 5));
		this.add(research);
		this.add(leaders);
		this.add(menu);
	}
	
	private void setupClickListeners()
	{
		research.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		leaders.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		menu.setMnemonic(KeyEvent.VK_E);
		menu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				new GameMenuView(parent);
			}
		});
	}
}