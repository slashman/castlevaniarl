package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvInvokeTortoise extends Advancement{
	public String getName(){
		return "Adamant Oath";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_INVOKETORTOISE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_INVOKETORTOISE";
	}

	public String[] requirements = new String[]{
		"ADV_INVOKETURTLE"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Summons a tortoise soul familiar";
	}

}
