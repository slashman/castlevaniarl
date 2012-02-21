package crl.player.advancements.invoker;

import crl.player.Player;
import crl.player.advancements.Advancement;

public class AdvInvokeDragon extends Advancement{
	public String getName(){
		return "Ancient Oath";
	}
	
	public void advance(Player p) {
		p.setFlag("SKILL_INVOKEDRAGON", true);
		p.setFlag(getID(), true);
	}

	public String getID() {
		return "ADV_INVOKEDRAGON";
	}

	public String[] requirements = new String[]{
		"ADV_INVOKEEAGLE",
		"ADV_INVOKETORTOISE",
		"ADV_INVOKETIGER",
	};
	
	public String[] bans = new String[]{
			"ADV_TAME"
		};
		
	public String[] getBans() {
		return bans;
	}
		
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Summons an ancient dragon soul familiar";
	}

}
