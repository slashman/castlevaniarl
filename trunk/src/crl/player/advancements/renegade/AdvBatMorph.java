package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvBatMorph extends Advancement{
	public String getName(){
		return "Chiropteran Metamorphosis";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_BATMORPH", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_BATMORPH";
	}

	public String[] requirements = new String[]{
			"ADV_MORPH"
	};
	
	public String[] bans = new String[]{
			"ADV_MYSTMORPH"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Turns into a flying bat";
	}
	
	public String[] getBans() {
		return bans;
	}
}
