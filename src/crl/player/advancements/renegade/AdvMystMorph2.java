package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvMystMorph2 extends Advancement{
	public String getName(){
		return "Advanced Ethereal Metamorphosis";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_MYSTMORPH2", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_MYSTMORPH2";
	}

	public String[] requirements = new String[]{
		"ADV_MYSTMORPH"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Turns into a energy cloud";
	}
}
