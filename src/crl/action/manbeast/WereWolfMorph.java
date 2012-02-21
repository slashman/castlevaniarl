package crl.action.manbeast;

import crl.action.MorphAction;
import crl.player.Consts;
import crl.player.Player;

public class WereWolfMorph extends MorphAction{
	public int getHeartCost() {
		return 20;
	}
	
	public String getID(){
		return "WereWolfMorph";
	}

	public String getSFX(){
		return "wav/howl.wav";
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getAttackCost() * 1.5);
	}
	
	
	public int getMadChance() {
		return 120-getPlayer().getSoulPower();
	}

	public String getMorphID() {
		return Consts.C_WEREWOLFMORPH;
	}

	public String getMorphMessage() {
		return "You turn into the legendary werewolf!";
	}

	public int getMorphStrength() {
		return 10;
	}

	public int getMorphTime() {
		return 40+getPlayer().getSoulPower()+(!getPlayer().getLevel().isDay()?60:0);
	}

	public boolean isBigMorph() {
		return true;
	}

	public boolean isSmallMorph() {
		return false;
	}
}