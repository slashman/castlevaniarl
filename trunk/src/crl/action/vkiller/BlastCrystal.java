package crl.action.vkiller;

import crl.action.Action;
import crl.action.HeartAction;
import crl.actor.Actor;
import crl.level.Level;
import crl.player.Player;

public class BlastCrystal extends HeartAction{
	public int getHeartCost() {
		return 5;
	}
	public String getID(){
		return "BLAST_CRYSTAL";
	}
	
	public void execute(){
		super.execute();
		Player aPlayer = (Player) performer;
        Level aLevel = performer.getLevel();
        aLevel.addMessage("You release a mystic crystal!");
		aLevel.addSmartFeature("BLAST_CRYSTAL", performer.getPosition());
	}
	
	public int getCost(){
		Player p = (Player) performer;
		return (int)(25 / (p.getShotLevel()+1));
	}
}