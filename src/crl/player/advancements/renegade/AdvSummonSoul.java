package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvSummonSoul extends Advancement{
	public String getName(){
		return "Summon Soul";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_SUMMONSOUL", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_SUMMONSOUL";
	}

	public String[] requirements = new String[]{

	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "A soul flies straight to the nearest enemy";
	}
}
