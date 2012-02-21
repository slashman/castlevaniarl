package crl.action.vanquisher;

import crl.action.HeartAction;
import crl.actor.Actor;
import crl.level.Level;
import crl.player.Consts;
import crl.player.Player;

public class EnergyShield extends HeartAction{
	public String getID(){
		return "EnergyShield";
	}
	
	public int getHeartCost() {
		return 15;
	}
	
	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.1);
	}
	
	public void execute(){
		super.execute();
		Player aPlayer = (Player)performer;
		Level aLevel = aPlayer.getLevel();
		aLevel.addMessage("You are covered with a shimmering shield!!");
		aPlayer.setCounter(Consts.C_ENERGYSHIELD, 50+aPlayer.getSoulPower()*2);
	}
	
	
}