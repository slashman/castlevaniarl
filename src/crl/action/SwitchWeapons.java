package crl.action;

import crl.actor.Actor;
import crl.item.Item;
import crl.player.Player;

public class SwitchWeapons extends Action{
	public int getCost() {
		return 25;
	}

	public String getID(){
		return "SwitchWeapons";
	}
	
	public void execute(){
		Player aPlayer = (Player) performer;
		Item secondary = aPlayer.getSecondaryWeapon();
		if (secondary == null){
			/*aPlayer.getLevel().addMessage("You don't have a secondary weapon");
			return;*/
			Item primary = aPlayer.getWeapon();
			aPlayer.setWeapon(null);
			aPlayer.getLevel().addMessage("You attack unarmed");
			if (primary != null){
				aPlayer.setSecondaryWeapon(primary);
			} 
			return;
		}
		Item primary = aPlayer.getWeapon();
		aPlayer.setWeapon(secondary);
		if (primary != null){
			aPlayer.setSecondaryWeapon(primary);
			aPlayer.getLevel().addMessage("You switch your "+primary.getDescription()+" for your "+secondary.getDescription());
		} else {
			aPlayer.setSecondaryWeapon(null);
			aPlayer.getLevel().addMessage("You equip your "+secondary.getDescription());
		}
 	}
	
	public boolean canPerform(Actor a){
		/*Player aPlayer = (Player) a;
		Item secondary = aPlayer.getSecondaryWeapon();
		if (secondary == null){
			invalidationMessage = "You don't have a secondary weapon";
			return false;
		}*/
		return true;
	}
}