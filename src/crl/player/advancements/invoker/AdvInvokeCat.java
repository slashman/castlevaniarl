package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvInvokeCat extends Advancement{
	public String getName(){
		return "Fang's Oath";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_INVOKECAT", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_INVOKECAT";
	}

	public String[] requirements = new String[]{
		"ADV_INVOKEBIRD",
		"ADV_INVOKETURTLE",
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Summons a cat soul familiar";
	}

}
