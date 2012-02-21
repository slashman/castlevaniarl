package crl.action.manbeast;

import crl.action.HeartAction;
import crl.action.MorphAction;
import crl.player.Consts;
import crl.player.Player;

public class DemonMorph extends MorphAction{
	public int getHeartCost() {
		return 15;
	}
	
	public String getID(){
		return "DemonMorph";
	}

	public String getSFX(){
		return "wav/growll.wav";
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getAttackCost() * 1.5);
	}
	
	
	public int getMadChance() {
		return 30 - getPlayer().getSoulPower();
	}

	public String getMorphID() {
		return Consts.C_DEMONMORPH;
	}

	public String getMorphMessage() {
		return "You turn into a demon!";
	}

	public int getMorphStrength() {
		return 10;
	}

	public int getMorphTime() {
		return 60+getPlayer().getSoulPower()*3+(!getPlayer().getLevel().isDay()?50:0);
	}

	public boolean isBigMorph() {
		return false;
	}

	public boolean isSmallMorph() {
		return false;
	}
}