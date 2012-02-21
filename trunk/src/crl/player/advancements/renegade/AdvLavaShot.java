package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvLavaShot extends Advancement{
	public String getName(){
		return "Hellfire";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_HELLFIRE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_HELLFIRE";
	}

	public String[] requirements = new String[]{
			"ADV_FLAMESSHOOT"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Shoots three big lava balls";
	}
}
