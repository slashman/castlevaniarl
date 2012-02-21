package crl.action;

import sz.util.Debug;
import crl.item.Item;
import crl.level.Level;
import crl.player.Player;


public class Get extends Action{
	public String getID(){
		return "Get";
	}
	
	public boolean needsUnderlyingItem(){return true;}
	public String getPrompUnderlyingItem(){return "What Item will you get?";}
	
	public void execute(){
		Debug.doAssert(performer instanceof Player, "An actor different from the player tried to execute Walk action");
		Debug.enterMethod(this, "execute");
		Player aPlayer = (Player) performer;
		Level aLevel = performer.getLevel();
        
		Item destinationItem = targetItem;
		if (destinationItem != null){
		//while (destinationItem != null){
			if (aPlayer.canCarry()){
				aLevel.addMessage("You pick up the "+destinationItem.getDescription()+".");
				aPlayer.addItem(destinationItem);
				aLevel.removeItemFrom(destinationItem, performer.getPosition());
			} else {
				aLevel.addMessage("You have too many things already to pick up the "+destinationItem.getDescription()+"!.");
			}
			
			//destinationItem = aLevel.getItemAt(destinationPoint);
		} else {
			aLevel.addMessage("There is nothing to pick up here!");
		}
       	Debug.exitMethod();
	}

}