package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvConfidence extends Advancement{
	public String getName(){
		return "Confidence";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_CONFIDENCE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_CONFIDENCE";
	}

	public String[] requirements = new String[]{
		"ADV_DRAGONFIRE"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Raises Manipulation chance by 20%";
	}

}
