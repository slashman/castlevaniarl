package crl.player.advancements.vkiller;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvItemBreak extends Advancement{
	public String getName(){
		return "Item Break";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_ITEM_BREAK", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_ITEMBREAK";
	}

	public String[] requirements = new String[]{
		"ADV_HOLY_WATER",
		"ADV_HOLY_BIBLE"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Allows execution of item break mystic attacks";
	}
}
