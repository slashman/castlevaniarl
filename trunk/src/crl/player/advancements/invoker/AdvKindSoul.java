package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvKindSoul extends Advancement{
	public String getName(){
		return "Kind Soul";
	}
	
	public void advance(Player p) {
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_KIND_SOUL";
	}

	public String[] requirements = new String[]{
		"ADV_DRAGONFIRE",
	};
	
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Befriend Monster Souls";
	}

}
