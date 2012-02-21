package crl.action.vanquisher;

import crl.action.Action;
import crl.actor.Actor;
import crl.level.Level;
import crl.player.Player;

public class MajorJinx extends Action{
	public String getID(){
		return "MAJOR_JINX";
	}
	
	public String getSFX(){
		return null;
	}
	
	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.1);
	}
	
	public void execute(){
		Player aPlayer = (Player)performer;
		Level aLevel = aPlayer.getLevel();
		
		int recover = 5+aPlayer.getSoulPower()*2;
		StringBuffer buff = new StringBuffer("You exchange vitality for power!! (+"+recover+")");
		aPlayer.addHearts(recover);
		aPlayer.selfDamage(buff, Player.DAMAGE_JINX, 5);
		aLevel.addMessage(buff.toString());
		
		
	}
	
	public boolean canPerform(Actor a){
		Player aPlayer = (Player) a;
        Level aLevel = performer.getLevel();
        if (aPlayer.getHits() <= 5){
            aLevel.addMessage("That would be suicidal!");
            return false;
		}
        return true;
	}
}