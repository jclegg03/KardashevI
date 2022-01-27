package game.model.units;

import java.io.Serializable;

public class Building implements Serializable
{
	static final long serialVersionUID = 4788849693040406408l;
	private String name;
	private Job[] employs;
	private Resource produces;
	private Resource consumes;
	private int size;
	private Building upgradesTo;
	private String description;
}
