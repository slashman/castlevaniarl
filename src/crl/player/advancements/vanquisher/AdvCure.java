package crl.player.advancements.vanquisher;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvCure extends Advancement{
	public String getName(){
		return "Cure";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_CURE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_CURE";
	}

	public String[] requirements = new String[]{
		"ADV_RECOVER"
	};
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Removes Poison";
	}
}
