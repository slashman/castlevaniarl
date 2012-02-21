package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvSoulFlame extends Advancement{
	public String getName(){
		return "Soul Flame";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_SOULFLAME", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_SOULFLAME";
	}

	public String[] requirements = new String[]{
		"ADV_ITEMBREAK"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Burns monsters around you";
	}
}
