package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvInvokeBird extends Advancement{
	public String getName(){
		return "Feather's Oath";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_INVOKEBIRD", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_INVOKEBIRD";
	}

	public String[] requirements = new String[]{
		"ADV_MANIPULATE"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Summons a bird soul familiar";
	}

}
