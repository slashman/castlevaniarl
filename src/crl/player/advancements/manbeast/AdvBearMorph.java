package crl.player.advancements.manbeast;

import crl.player.advancements.FlagAdvancement;

public class AdvBearMorph extends FlagAdvancement{
	public String getName(){
		return "Ursidae Morph";
	}
	
	public String getFlagName() {
		return "SKILL_BEARMORPH";
	}

	public String getID() {
		return "ADV_BEARMORPH";
	}

	public String[] requirements = new String[]{
		"ADV_POWERBLOW"
	};
	
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Turns into a huge werebear";
	}
	
	
}
