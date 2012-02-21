package crl.player.advancements.vanquisher;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvMajorJinx extends Advancement{
	public String getName(){
		return "Major Jinx";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_MAJORJINX", true);
		p.setFlag("SKILL_RECOVER", false);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_MAJORJINX";
	}

	public String[] requirements = new String[]{
		"ADV_LIGHT",
		"ADV_MINDBLAST",
	};
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Attacks all surrounding enemies minds";
	}
}
