package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvStopwatch extends Advancement{
	public String getName(){
		return "Stopwatch";
	}
	
	public void advance(Player p) {
		p.setFlag("MYSTIC_STOPWATCH", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_STOPWATCH";
	}

	public String[] requirements = new String[]{
		"ADV_HOLY_WATER",
		"ADV_HOLY_BIBLE"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Enables use of StopWatch mystic weapon";
	}
}
