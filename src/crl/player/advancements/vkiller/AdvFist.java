package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvFist extends Advancement{
	public String getName(){
		return "Sacred Fist";
	}
	
	public void advance(Player p) {
		p.setFlag("MYSTIC_FIST", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_FIST";
	}

	public String[] requirements = new String[]{
		"ADV_CROSS",
		"ADV_STOPWATCH"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Enables use of Sacred Fist mystic weapon";
	}
}
