package game.view.newGameDialog;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import game.controller.Controller;
import gui.utility.JButton;
import gui.utility.MainPanel;

public class NewContentPane extends MainPanel
{
	private Controller app;
	private NewGameDialog frame;
	private SpringLayout layout;
	private JTextField textField;
	private JPanel buttonPanel;
	private JButton cancelButton;
	private JButton confirmButton;
	
	public NewContentPane(Controller app, NewGameDialog frame)
	{
		super();
		this.app = app;
		this.frame = frame;
		this.layout = new SpringLayout();
		this.textField = new JTextField("Empire Name");
		this.buttonPanel = new JPanel();
		this.cancelButton = new JButton("Cancel");
		this.confirmButton = new JButton("Confirm");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	protected void setupPanel()
	{
		setupButtonPanel();
		this.add(textField);
		this.add(buttonPanel);
		this.setFocusable(true);
		textField.setFocusable(true);
	}
	
	private void setupButtonPanel()
	{
		buttonPanel.setLayout(new GridLayout(1, 0, 20, 0));
		buttonPanel.add(cancelButton);
		buttonPanel.add(confirmButton);
		
		cancelButton.setToolTipText("Cancel empire creation");
		confirmButton.setToolTipText("Create your empire named \"" + textField.getText() + "\"");
	}
	
	protected void setupLayout()
	{
		this.setLayout(layout);
		layout.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, textField, -100, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 10, SpringLayout.SOUTH, textField);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, buttonPanel, -10, SpringLayout.EAST, this);
	}
	
	protected void setupListeners()
	{
		this.addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent key)
			{
				if(key.getKeyChar() == KeyEvent.VK_ESCAPE)
				{
					cancelButton.doClick();
					return;
				}
				else if(key.getKeyChar() == KeyEvent.VK_ENTER)
				{
					confirmButton.doClick();
					return;
				}
				else
				{
					if(textField.getText().equals("Empire Name"))
					{
						if(key.getKeyChar() == KeyEvent.VK_DELETE || key.getKeyChar() == KeyEvent.VK_BACK_SPACE)
						{
							textField.setText("");
							confirmButton.setToolTipText("Create your empire named \"" + textField.getText() + "\"");
						}
						else
						{
							textField.setText(Character.toString(key.getKeyChar()));
							confirmButton.setToolTipText("Create your empire named \"" + textField.getText() + key.getKeyChar() + "\"");
						}
					}
					else
					{
						if(key.getKeyChar() != KeyEvent.VK_BACK_SPACE && key.getKeyChar() != KeyEvent.VK_DELETE)
						{
							textField.setText(textField.getText() + Character.toString(key.getKeyChar()));
							confirmButton.setToolTipText("Create your empire named \"" + textField.getText() + key.getKeyChar() + "\"");
						}
						else if(key.getKeyChar() == KeyEvent.VK_BACK_SPACE)
						{
							if(textField.getText().length() != 0)
							{
								textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
								confirmButton.setToolTipText("Create your empire named \"" + textField.getText() + "\"");
							}
						}
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent key)
			{
			}

			@Override
			public void keyReleased(KeyEvent key)
			{
			}
			
		});
		
		textField.addMouseListener(new MouseListener() 
		{

			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				
			}

			@Override
			public void mouseEntered(MouseEvent e) 
			{
				if(textField.getText().equals("Empire Name"))
				{
					textField.setText("");
				}
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				if(textField.getText().equals("") && ! textField.hasFocus())
				{
					textField.setText("Empire Name");
				}
			}
			
		});
		
		textField.addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent key)
			{
				if(key.getKeyChar() == KeyEvent.VK_ENTER)
				{
					confirmButton.doClick();
					return;
				}
				else if(key.getKeyChar() == KeyEvent.VK_ESCAPE)
				{
					cancelButton.doClick();
				}
				else
				{
					if(key.getKeyChar() != KeyEvent.VK_DELETE && key.getKeyChar() != KeyEvent.VK_BACK_SPACE)
					{
						confirmButton.setToolTipText("Create your empire named \"" + textField.getText() + key.getKeyChar() + "\"");
					}
					else
					{
						if(textField.getText().length() != 0)
						{
							confirmButton.setToolTipText("Create your empire named \"" + textField.getText() + "\"");
						}
					}
				}
			}

			@Override
			public void keyPressed(KeyEvent e)
			{
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
			}
			
		});
		
		cancelButton.addActionListener(click -> frame.dispose());
		confirmButton.addActionListener(click -> app.createEmpire(textField.getText(), frame));
	}
}
