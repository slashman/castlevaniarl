package crl.ai.monster.boss;

import sz.util.Position;
import sz.util.Util;
import crl.action.Action;
import crl.action.monster.boss.Materialize;
import crl.action.monster.boss.ShadowExtinction;
import crl.action.monster.boss.ShadowFlare;
import crl.action.monster.boss.Vanish;
import crl.actor.Actor;
import crl.ai.ActionSelector;
import crl.ai.monster.MonsterAI;
import crl.game.SFXManager;
import crl.monster.Monster;
import crl.player.Player;

public class DraculaAI extends MonsterAI{
	private int vanishCounter = 3;
	private int appearCounter = 0;
	private boolean onBattle;
	private boolean isVanished;
	
	public void reset(){
		vanishCounter = 3;
		appearCounter = 0;
		onBattle = false;
		isVanished  = false;	
	}
	
	public Action selectAction(Actor who){
		Monster aMonster = (Monster) who;
		if (onBattle){
			if (isVanished){
				if (appearCounter < 0){
					
					isVanished = false;
					vanishCounter = 3 + Util.rand(0,2);
					return new Materialize();
				} else { 
					if (Util.chance(70)){
						aMonster.getLevel().addMessage("You hear a creepy voice booming around the place: 'HAHAHAHA!'");
						SFXManager.play("wav/dracula_laugh.wav");
					}
					appearCounter --;
					return null;
				}
			} else {
				if (vanishCounter < 0) {
					isVanished = true;
					appearCounter = Util.rand(2,5);
					return new Vanish();
				} else {
					vanishCounter--;
					if (playerOnLine(aMonster)){
						int directionToPlayer = starePlayer(aMonster);
						Action ret = new ShadowFlare();
						ret.setDirection(directionToPlayer);
						return ret;
					} else {
						if (Util.chance(50))
							return new ShadowExtinction();
						else
							return null;
					}
				}
			}
		} else {
			return null;
		}
	 }
	
	public void setOnBattle(boolean value){
		onBattle = value;
	}
	
	public boolean isOnBattle(){
		return onBattle;
	}

	 public String getID(){
		 return "DRACULA_AI";
	 }

	 public ActionSelector derive(){
 		try {
	 		return (ActionSelector) clone();
	 		
	 	} catch (CloneNotSupportedException cnse){
			return null;
	 	}
 	}
	 
	 private boolean playerOnLine(Monster me){
		 Position mePosition = me.getPosition();
		 Position pPosition = me.getLevel().getPlayer().getPosition();
		 return (pPosition.x == mePosition.x || pPosition.x == mePosition.x -1 || pPosition.x == mePosition.x + 1 ||
				 pPosition.y == mePosition.y || pPosition.y == mePosition.y -1 || pPosition.y == mePosition.y + 1);
	 }
	 
	 private int starePlayer(Monster me){
		Player player = me.getLevel().getPlayer();
		Position mePosition = me.getPosition();
		if (player.isInvisible() || player.getPosition().z != me.getPosition().z)
			return -1;
		
		Position pp = player.getPosition();
		if (pp.x >= mePosition.x-1 && pp.x <= mePosition.x+1)
			if (pp.y >= mePosition.y+1)
				return Action.DOWN;
			else
				return Action.UP;
		else
			if (pp.y >= mePosition.y-1 && pp.y <= mePosition.y+1)
				if (pp.x >= mePosition.x+1)
					return Action.RIGHT;
				else
					return Action.LEFT;
			else
				return -1;
	 }
	 
}