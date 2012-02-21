package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvInvokeEagle extends Advancement{
	public String getName(){
		return "Claws' Oath";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_INVOKEEAGLE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_INVOKEEAGLE";
	}

	public String[] requirements = new String[]{
		"ADV_INVOKEBIRD"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Summons an eagle soul familiar";
	}

}
