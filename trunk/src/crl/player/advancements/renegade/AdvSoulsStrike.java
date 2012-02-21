package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvSoulsStrike extends Advancement{
	public String getName(){
		return "Soul's Strike";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_SOULSSTRIKE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_SOULSSTRIKE";
	}

	public String[] requirements = new String[]{
			"ADV_SUMMONSOUL",
			"ADV_DARKMETAMORPHOSIS"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Three souls fly straight to the nearest enemies";
	}
}
