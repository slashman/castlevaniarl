package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvCross extends Advancement{
	public String getName(){
		return "Holy Cross";
	}
	
	public void advance(Player p) {
		p.setFlag("MYSTIC_CROSS", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_CROSS";
	}

	public String[] requirements = new String[]{
		"ADV_HOLY_WATER",
		"ADV_HOLY_BIBLE"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Enables use of Holy Cross mystic weapon";
	}
}
