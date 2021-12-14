package game.view.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import game.view.game.JButton;

public class MainMenuView 
{
	JFrame view;
	JPanel menu;
	JButton newGame;
	JButton loadGame;
	JButton exit;
	JButton[] menuButtons;
	ImageIcon icon;
	JPanel center;
	
	
	
	public MainMenuView()
	{
		this.view = new JFrame("Kardashev I");
		this.menu = new JPanel();
		this.newGame = new JButton("New Game");
		this.loadGame = new JButton("Load Game");
		this.exit = new JButton("Exit");
		menuButtons = new JButton[3];
		menuButtons[0] = newGame;
		menuButtons[1] = loadGame;
		menuButtons[2] = exit;
		icon = new ImageIcon("C:/Users/unlim/eclipse-workspace/KardashevI/src/game/view/game icon.png");
		setupBG();
		setupMenu();
		setupFrame();
	}
	
	private void setupFrame()
	{
		view.setExtendedState(JFrame.MAXIMIZED_BOTH);
		view.setLocationRelativeTo(null);
		view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		view.setIconImage(icon.getImage());
		view.setAlwaysOnTop(true);
		view.setUndecorated(true);
		view.setVisible(true);
	}
	
	private void setupMenu()
	{
		setupButtons();
		menu.setBackground(Color.BLACK);
		view.add(menu, BorderLayout.SOUTH);
	}
	
	private void setupButtons()
	{
		for(int index = 0; index < menuButtons.length; index++)
		{
			menuButtons[index].setBorderPainted(false);
			menuButtons[index].setHorizontalTextPosition(SwingConstants.LEADING);
			menuButtons[index].setForeground(Color.MAGENTA);
			menuButtons[index].setBackground(Color.BLACK);
			menuButtons[index].setFocusable(false);
			menu.add(menuButtons[index]);
		}
		
		newGame.setMnemonic(KeyEvent.VK_N);
		loadGame.setMnemonic(KeyEvent.VK_L);
		exit.setMnemonic(KeyEvent.VK_E);
		setupNewGame();
		setupLoadGame();
		setupExit();
	}
	
	private void setupBG()
	{
		center = new JPanel();
		JLabel BG = new JLabel(new ImageIcon("C:/Users/unlim/eclipse-workspace/KardashevI/src/game/view/background.png"));
		BG.setSize(1000,100);
		center.add(BG);
		center.setBackground(Color.BLACK);
		view.add(center, BorderLayout.CENTER);
	}
	
	private void setupNewGame()
	{
		newGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				newGame();
			}
		});
	}
	
	private void setupLoadGame()
	{
		loadGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				loadGame();
			}
		});
	}
	
	private void setupExit()
	{
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				exitGame();
			}
		});
	}
	
	private void newGame()
	{
		
	}
	
	private void loadGame()
	{
		
	}
	
	private void exitGame()
	{
		new ExitDialog(view);
	}
}
