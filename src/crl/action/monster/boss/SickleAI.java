package crl.action.monster.boss;

import sz.util.Position;
import crl.action.Action;
import crl.action.monster.MonsterWalk;
import crl.actor.Actor;
import crl.ai.ActionSelector;
import crl.ai.monster.MonsterAI;
import crl.level.Cell;
import crl.monster.Monster;

public class SickleAI extends MonsterAI{
	public Action selectAction(Actor who){
		Monster aMonster = (Monster) who;
		int directionToPlayer = aMonster.starePlayer();
		if (directionToPlayer == -1){
	     	return null;
		} else {
			int distanceToPlayer = Position.flatDistance(aMonster.getPosition(), aMonster.getLevel().getPlayer().getPosition());
			if (distanceToPlayer > 20)
				return null;
        	Action ret = new MonsterWalk();
            ret.setDirection(directionToPlayer);
            Cell currentCell = aMonster.getLevel().getMapCell(aMonster.getPosition());
            Cell destinationCell = aMonster.getLevel().getMapCell(
				Position.add(
					aMonster.getPosition(),
					Action.directionToVariation(directionToPlayer)
				));

			if (destinationCell == null || currentCell == null){
				return null;
			}
	     	return ret;
		}

	 }

	 public String getID(){
		 return "WANDER";
	 }

     public ActionSelector derive(){
    	 
 		try {
	 		return (ActionSelector) clone();
	 	} catch (CloneNotSupportedException cnse){
			return null;
	 	}
 	}

     
}