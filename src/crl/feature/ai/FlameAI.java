package crl.feature.ai;

import crl.*;
import crl.action.*;
import crl.ai.*;
import crl.actor.*;
import crl.feature.SmartFeature;
import crl.feature.action.Shine;
import crl.monster.Monster;


/** Stays alive for 5 turns, causes an animation each turn
 * then dies;*/

public class FlameAI implements ActionSelector, Cloneable{
	private int turnsToDie;
	private boolean activated;
	public String getID(){
	     return "FLAME_SELECTOR";
	}

	public Action selectAction(Actor who){
		if (activated){
			turnsToDie--;
			if (turnsToDie == 0){
				who.die();
				who.getLevel().removeSmartFeature((SmartFeature)who);
				activated = false;
				return null;
			}
			Monster m = who.getLevel().getMonsterAt(who.getPosition());
			if (m != null){
				m.damage(new StringBuffer(), 1);
			}
			return Shine.getAction();
		} else {
			turnsToDie = 5;
			activated = true;
			return Shine.getAction();
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