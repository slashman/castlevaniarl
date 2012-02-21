package crl.player.advancements.manbeast;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvEnergyScythe extends Advancement{
	public String getName(){
		return "Energy Scythe";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_ENERGYSCYTHE", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_ENERGYSCHYTE";
	}

	public String[] requirements = new String[]{
	};
	
	public String[] bans = new String[]{
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Builds up energy to perform a powerful blow";
	}
	
	public String[] getBans() {
		return bans;
	}
}
