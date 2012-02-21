package crl.player.advancements.vanquisher;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvEnergyShield extends Advancement{
	public String getName(){
		return "Energy Shield";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_ENERGYSHIELD", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_ENERGYSHIELD";
	}

	public String[] requirements = new String[]{
		"ADV_ENCHANT"
	};
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Creates a shield that reduces harm caused by enemies";
	}
}
