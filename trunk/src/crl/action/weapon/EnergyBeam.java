package crl.action.weapon;

import sz.util.Line;
import sz.util.Position;
import crl.action.Action;
import crl.action.ProjectileSkill;
import crl.actor.Actor;
import crl.feature.Feature;
import crl.level.Level;
import crl.monster.Monster;
import crl.player.Player;
import crl.ui.effects.EffectFactory;

public class EnergyBeam extends ProjectileSkill{
	public int getDamage() {
		return 8 + getPlayer().getSoulPower()*5;
	}

	public int getHit() {
		return 100;
	}

	public int getPathType() {
		return PATH_LINEAR;
	}

	public int getRange() {
		return 15;
	}

	public String getSelfTargettedMessage() {
		return "The beam fissles";
	}

	public String getSFXID() {
		return "SFX_ENERGY_BEAM";
	}

	public String getShootMessage() {
		return "A beam of light rises from your weapon";
	}

	public String getSpellAttackDesc() {
		return "beam";
	}

	public int getHeartCost() {
		return 10;
	}

	public String getID(){
		return "EnergyBeam";
	}
	
	public String getPromptPosition(){
		return "Where do you want to point the staff at?";
	}

	public boolean piercesThru() {
		return true;
	}
	
	
}