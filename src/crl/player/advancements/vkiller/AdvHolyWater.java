package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvHolyWater extends Advancement{
	public String getName(){
		return "Holy Water";
	}
	
	public void advance(Player p) {
		p.setFlag("MYSTIC_HOLY_WATER", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_HOLY_WATER";
	}

	public String[] requirements = new String[]{};
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Enables use of Holy Water mystic weapon";
	}
}
