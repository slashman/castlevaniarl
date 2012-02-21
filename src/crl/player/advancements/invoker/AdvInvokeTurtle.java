package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvInvokeTurtle extends Advancement{
	public String getName(){
		return "Shell Oath";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_INVOKETURTLE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_INVOKETURTLE";
	}

	public String[] requirements = new String[]{
		"ADV_MANIPULATE"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Summons a turtle soul familiar";
	}

}
