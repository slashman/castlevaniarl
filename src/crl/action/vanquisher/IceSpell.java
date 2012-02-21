package crl.action.vanquisher;

import java.util.Vector;

import sz.util.Line;
import sz.util.Position;
import crl.action.Action;
import crl.action.ProjectileSkill;
import crl.actor.Actor;
import crl.level.Cell;
import crl.level.Level;
import crl.monster.Monster;
import crl.player.Player;
import crl.ui.effects.EffectFactory;

public class IceSpell extends ProjectileSkill{
	public int getDamage() {
		return 15+2*getPlayer().getSoulPower();
	}

	public int getHit() {
		return 100;
	}

	public int getPathType() {
		return PATH_LINEAR;
	}

	public int getRange() {
		return 5;
	}

	public String getSelfTargettedMessage() {
		return "You feel chilly";
	}

	public String getSFXID() {
		return "SFX_ICE_SPELL";
	}

	public String getShootMessage() {
		return "You invoke the spell of Ice!";
	}

	public String getSpellAttackDesc() {
		return "chilly wind";
	}

	public boolean piercesThru() {
		return true;
	}

	public int getHeartCost() {
		return 8;
	}

	public String getID(){
		return "IceSpell";
	}
	
	public void execute(){
		super.execute();
		Vector hitMonsters = getHitMonsters();
		for (int i = 0; i < hitMonsters.size(); i++){
			Monster targetMonster = (Monster) hitMonsters.elementAt(i);
			int friz = 10 +getPlayer().getSoulPower() - targetMonster.getFreezeResistance();
			if (friz > 0){
				if (targetMonster.wasSeen())
					targetMonster.getLevel().addMessage("The "+targetMonster.getDescription()+ " is frozen!");
				targetMonster.freeze(friz);
			} else
				if (targetMonster.wasSeen())
					targetMonster.getLevel().addMessage("The "+targetMonster.getDescription()+ " is too hot!");
			
		}
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.3);
	}
	
	public String getPromptPosition(){
		return "Where do you want to invoke the frost?";
	}
	
}