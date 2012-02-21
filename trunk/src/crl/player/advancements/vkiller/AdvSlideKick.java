package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvSlideKick extends Advancement{
	public String getName(){
		return "Slide Kick";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_SLIDEKICK", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_SLIDEKICK";
	}

	public String[] requirements = new String[]{
		"ADV_HOLY_WATER",
		"ADV_HOLY_BIBLE"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Slides 3 spaces ahead kicking any enemy in the path";
	}
	
	
}
