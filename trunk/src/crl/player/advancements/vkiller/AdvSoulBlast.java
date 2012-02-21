package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvSoulBlast extends Advancement{
	public String getName(){
		return "Soul Blast";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_SOULBLAST", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_SOULBLAST";
	}

	public String[] requirements = new String[]{
		"ADV_SOULICE",
		"ADV_SOULSAINT"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Invokes a deadly blast of holy energy";
	}
}
