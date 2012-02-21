package crl.player.advancements.manbeast;

import crl.player.advancements.FlagAdvancement;

public class AdvPowerBlow2 extends FlagAdvancement{
	public String getName(){
		return "Power Strike";
	}
	
	public String getFlagName() {
		return "SKILL_POWERBLOW2";
	}

	public String getID() {
		return "ADV_POWERBLOW2";
	}

	public String[] requirements = new String[]{
		"ADV_POWERBLOW"
	};
	
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Replaces Power Blow for a stronger Strike";
	}
	
	
}

