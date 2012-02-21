package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvInvokeTiger extends Advancement{
	public String getName(){
		return "Wild Oath";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_INVOKETIGER", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_INVOKETIGER";
	}

	public String[] requirements = new String[]{
		"ADV_INVOKECAT",
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Summons a tiger soul familiar";
	}

}
