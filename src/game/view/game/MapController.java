package game.view.game;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapController extends JPanel
{
	static final long serialVersionUID = -1_5071216l;
	private JLabel mapLevel;
	private JButton mapChanger;
	
	public MapController(String mapLevel)
	{
		this.mapLevel = new JLabel(mapLevel);
		this.mapChanger = new JButton("");
		
		setupLabels();
		setupThis();
	}
	
	private void setupLabels()
	{
		mapChanger.setLayout(null);
		mapChanger.setIcon(new ImageIcon("C:/Users/unlim/eclipse-workspace/KardashevI/src/game/view/game/betterMap.png"));
		mapChanger.setMargin(new Insets(0, 0, 0, 0));
		
		mapLevel.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
	}
	
	private void setupThis()
	{
		this.add(mapLevel);
		this.add(mapChanger);
	}
}