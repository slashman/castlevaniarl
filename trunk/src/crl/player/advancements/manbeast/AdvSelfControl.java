package crl.player.advancements.manbeast;

import crl.player.Consts;
import crl.player.advancements.FlagAdvancement;

public class AdvSelfControl extends FlagAdvancement{
	public String getName(){
		return "Self Control";
	}
	
	public String getFlagName() {
		return Consts.F_SELFCONTROL;
	}
	
	public String getID() {
		return "ADV_SELFCONTROL";
	}

	public String[] requirements = new String[]{
		"ADV_CLAWASSAULT"
	};
	
	public String[] bans = new String[]{
		"ADV_REGEN"	
	};
	
	public String[] getRequirements() {
		return requirements;
	}

	public String getDescription(){
		return "Halves risk of going out of control when morphing";
	}
	
	public String[] getBans() {
		return bans;
	}
}
