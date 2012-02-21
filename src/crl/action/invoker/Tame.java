package crl.action.invoker;

import sz.util.Util;
import crl.action.HeartAction;
import crl.level.Level;
import crl.monster.Monster;
import crl.player.Consts;
import crl.player.Player;

public class Tame extends HeartAction{
	public String getID(){
		return "Tame";
	}
	
	public String getPromptPosition() {
		return "Who?";
	}

	public boolean needsPosition() {
		return true;
	}
	
	public int getHeartCost() {
		return 5;
	}
	
	public void execute(){
		super.execute();
		Level x = performer.getLevel();
		Monster m = x.getMonsterAt(targetPosition);
		int chance = 5+getPlayer().getSoulPower(); 
		if (getPlayer().getFlag("SKILL_SOULFORGE"))
			chance+=20;
		if (m == null){
			x.addMessage("Nothing happens.");
		} else {
			if (Util.chance(chance)){ 
				x.addMessage("You get the "+m.getDescription()+" soul on your side!");
				m.setCounter(Consts.C_MONSTER_CHARM, 2000000);
			} else {
				x.addMessage("You tried to get the "+m.getDescription()+" soul on your side.");
			}
			
		}
		
	}

	public String getSFX(){
		return "wav/clockbel.wav";
	}
	public double getTimeCostModifier() {
		return 3;
	}
};