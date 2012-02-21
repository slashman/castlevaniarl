package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvBackflip extends Advancement{
	public String getName(){
		return "Backflip";
	}
	
	public void advance(Player p) {
		p.setFlag("PASIVE_BACKFLIP", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_BACKFLIP";
	}

	public String[] requirements = new String[]{
		"ADV_SLIDEKICK"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "40% chance of double evade check";
	}

	public String[] bans = new String[]{
		"ADV_AIR_DASH", "ADV_WARP_DASH"
	};
	
	public String[] getBans(){
		return bans;
	}
}
