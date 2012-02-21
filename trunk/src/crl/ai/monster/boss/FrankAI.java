package crl.ai.monster.boss;

import sz.util.Util;
import crl.action.Action;
import crl.action.monster.MonsterWalk;
import crl.actor.Actor;
import crl.ai.ActionSelector;
import crl.ai.monster.MonsterAI;
import crl.monster.Monster;

public class FrankAI extends MonsterAI{
	private int powerCounter = 5;
	
	public Action selectAction(Actor who){
		Monster aMonster = (Monster) who;
		if (powerCounter < 0){
			who.getLevel().addMessage("Frank calms down");
			powerCounter = 25;
		}
		else
			powerCounter--;

		int directionToPlayer = aMonster.starePlayer();
		
		if (powerCounter > 4 || directionToPlayer == -1){
			int direction = Util.rand(0,7);
	     	Action ret = new MonsterWalk();
	     	ret.setDirection(direction);
	     	return ret;
		} else {
			// Walk to the player
			who.getLevel().addMessage("Frank is angry!,");
			Action ret = new MonsterWalk();
            ret.setDirection(directionToPlayer);
            return ret;
		}
	 }

	 public String getID(){
		 return "FRANK_AI";
	 }

	 public ActionSelector derive(){
 		try {
	 		return (ActionSelector) clone();
	 	} catch (CloneNotSupportedException cnse){
			return null;
	 	}
 	}

}