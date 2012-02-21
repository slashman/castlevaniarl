package crl.action.vanquisher;

import sz.util.Line;
import sz.util.Position;
import crl.action.Action;
import crl.action.ProjectileSkill;
import crl.actor.Actor;
import crl.feature.Feature;
import crl.level.Cell;
import crl.level.Level;
import crl.monster.Monster;
import crl.player.Player;
import crl.ui.effects.EffectFactory;

public class FlameSpell extends ProjectileSkill{
	public int getDamage() {
		return 15+getPlayer().getSoulPower()*2;
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
		return "You make a flame pillar!";
	}

	public String getSFXID() {
		return "SFX_FLAME_SPELL";
	}

	public String getShootMessage() {
		return "You invoke the spell of Flame!";
	}

	public String getSpellAttackDesc() {
		return "flame";
	}

	public boolean piercesThru() {
		return true;
	}

	public int getHeartCost() {
		return 8;
	}

	public String getID(){
		return "FlameSpell";
	}
	
	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.3);
	}
	
	public String getPromptPosition(){
		return "Where do you want to invoke the flame?";
	}
	
}