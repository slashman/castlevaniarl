package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvMystMorph extends Advancement{
	public String getName(){
		return "Ethereal Metamorphosis";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_MYSTMORPH", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_MYSTMORPH";
	}

	public String[] requirements = new String[]{
			"ADV_MORPH"
	};
	
	public String[] bans = new String[]{
			"ADV_BATMORPH"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Turns into thin myst";
	}
	
	public String[] getBans() {
		return bans;
	}
}
