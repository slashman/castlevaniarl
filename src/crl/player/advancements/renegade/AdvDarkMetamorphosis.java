package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvDarkMetamorphosis extends Advancement{
	public String getName(){
		return "Dark Metamorphosis";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_DARKMETAMORPHOSIS", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_DARKMETAMORPHOSIS";
	}

	public String[] requirements = new String[]{

	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Recovers health from enemies blood for a while";
	}
}
