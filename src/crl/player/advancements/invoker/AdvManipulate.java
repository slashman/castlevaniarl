package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvManipulate extends Advancement{
	public String getName(){
		return "Manipulate";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_MANIPULATE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_MANIPULATE";
	}

	public String[] requirements = new String[]{
		"ADV_BIRDSEGG"
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Manipulates a monster's soul to your side";
	}

}
