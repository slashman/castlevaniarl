package crl.ai.npc;

import sz.util.Position;
import sz.util.Util;
import crl.action.Action;
import crl.action.monster.MonsterWalk;
import crl.action.npc.PeaceWalk;
import crl.actor.Actor;
import crl.ai.ActionSelector;
import crl.level.Cell;
import crl.npc.NPC;

public class VillagerAI implements ActionSelector{
	 protected boolean onDanger;
	 protected boolean attackPlayer;

	 public Action selectAction(Actor who){
	 	NPC aNPC = (NPC) who;
	 	if (attackPlayer && aNPC.getHits() > 1){
	 		if (Util.chance(10)) {
	 			who.getLevel().addMessage("The "+who.getDescription()+" yells: '"+aNPC.getAngryMessage()+"'", who.getPosition());
	 		}
 			who.getLevel().signal(who.getPosition(), 5, "ATTACK_PLAYER");
	 		int directionToPlayer = aNPC.starePlayer();
	 		if (directionToPlayer != -1){
		 		Action ret = new MonsterWalk();
    	 		ret.setDirection(directionToPlayer);
   			 	return ret;
   			}
	 	}
	 	else if (onDanger){
	 		who.getLevel().addMessage("The "+who.getDescription()+" yells: '"+aNPC.getDangerMessage()+"'", who.getPosition());
	 		who.getLevel().signal(who.getPosition(), 7, "ATTACK_PLAYER");
	 		int directionToPlayer = aNPC.starePlayer();
	 		if (directionToPlayer != -1){
		 		Action ret = new MonsterWalk();
    	 		ret.setDirection(Action.toIntDirection(Position.mul(Action.directionToVariation(directionToPlayer), -1)));
   			 	return ret;
   			}
	 	} else {
		 	if (Util.chance(30)){
		 		Action ret = new PeaceWalk();
		 		int tries = 100;
		 		while (tries > 0){
			 		int direction = Util.rand(0,7);
		 			Position destinationPoint = Position.add(aNPC.getPosition(), Action.directionToVariation(direction));
		 			Cell cell = who.getLevel().getMapCell(destinationPoint);
		 			if (cell == null){
		 				tries--;
		 				continue;
		 			}
		 			if (cell.isSolid() || cell.isStair()){
		 				tries--;
		 				continue;
		 			}
		 			if (cell.getID().startsWith("TOWN_DOOR")){
		 				tries--;
		 				continue;
		 			}
		 			if (cell.getID().startsWith("AIR")){
		 				tries--;
		 				continue;
		 			}
		 			ret.setDirection(direction);
		 			return ret;
		 		}
		 		return null;
	 			
		 	} else 
			 	return null;
		}
		return null;
	 }

	 public String getID(){
		 return "VILLAGER";
	 }

     public ActionSelector derive(){
 		try {
	 		return (ActionSelector) clone();
	 	} catch (CloneNotSupportedException cnse){
			return null;
	 	}
 	}

	public void setOnDanger(boolean value) {
		onDanger = value;
	}

	public void setAttackPlayer(boolean value) {
		attackPlayer = value;
	}
	
	public boolean isHostile(){
		return attackPlayer || onDanger;
	}
}