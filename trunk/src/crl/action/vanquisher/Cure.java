package crl.action.vanquisher;

import crl.action.HeartAction;
import crl.player.Consts;

public class Cure extends HeartAction{
	public int getHeartCost() {
		return 5;
	}
	
	public String getID() {
		return "CURE";
	}
	
	public void execute() {
		super.execute();
		getPlayer().cure();
	}
}
