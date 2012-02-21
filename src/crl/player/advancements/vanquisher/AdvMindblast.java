package crl.player.advancements.vanquisher;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvMindblast extends Advancement{
	public String getName(){
		return "Mind Blast";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_MINDBLAST", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_MINDBLAST";
	}

	public String[] requirements = new String[]{
		"ADV_ENERGYSHIELD",
		"ADV_MINDLOCK",
	};
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Attacks all surrounding enemies minds";
	}
}
