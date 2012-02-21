package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvSoulSaint extends Advancement{
	public String getName(){
		return "Soul Saint";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_SOULSAINT", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_SOULSAINT";
	}

	public String[] requirements = new String[]{
		"ADV_SOULWIND",
		"ADV_SOULFLAME"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Projects energy from the mystic whip";
	}
}
