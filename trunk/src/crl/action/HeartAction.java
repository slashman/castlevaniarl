package crl.action;

import crl.action.Action;
import crl.actor.Actor;
import crl.item.Item;
import crl.item.ItemDefinition;
import crl.player.Player;

public abstract class HeartAction extends Action{
	public abstract int getHeartCost();
	//public abstract double getTimeCostModifier();
	
	public void execute(){
		reduceHearts();
	}
	
	public void reduceHearts(){
		Player aPlayer = (Player) performer;
		aPlayer.reduceHearts(getHeartCost());
	}

	public Player getPlayer(){
		return (Player) performer;
	}
	
	
	
	/*public final int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * getTimeCostModifier());
	}*/

	public boolean canPerform(Actor a) {
		Player p = getPlayer(a);
		setPerformer(a);
		if (p.getHearts() >= getHeartCost()){
			return true;
		}
		invalidationMessage = "Your need more power!";
		return false;
	}
}