package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvAirDash extends Advancement{
	public String getName(){
		return "Air Dash";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_AIR_DASH", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_AIR_DASH";
	}

	public String[] requirements = new String[]{
		"ADV_SLIDEKICK"
	};
	
	public String[] bans = new String[]{
		"ADV_WARP_DASH", "ADV_BACKFLIP" 
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Dashes 3 spaces ahead, knocks back large enemies.";
	}
	
	public String[] getBans(){
		return bans;
	}
}
