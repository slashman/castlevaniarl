package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvTame extends Advancement{
	public String getName(){
		return "Tame Soul";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_TAME", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_TAME";
	}

	public String[] requirements = new String[]{
		"ADV_INVOKEEAGLE",
		"ADV_INVOKETORTOISE",
		"ADV_INVOKETIGER"
	};
	
	public String[] bans = new String[]{
		"ADV_INVOKEDRAGON"
	};
	
	public String[] getBans() {
		return bans;
	}
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Permanently turns a soul to your side";
	}

}
