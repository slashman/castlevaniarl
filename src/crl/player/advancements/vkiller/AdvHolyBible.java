package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvHolyBible extends Advancement{
	public String getName(){
		return "Holy Bible";
	}
	
	public void advance(Player p) {
		p.setFlag("MYSTIC_HOLY_BIBLE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_HOLY_BIBLE";
	}

	public String[] requirements = new String[]{};
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Enables use of Holy Bible mystic weapon";
	}
}
