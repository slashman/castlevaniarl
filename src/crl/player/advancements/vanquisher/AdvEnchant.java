package crl.player.advancements.vanquisher;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvEnchant extends Advancement{
	public String getName(){
		return "Weapon Enchantment";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_ENCHANT", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_ENCHANT";
	}

	public String[] requirements = new String[]{};
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Covers weapons in a blue aura";
	}
}
