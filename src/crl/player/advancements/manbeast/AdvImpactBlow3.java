package crl.player.advancements.manbeast;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvImpactBlow3 extends Advancement{
	public String getName(){
		return "Power Crash";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_POWERBLOW3", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_POWERBLOW3";
	}

	public String[] requirements = new String[]{
			"ADV_POWERBLOW2"
	};
	
	public String[] bans = new String[]{
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Replaces power strike for a devasting power crash";
	}
	
	public String[] getBans() {
		return bans;
	}
}
