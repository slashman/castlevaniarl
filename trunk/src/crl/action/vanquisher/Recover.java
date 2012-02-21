package crl.action.vanquisher;

import crl.action.Action;
import crl.action.HeartAction;
import crl.actor.Actor;
import crl.level.Level;
import crl.player.Player;

public class Recover extends HeartAction{
	public int getHeartCost() {
		return 15;
	}
	
	public String getID(){
		return "RECOVER";
	}
	
	public String getSFX(){
		return null;
	}
	
	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.1);
	}
	
	public void execute(){
		super.execute();
		Player aPlayer = (Player)performer;
		aPlayer.recoverHitsP(10+aPlayer.getSoulPower());
		aPlayer.getLevel().addMessage("You feel relieved!");
	}
}