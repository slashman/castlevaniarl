package crl.player.advancements.vanquisher;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvTeleport extends Advancement{
	public String getName(){
		return "Teleport";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_TELEPORT", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_TELEPORT";
	}

	public String[] requirements = new String[]{
		"ADV_RECOVER"
	};
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Magically self-transport";
	}
}
