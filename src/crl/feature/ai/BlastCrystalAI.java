package crl.feature.ai;

import crl.action.Action;
import crl.actor.Actor;
import crl.ai.ActionSelector;
import crl.feature.SmartFeature;
import crl.feature.action.*;

public class BlastCrystalAI implements ActionSelector, Cloneable{
	private int blastCounter;
	private int turnsToBlast; 
	private boolean activated;
	
	public String getID(){
	     return "CRYSTAL_SELECTOR";
	}

	public Action selectAction(Actor who){
		if (activated){
			if (blastCounter > 2){
				who.die();
				who.getLevel().removeSmartFeature((SmartFeature)who);
				activated = false;
				return null;
			}else{
				turnsToBlast--;
				if (turnsToBlast == 0) {
					turnsToBlast = 5;
					blastCounter++;
					return new Blast();
				} else {
					return null;
				}
			}
		} else {
			turnsToBlast = 5;
			activated = true;
			return new Blast();
		}
 	}

 	public ActionSelector derive(){
 		try {
	 		return (ActionSelector) clone();
	 	} catch (CloneNotSupportedException cnse){
			return null;
	 	}
 	}

}