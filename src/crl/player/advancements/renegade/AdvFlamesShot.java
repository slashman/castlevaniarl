package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvFlamesShot extends Advancement{
	public String getName(){
		return "Flame's Shoot";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_FLAMESSHOOT", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_FLAMESSHOOT";
	}

	public String[] requirements = new String[]{
			"ADV_SOULSSTRIKE",
			"ADV_SHADETELEPORT"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Shoots three fireballs";
	}
}
