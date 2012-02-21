package crl.action.manbeast;

import crl.action.MorphAction;
import crl.player.Consts;
import crl.player.Player;

public class BeastMorph extends MorphAction{
	public int getHeartCost() {
		return 15;
	}
	
	public String getID(){
		return "BeastMorph";
	}

	public String getSFX(){
		return "wav/growll.wav";
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getAttackCost() * 1.5);
	}
	
	public int getMadChance() {
		return 60 - getPlayer().getSoulPower();
	}

	public String getMorphID() {
		return Consts.C_BEASTMORPH;
	}

	public String getMorphMessage() {
		return "You turn into a beast!";
	}

	public int getMorphStrength() {
		return 10;
	}

	public int getMorphTime() {
		return 40+getPlayer().getSoulPower()*3+(!getPlayer().getLevel().isDay()?50:0);
	}

	public boolean isBigMorph() {
		return true;
	}

	public boolean isSmallMorph() {
		return false;
	}
}