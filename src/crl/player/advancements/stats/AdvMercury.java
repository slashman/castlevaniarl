package crl.player.advancements.stats;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvMercury extends Advancement{
	public String getName(){
		return "Mercury Spirit";
	}
	
	public String[] getRequirements() {
		return NO_REQUIREMENTS;
	}
	
	private int getIncrement(Player p){
		int increment = 5;
		if (p.getPlayerLevel() > 40)
			increment = 15;
		else if (p.getPlayerLevel() > 30)
			increment = 10;
		else if (p.getPlayerLevel() > 20)
			increment = 10;
		else if (p.getPlayerLevel() > 10)
			increment = 5;
		return increment;
	}
	
	public void advance(Player p) {
		p.setBaseEvadeChance(p.getBaseEvadeChance()+getIncrement(p));
		p.addLastIncrement(Player.INCREMENT_EVADE,getIncrement(p));
	}

	public String getID() {
		return "ADV_MARS";
	}

	public String getDescription(){
		return "Swiftly evades attacks";
	}
}
