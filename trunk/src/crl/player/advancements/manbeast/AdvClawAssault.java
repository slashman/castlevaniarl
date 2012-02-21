package crl.player.advancements.manbeast;

import crl.player.advancements.FlagAdvancement;

public class AdvClawAssault extends FlagAdvancement{
	public String getName(){
		return "Claw Assault";
	}
	
	public String getFlagName() {
		return "SKILL_CLAWASSAULT";
	}

	public String getID() {
		return "ADV_CLAWASSAULT";
	}

	public String[] requirements = new String[]{
		"ADV_ENERGYSCHYTE"
	};
	
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Slashes through enemies";
	}
	
	
}

