package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvBatMorph2 extends Advancement{
	public String getName(){
		return "Advanced Chiropteran Metamorphosis";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_BATMORPH2", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_BATMORPH2";
	}

	public String[] requirements = new String[]{
		"ADV_BATMORPH"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Turns into a giant vampire bat";
	}
}
