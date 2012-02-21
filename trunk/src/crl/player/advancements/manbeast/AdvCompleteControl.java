package crl.player.advancements.manbeast;

import crl.player.Consts;
import crl.player.advancements.FlagAdvancement;

public class AdvCompleteControl extends FlagAdvancement{
	public String getName(){
		return "Complete Control";
	}
	
	public String getFlagName() {
		return Consts.F_COMPLETECONTROL;
	}
	
	public String getID() {
		return "ADV_COMPLETECONTROL";
	}

	public String[] requirements = new String[]{
		"ADV_SELFCONTROL"
	};
	
	public String[] bans = new String[]{
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Complete control when morphing";
	}
	
	public String[] getBans() {
		return bans;
	}
}
