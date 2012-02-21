package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvCrystal extends Advancement{
	public String getName(){
		return "Blast Crystal";
	}
	
	public void advance(Player p) {
		p.setFlag("MYSTIC_CRYSTAL", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_CRYSTAL";
	}

	public String[] requirements = new String[]{
			"ADV_CROSS",
			"ADV_STOPWATCH"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Enables use of Blast Crystal mystic weapon";
	}
}
