package crl.player.advancements.manbeast;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvRegen extends Advancement{
	public void advance(Player p) {
		p.setFlag("HEALTH_REGENERATION", true);
		p.setFlag(getID(), true);
	}
	
	public String getName(){
		return "Regeneration";
	}
	
	public String getID() {
		return "ADV_REGEN";
	}

	public String[] requirements = new String[]{
		"ADV_CLAWASSAULT"
	};
	
	public String[] bans = new String[]{
		"ADV_SELFCONTROL"	
	};
	
	
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Regenerates health at fixed intervals";
	}
	
	public String[] getBans() {
		return bans;
	}
}
