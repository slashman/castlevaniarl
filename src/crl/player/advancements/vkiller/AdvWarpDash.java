package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvWarpDash extends Advancement{
	public String getName(){
		return "Warp Dash";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_WARP_DASH", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_WARP_DASH";
	}

	public String[] requirements = new String[]{
		"ADV_SLIDEKICK"
	};
	
	public String[] bans = new String[]{
		"ADV_AIR_DASH", "ADV_BACKFLIP"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Dashes 4 spaces ahead passing through any enemies in the way";
	}
	
	public String[] getBans(){
		return bans;
	}
}
