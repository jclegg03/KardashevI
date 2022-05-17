package game.view.loadDialog;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import game.controller.Controller;
import gui.utility.JButton;
import gui.utility.MainPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Holds the components of the loading screen.
 * @author Jay Clegg
 *
 */
public class LoadPanel extends MainPanel
{
	/**
	 * The controller this reports to.
	 * @author Jay Clegg
	 */
	private Controller app;
	
	/**
	 * The panel to hold all the buttons.
	 * @author Jay Clegg
	 */
	private JPanel buttonPanel;
	
	/**
	 * All the buttons to be added to the button panel.
	 * @author Jay Clegg
	 */
	private JButton[] buttons;
	
	/**
	 * Cancels loading and gets rid of the dialog.
	 * @author Jay Clegg
	 */
	private JButton cancelButton;
	
	/**
	 * The title of this panel.
	 * @author Jay Clegg
	 */
	private JLabel label;
	
	/**
	 * The layout for this panel.
	 * @author Jay Clegg
	 */
	private SpringLayout layout;
	
	/**
	 * The dialog which contains this.
	 * @author Jay Clegg
	 */
	private LoadDialog parent;
	
	/**
	 * The name of the save games.
	 * @author Jay Clegg
	 */
	private String[] saves;
	
	/**
	 * The scroll pane to hold the button panel in case of overflow.
	 * @author Jay Clegg
	 */
	private JScrollPane scrollPane;
	
	public LoadPanel(Controller app, String[] saves, LoadDialog parent)
	{
		super();
		this.app = app;
		this.saves = saves;
		this.scrollPane = new JScrollPane();
		this.buttonPanel = new JPanel();
		this.buttons = new JButton[saves.length];
		this.cancelButton = new JButton("Cancel");
		this.label = new JLabel("Saved Games");
		this.layout = new SpringLayout();
		this.parent = parent;
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Cancels loading and disposes of the dialog.
	 * @author Jay Clegg
	 */
	private void cancel()
	{
		parent.dispose();
		app.returnFocus();
	}

	/**
	 * Tells the controller which save file to use based on the button clicked.
	 * @author Jay Clegg
	 * @param button The button which was pressed.
	 */
	private void loadGame(JButton button)
	{
		app.setSaveIndex(Integer.parseInt(button.getName()));
		parent.dispose();
	}

	private void setupButtons()
	{
		for(int index = 0; index < buttons.length; index++)
		{
			JButton button = new JButton(saves[index].substring(0, saves[index].lastIndexOf(".kdsi")));
			buttons[index] = button;
			button.setName(index + "");
		}
	}

	@Override
	protected void setupLayout()
	{
		buttonPanel.setLayout(new GridLayout(0, 1, 0, 3));
		this.setLayout(layout);
		layout.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, label, 20, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, this);
		
		layout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.SOUTH, label);
		layout.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, cancelButton);
		
		layout.putConstraint(SpringLayout.SOUTH, scrollPane, -10, SpringLayout.NORTH, cancelButton);
		layout.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, cancelButton);
		layout.putConstraint(SpringLayout.NORTH, cancelButton, -30, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, cancelButton, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, cancelButton, -10, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, cancelButton, -10, SpringLayout.EAST, this);
	}
	
	@Override
	protected void setupListeners()
	{
		for(JButton button : buttons)
		{
			button.addActionListener(click -> loadGame(button));
		}
		
		cancelButton.addActionListener(click -> cancel());
	}
	
	@Override
	protected void setupPanel()
	{
		setupButtons();
		
		for(JButton button : buttons)
		{
			buttonPanel.add(button);
		}
		
		scrollPane.setViewportView(buttonPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);

		this.add(label);
		this.add(scrollPane);
		this.add(cancelButton);
	}
}
