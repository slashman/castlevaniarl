package crl.player.advancements.vanquisher;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvMindlock extends Advancement{
	public String getName(){
		return "Mindlock";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_MINDLOCK", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_MINDLOCK";
	}

	public String[] requirements = new String[]{
		"ADV_ENCHANT"
	};
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Paralizes an enemy for a short time";
	}
}
