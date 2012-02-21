package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvSoulWind extends Advancement{
	public String getName(){
		return "Soul Wind";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_SOULWIND", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_SOULWIND";
	}

	public String[] requirements = new String[]{
		"ADV_ITEMBREAK"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Stops Time";
	}
}
