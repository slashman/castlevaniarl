package crl.player.advancements.manbeast;

import crl.player.advancements.FlagAdvancement;

public class AdvDemonMorph extends FlagAdvancement{
	public String getName(){
		return "Demonic Morph";
	}
	
	public String getFlagName() {
		return "SKILL_DEMONMORPH";
	}

	public String getID() {
		return "ADV_DEMONMORPH";
	}

	public String[] requirements = new String[]{
		"ADV_BEASTMORPH"
	};
	
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Turns into a strong demon";
	}
	
	
}
