package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvBirdsEgg extends Advancement{
	public String getName(){
		return "Birds' Egg";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_BIRDSEGG", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_BIRDSEGG";
	}

	public String[] requirements = new String[]{
			
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Throw an ethereal exploding bird's egg";
	}

}
