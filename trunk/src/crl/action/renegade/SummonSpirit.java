package crl.action.renegade;

import sz.util.Position;
import crl.action.Action;
import crl.action.ProjectileSkill;
import crl.actor.Actor;
import crl.level.Level;
import crl.monster.Monster;
import crl.monster.VMonster;
import crl.player.Player;
import crl.ui.effects.EffectFactory;

public class SummonSpirit extends ProjectileSkill{
	public int getDamage() {
		return 10+getPlayer().getSoulPower()*2;
	}

	public int getHit() {
		return 100;
	}

	public int getPathType() {
		return PATH_DIRECT;
	}

	public String getPromptPosition() {
		return "Where?";
	}

	public int getRange() {
		return 20;
	}

	public String getSelfTargettedMessage() {
		return "The spirit circles in an infinite spiral";
	}

	public String getSFXID() {
		return "SFX_SUMMON_SPIRIT";
	}

	public String getShootMessage() {
		return "You summon a white spirit!";
	}

	public String getSpellAttackDesc() {
		return "white spirit";
	}

	public int getHeartCost() {
		return 4;
	}

	public String getID(){
		return "SummonSpirit";
	}
	
	public String getSFX(){
		return "wav/scrch.wav";
	}
	
	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.6);
	}
}