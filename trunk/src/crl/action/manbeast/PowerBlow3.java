package crl.action.manbeast;

import crl.action.HeartAction;
import crl.level.Level;
import crl.player.Consts;
import crl.player.Player;

public class PowerBlow3 extends HeartAction{
	public int getHeartCost() {
		return 3;
	}
	
	public String getID(){
		return "PowerBlow2";
	}
	
	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getAttackCost() * 1.1);
	}
	
	public void execute(){
		super.execute();
		Player aPlayer = (Player)performer;
		Level aLevel = aPlayer.getLevel();
		aLevel.addMessage("WAAAAARGHHHH!!!! Your eyes go numb!");
		aPlayer.setCounter(Consts.C_POWERBLOW3, 5);
	}
}