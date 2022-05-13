package game.model.lists;

import game.model.resources.Tech;

/**
 * A list of technologies a cave age empire can research.
 * @author Jay Clegg
 *
 */
public class CaveAgeTech extends TechList
{
	/**
	 * Builds the list of techs an empire can have.
	 * @author Jay Clegg
	 */
	public CaveAgeTech()
	{
		super();
		Tech sticks = new Tech("Sticks", 5);
		ageTechs.add(sticks);
		
		Tech stones = new Tech("Stones", 10);
		ageTechs.add(stones);
		
		setupRequirements(2);
		requirements[0] = sticks;
		requirements[1] = stones;
		Tech fire = new Tech("Fire", 5, copyRequirements());
		
		Tech thought = new Tech("Thought", 15);
		ageTechs.add(thought);
		
		setupRequirements(1);
		requirements[0] = thought;
		Tech improvedShelter = new Tech("Improved Shelters", 10, copyRequirements());
		ageTechs.add(improvedShelter);
		
		Tech tracking = new Tech("Tracking", 20, copyRequirements());
		ageTechs.add(tracking);
		
		setupRequirements(2);
		requirements[0] = tracking;
		requirements[1] = improvedShelter;
		Tech reasoning = new Tech("Reasoning", 20, copyRequirements());
		ageTechs.add(reasoning);
		
		setupRequirements(1);
		requirements[0] = reasoning;
		Tech effenciency = new Tech("Effenciey", 20, copyRequirements());
		ageTechs.add(effenciency);
		
		requirements[0] = effenciency;
		Tech bones = new Tech("Bones", 20, copyRequirements());
		ageTechs.add(bones);
		
		Tech skins = new Tech("Hides", 20, copyRequirements());
		ageTechs.add(skins);
		
		requirements[0] = bones;
		Tech tools = new Tech("Basic Tools", 30, copyRequirements());
		ageTechs.add(tools);
		
		requirements[0] = skins;
		Tech teepees = new Tech("Teepees", 20, copyRequirements());
		ageTechs.add(teepees);
		
		requirements[0] = tools;
		Tech axes = new Tech("Axes", 40, copyRequirements());
		ageTechs.add(axes);
		
		Tech swords = new Tech("Swords", 40, copyRequirements());
		ageTechs.add(swords);
		
		sticks.setDescription("Sticks are for when your hands aren't strong enough."
				+ "\nUnlocks the Sticks resource.");
		
		stones.setDescription("Stronger than sticks, these are used for tougher tasks. They can also start fires."
				+ "\nUnlocks the Stones resource.");
		
		fire.setDescription("");
		thought.setDescription("");
		improvedShelter.setDescription("");
		tracking.setDescription("");
		reasoning.setDescription("");
		effenciency.setDescription("");
		bones.setDescription("");
		skins.setDescription("");
		tools.setDescription("");
		teepees.setDescription("");
		axes.setDescription("");
		swords.setDescription("");
	}
}
