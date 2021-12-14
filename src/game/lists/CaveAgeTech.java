package game.lists;

import game.units.Tech;

public class CaveAgeTech extends TechList
{
	private Tech sticks;
	private Tech stones;
	private Tech fire;
	private Tech thought;
	private Tech improvedShelter;
	private Tech tracking;
	private Tech reasoning;
	private Tech effenciency;
	private Tech bones;
	private Tech skins;
	private Tech tools;
	private Tech teepees;
	private Tech axes;
	private Tech swords;
	
	public CaveAgeTech()
	{
		sticks = new Tech("Sticks", 5);
		ageTech.add(sticks);
		
		stones = new Tech("Stones", 10);
		ageTech.add(stones);
		
		req(2);
		req[0] = sticks;
		req[1] = stones;
		fire = new Tech("Fire", 5, copy());
		
		thought = new Tech("Thought", 15);
		ageTech.add(thought);
		
		req(1);
		req[0] = thought;
		improvedShelter = new Tech("Improved Shelters", 10, copy());
		ageTech.add(improvedShelter);
		
		tracking = new Tech("Tracking", 20, copy());
		ageTech.add(tracking);
		
		req(2);
		req[0] = tracking;
		req[1] = improvedShelter;
		reasoning = new Tech("Reasoning", 20, copy());
		ageTech.add(reasoning);
		
		req(1);
		req[0] = reasoning;
		effenciency = new Tech("Effenciey", 20, copy());
		ageTech.add(effenciency);
		
		req[0] = effenciency;
		bones = new Tech("Bones", 20, copy());
		ageTech.add(bones);
		
		skins = new Tech("Hides", 20, copy());
		ageTech.add(skins);
		
		req[0] = bones;
		tools = new Tech("Basic Tools", 30, copy());
		ageTech.add(tools);
		
		req[0] = skins;
		teepees = new Tech("Teepees", 20, copy());
		ageTech.add(teepees);
		
		req[0] = tools;
		axes = new Tech("Axes", 40, copy());
		ageTech.add(axes);
		
		swords = new Tech("Swords", 40, copy());
		ageTech.add(swords);
		
		addDescriptions();
	}

	
	private void addDescriptions()
	{
		sticks.setDescription("Sticks are for when your hands aren't strong enough."
				+ "\nUnlocks the Sticks resource.");
		
		stones.setDescription("Stronger than sticks, these are used for tougher tasks. They can also start fires."
				+ "\nUnlocks the Stonesresource.");
		
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
