package crl.player.advancements.stats;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvTerra extends Advancement{
	public String getName(){
		return "Terra Spirit";
	}
	
	public String[] getRequirements() {
		return NO_REQUIREMENTS;
	}
	
	private int getIncrement(Player p){
		int increment = 1;
		if (p.getPlayerLevel() > 40)
			increment = 5;
		else if (p.getPlayerLevel() > 30)
			increment = 4;
		else if (p.getPlayerLevel() > 20)
			increment = 3;
		else if (p.getPlayerLevel() > 10)
			increment = 2;
		return increment;
	}
	
	public void advance(Player p) {
		p.setSoulPower(p.getSoulPower()+getIncrement(p));
		p.addLastIncrement(Player.INCREMENT_SOUL,getIncrement(p));
	}

	public String getID() {
		return "ADV_MARS";
	}

	public String getDescription(){
		return "Increases Soul Power";
	}
}
