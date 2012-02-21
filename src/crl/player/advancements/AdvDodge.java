package crl.player.advancements;

import crl.player.Player;

public class AdvDodge extends Advancement{
	public String getName(){
		return "Dodge";
	}
	
	public void advance(Player p) {
		p.setFlag("PASIVE_DODGE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_DODGE";
	}

	public String[] requirements = new String[]{
		
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Adds 10% to chance of evading attack";
	}

	public String[] bans = new String[]{
	};
	
	public String[] getBans(){
		return bans;
	}
}
