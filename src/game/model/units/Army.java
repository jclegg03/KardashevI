package game.model.units;

import java.io.Serializable;

/**
 * The structure for armies.
 * @author Jay Clegg on 11/17/2021
 *
 */
public class Army implements Serializable
{
	static final long serialVersionUID = 281092651274l;
	private String type;
	private String name;
	private Tech requirement;
	private int health;
	private int morale;
	private int damage;
	private int buildTime;
	
	/**
	 * Builds an army.
	 * @param type The type of army.
	 * @param name The name of the army.
	 * @param requirement The tech requirement to build the army.
	 * @param health The health of the army.
	 * @param morale The morale of the army.
	 * @param damage The damage the army does.
	 * @param buildtime The time the army takes to build.
	 */
	public Army(String type, String name, Tech requirement, int health, int morale, int damage, int buildTime)
	{
		this.type = type;
		this.name = name;
		this.requirement = requirement;
		this.health = health;
		this.morale = morale;
		this.damage = damage;
		this.buildTime = buildTime;
	}
	
	/**
	 * Gives the type of the army.
	 * @return The type of army.
	 */
	public String getType()
	{
		return this.type;
	}
	
	/**
	 * Gives the name of the army.
	 * @return The name of the army.
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Gives the tech requirement of an army.
	 * @return The tech requirement of the army.
	 */
	public Tech getRequirement()
	{
		return this.requirement;
	}
	
	/**
	 * Gives the health of the army.
	 * @return The health of the army.
	 */
	public int getHealth()
	{
		return this.health;
	}
	
	/**
	 * Gives the morale of an army.
	 * @return The morale of the army.
	 */
	public int getMorale()
	{
		return this.morale;
	}
	
	/**
	 * Gives the damage of an army.
	 * @return The damage of the army.
	 */
	public int getDamage()
	{
		return this.damage;
	}
	
	/**
	 * Changes the name of an army.
	 * @param name The new name for the army.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Updates the health of the army.
	 * @param health The new health value.
	 */
	public void setHealth(int health)
	{
		this.health = health;
	}
	
	/**
	 * Updates the morale of the army.
	 * @param morale The new morale value.
	 */
	public void setMorale(int morale)
	{
		this.morale = morale;
	}
	
	/**
	 * Updates the damage of the army.
	 * @param damage The new damage value.
	 */
	public void setDamage(int damage)
	{
		this.damage = damage;
	}
	
	//doucmentation by Oracle
	@Override
	public String toString()
	{
		String details = "";
		
		details += this.getName();
		details += " is a " + this.getType() + "\n";
		details += "It has " + this.getHealth() + " health, " 
				+ this.getMorale() + " morale, and does "
				+ this.getDamage() + "damage.";
		
		return details;
	}
}
