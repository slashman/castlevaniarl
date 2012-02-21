package crl.player.advancements.vanquisher;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvLight extends Advancement{
	public String getName(){
		return "DarkLight";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_LIGHT", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_LIGHT";
	}

	public String[] requirements = new String[]{
		"ADV_TELEPORT",
		"ADV_CURE",
	};
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Covers weapons in a blue aura";
	}
}
