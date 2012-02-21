package crl.player.advancements.manbeast;

import crl.player.advancements.FlagAdvancement;

public class AdvBeastMorph extends FlagAdvancement{
	public String getName(){
		return "Bestial Morph";
	}
	
	public String getFlagName() {
		return "SKILL_BEASTMORPH";
	}

	public String getID() {
		return "ADV_BEASTMORPH";
	}

	public String[] requirements = new String[]{
		"ADV_BEARMORPH"
	};
	
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Turns into a huge beast";
	}
	
	
}
