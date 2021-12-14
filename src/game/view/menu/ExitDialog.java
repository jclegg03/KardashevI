package game.view.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.view.game.JButton;

public class ExitDialog
{
	private JDialog confirm;
	private JButton yes;
	private JButton no;
	private JPanel buttons;
	private JLabel text;
	private JFrame parent;
	
	public ExitDialog(JFrame parent)
	{
		this.confirm = new JDialog(parent, true);
		this.yes = new JButton("Yes");
		this.no = new JButton("No");
		this.buttons = new JPanel();
		this.text = new JLabel("Are you sure you want to exit the game?");
		this.parent = parent;
		
		setupButtons();
		setupText();
		setupDialog();
	}
	
	private void setupButtons()
	{
		setupYes();
		setupNo();
		buttons.setSize(500, 100);
		buttons.add(yes);
		buttons.add(no);
		buttons.setBackground(Color.GRAY);
	}
	
	private void setupText()
	{
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setVerticalAlignment(SwingConstants.CENTER);
		text.setOpaque(true);
		text.setBackground(Color.GRAY);
		text.setForeground(Color.MAGENTA);
	}
	
	private void setupDialog()
	{
		confirm.setDefaultCloseOperation(parent.getDefaultCloseOperation());
		confirm.setSize(500, 250);
		confirm.setLocationRelativeTo(null);
		confirm.setUndecorated(true);
		confirm.setBackground(Color.GRAY);
		confirm.add(buttons, BorderLayout.SOUTH);
		confirm.add(text);
		confirm.setVisible(true);
	}
	
	private void setupYes()
	{
		yes.setBackground(Color.GRAY);
		yes.setForeground(Color.MAGENTA);
		yes.setFocusable(false);
		yes.setMnemonic(KeyEvent.VK_Y);
		yes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				yes();
			}
		});
	}
	
	private void setupNo()
	{
		no.setBackground(Color.GRAY);
		no.setForeground(Color.MAGENTA);
		no.setFocusable(false);
		no.setMnemonic(KeyEvent.VK_N);
		no.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				no();
			}
		});
	}
	
	private void yes()
	{
		parent.dispose();
	}
	
	private void no()
	{
		confirm.dispose();
	}
}
