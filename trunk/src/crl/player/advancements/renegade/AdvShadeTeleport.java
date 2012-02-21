package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvShadeTeleport extends Advancement{
	public String getName(){
		return "Shade Teleport";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_SHADETELEPORT", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_SHADETELEPORT";
	}

	public String[] requirements = new String[]{
			"ADV_DARKMETAMORPHOSIS",
			"ADV_SUMMONSOUL"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Roll in your cape and teleport in a straight line";
	}
}
