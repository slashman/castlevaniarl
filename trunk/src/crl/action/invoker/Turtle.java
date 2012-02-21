package crl.action.invoker;

import crl.action.HeartAction;
import crl.level.Level;
import crl.player.Consts;
import crl.player.Player;

public class Turtle extends HeartAction{
	public int getHeartCost() {
		return 5;
	}
	
	public String getID(){
		return "Turtle";
	}
	
	public String getSFX(){
		return "wav/turtleCry.wav";
	}
	
	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.1);
	}
	
	public void execute(){
		super.execute();
		Player aPlayer = (Player)performer;
		Level aLevel = aPlayer.getLevel();
		aLevel.addMessage("A cute turtle soul surrounds you");
		aPlayer.setCounter(Consts.C_TURTLESHELL, 50+aPlayer.getSoulPower()*2);
	}
}