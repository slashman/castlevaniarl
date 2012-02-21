package crl.player.advancements;

import crl.player.Player;

public class AdvDodge2 extends Advancement{
	public String getName(){
		return "Mirror Dodge";
	}
	
	public void advance(Player p) {
		p.setFlag("PASIVE_DODGE2", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_DODGE2";
	}

	public String[] requirements = new String[]{
		"ADV_DODGE"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Adds another 10% to chance of evading attack";
	}

	public String[] bans = new String[]{
	};
	
	public String[] getBans(){
		return bans;
	}
}
