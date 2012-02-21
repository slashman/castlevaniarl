package crl.player.advancements.vanquisher;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvRecover extends Advancement{
	public String getName(){
		return "Recover";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_RECOVER", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_RECOVER";
	}

	public String[] requirements = new String[]{};
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Recovers hit points";
	}
}
