package game.units;

import java.io.Serializable;

public class Pop implements Serializable
{
	static final long serialVersionUID = 5271408l;
	private String name;
	private int number;
	private int[] modifierValues;
	private String[] modifierNames;
}
