package crl.action.knight;

import crl.action.Action;
import crl.action.HeartAction;
import crl.actor.Actor;

public class Defend extends HeartAction {
	public int getHeartCost() {
		return 1;
	}

	public String getID() {
		return "DEFEND";
	}
	
	public boolean needsDirection() {
		return true;
	}
	
	public String getPromptDirection() {
		return "Where will you locate your shield to?";
	}
	
	public void execute() {
		super.execute();
		if (targetDirection == Action.SELF){
			return;
		}
		getPlayer().getLevel().addMessage("You defend yourself with your "+getPlayer().getShield().getDescription());
		getPlayer().setShieldGuard(targetDirection, 5);
	}
	
	public boolean canPerform(Actor a) {
		if (getPlayer().getShield() == null){
			invalidationMessage = "You don't have a shield.";
			return false;
		}
		return super.canPerform(a);
	}

}
