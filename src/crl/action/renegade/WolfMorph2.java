package crl.action.renegade;

import crl.action.MorphAction;
import crl.player.Consts;
import crl.player.Player;

public class WolfMorph2 extends MorphAction{
	public int getHeartCost() {
		return 10;
	}
	
	public String getID(){
		return "WolfMorph2";
	}

	public String getSFX(){
		return "wav/swaashll.wav";
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.5);
	}
	
	
	public int getMadChance() {
		return 5;
	}

	public String getMorphID() {
		return Consts.C_BATMORPH2;
	}

	public String getMorphMessage() {
		return "You turn into a grey wolf!";
	}

	public int getMorphStrength() {
		return 10;
	}

	public int getMorphTime() {
		return 30+getPlayer().getSoulPower()*4+(!getPlayer().getLevel().isDay()?40:0);
	}

	public boolean isBigMorph() {
		return false;
	}

	public boolean isSmallMorph() {
		return true;
	}
}