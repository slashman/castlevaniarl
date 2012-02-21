package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvDragonFire extends Advancement{
	public String getName(){
		return "DragonFire";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_DRAGONFIRE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_DRAGONFIRE";
	}

	public String[] requirements = new String[]{
		"ADV_CATSOUL"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Invokes ethereal dragon fire";
	}

}
