package crl.ai.monster;

import java.util.Vector;

import sz.util.Debug;
import crl.action.Action;
import crl.actor.Actor;
import crl.ai.ActionSelector;

public abstract class MonsterAI  implements ActionSelector, Cloneable{
	protected Vector<RangedAttack> rangedAttacks;
	
	public void setRangedAttacks(Vector<RangedAttack> pRangedAttacks){
   	 rangedAttacks = pRangedAttacks;
    }
	
	public abstract Action selectAction(Actor who);
	public abstract String getID();

	public ActionSelector derive(){
		try {
			return (ActionSelector) clone();
		} catch (Exception e) {
			Debug.byebye("Failed to clone MonsterAI "+getID());
			return null;
		}
	}
}
