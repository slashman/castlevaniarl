package crl.player.advancements.renegade;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvMorph extends Advancement{
	public String getName(){
		return "Morph";
	}
	
	public void advance(Player p) {
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_MORPH";
	}

	public String[] requirements = new String[]{
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Allows access to morphing skills";
	}

}
