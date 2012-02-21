package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvWolfMorph2 extends Advancement{
	public String getName(){
		return "Advanced Lupine Metamorphosis";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_WOLFMORPH2", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_WOLFMORPH2";
	}

	public String[] requirements = new String[]{
		"ADV_WOLFMORPH"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Turns into a quick and fierce lupine monster";
	}
}
