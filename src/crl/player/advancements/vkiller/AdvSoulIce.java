package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvSoulIce extends Advancement{
	public String getName(){
		return "Soul Ice";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_SOULICE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_SOULICE";
	}

	public String[] requirements = new String[]{
		"ADV_SOULWIND",
		"ADV_SOULFLAME"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Recovers Health";
	}
}
