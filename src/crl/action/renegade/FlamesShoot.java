package crl.action.renegade;

import crl.action.BeamProjectileSkill;
import crl.player.Player;

public class FlamesShoot extends BeamProjectileSkill{
	
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
		return 15;
	}

	public String getSelfTargettedMessage() {
		return "The fireball flies to the heavens";
	}
	
	public boolean allowsSelfTarget() {
		return false;
	}

	public String getSFXID() {
		return "SFX_FLAMESSHOOT";
	}

	public String getShootMessage() {
		return "Three flame missiles emerge from your cape";
	}

	public String getSpellAttackDesc() {
		return "flames";
	}

	public int getHeartCost() {
		return 10;
	}

	public String getID(){
		return "FlamesShoot";
	}
	
	public String getSFX(){
		return "wav/fire.wav";
	}

	public int getCost(){
		Player p = (Player) performer;
		return (int)(p.getCastCost() * 1.1);
	}
	
	public String getPromptPosition(){
		return "Where do you want to throw the flames?";
	}
	
	
}