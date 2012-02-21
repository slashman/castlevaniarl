package crl.action.vkiller;

import crl.action.HeartAction;
import crl.level.Level;
import crl.player.Player;

public class Stopwatch extends HeartAction{
	public int getHeartCost() {
		return 3;
	}
	public String getID(){
		return "Stopwatch";
	}
	
	public void execute(){
		super.execute();
		Player aPlayer = (Player) performer;
		Level x = performer.getLevel();
		x.addMessage("You open the stopwatch! Time stops!");
		x.stopTime(5 + aPlayer.getShotLevel()*2+ aPlayer.getSoulPower());
	}

	public String getSFX(){
		return "wav/clockbel.wav";
	}
	public int getCost(){
		Player p = (Player) performer;
		return (int)(25 / (p.getShotLevel()+1));
	}

	
}