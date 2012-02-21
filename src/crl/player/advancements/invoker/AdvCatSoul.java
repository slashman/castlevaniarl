package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvCatSoul extends Advancement{
	public String getName(){
		return "Cat Soul";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_CATSOUL", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_CATSOUL";
	}

	public String[] requirements = new String[]{
			
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Summons a quick running cat";
	}

}
